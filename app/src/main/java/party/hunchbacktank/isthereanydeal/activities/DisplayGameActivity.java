package party.hunchbacktank.isthereanydeal.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTouch;
import party.hunchbacktank.isthereanydeal.R;
import party.hunchbacktank.isthereanydeal.display.PicassoSwitcherHelper;
import party.hunchbacktank.isthereanydeal.display.ViewPagerAdapter;
import party.hunchbacktank.isthereanydeal.fragments.GameInfo;
import party.hunchbacktank.isthereanydeal.fragments.GamePrices;
import party.hunchbacktank.isthereanydeal.model.steam.AppDetail;
import party.hunchbacktank.isthereanydeal.model.steam.Screenshot;
import party.hunchbacktank.isthereanydeal.networking.steam.AppDetailsEndpoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DisplayGameActivity extends AppCompatActivity implements GamePrices.OnFragmentInteractionListener{
    @BindView(R.id.gamescreens) ImageSwitcher imageSwitcher;
    private PicassoSwitcherHelper picassoSwitcherHelper;
    private List<Uri> imageUris = new ArrayList<>();
    private int currentScrenshot;

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.game_detail_tabs) TabLayout tabLayout;
    @BindView(R.id.game_detail_viewpager) ViewPager viewPager;

    private ViewPagerAdapter viewPagerAdapter;
    private float x1;
    static final int MIN_DISTANCE = 150;
    private String plain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_game);
        ButterKnife.bind(this);

        //Toolbar
        plain = getIntent().getStringExtra("plainName");
        setSupportActionBar(toolbar);

        //Image Switcher
        setupImageSwitcher();
        picassoSwitcherHelper = new PicassoSwitcherHelper(this, imageSwitcher);
        getAppDetails(plain);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onResume(){
        super.onResume();

    }

    //region LoadInfo
    private void getAppDetails(String plain){
        Retrofit.Builder builder = new Retrofit.Builder()
                //TODO Change the string resource to butterknife
                .baseUrl(getString(R.string.steam_api_base))
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        AppDetailsEndpoint appDetailsEndpoint = retrofit.create(AppDetailsEndpoint.class);

        //TODO Change this to get a real Steam App Id
        final String appid = "252950";
        Call<Map<String, AppDetail>> call = appDetailsEndpoint.get(appid);
        call.enqueue(new Callback<Map<String, AppDetail>>() {
            @Override
            public void onResponse(Call<Map<String, AppDetail>> call, retrofit2.Response<Map<String, AppDetail>> response) {
                if (response.body() != null) {
                    AppDetail appDetail = response.body().get(appid);
                    setUI(appDetail);
                }
            }

            @Override
            public void onFailure(Call<Map<String, AppDetail>> call, Throwable e) {
                e.printStackTrace();
                //TODO Prompt for second attempt, explain error to user
            }
        });
    }

    public void setUI(AppDetail appDetail) {
        toolbar.setTitle(appDetail.getData().getName());
        List<Screenshot> screenshots = appDetail.getData().getScreenshots();
        if (screenshots != null) {
            for (Screenshot screenshot : screenshots) {
                imageUris.add(Uri.parse(screenshot.getPathFull()));
            }
            Picasso.with(this).load(imageUris.get(0))
                    .into(picassoSwitcherHelper);
            currentScrenshot = 0;
        }
    }
    //endregion

    //region ImageSwitcher
    protected void setupImageSwitcher() {
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
                ImageView view = new ImageView(getApplicationContext());
                view.setScaleType(ImageView.ScaleType.FIT_CENTER);
                view.setLayoutParams(new ImageSwitcher.LayoutParams(ImageSwitcher.LayoutParams.MATCH_PARENT,ImageSwitcher.LayoutParams.MATCH_PARENT));
                //Makes the image float to the top like we want
                view.setAdjustViewBounds(true);
                return view;
            }
        });
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);
    }
    //http://stackoverflow.com/questions/6645537/how-to-detect-the-swipe-left-or-right-in-android
    @OnTouch(R.id.gamescreens)
    public boolean onTouch(View v, MotionEvent event) {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                Float x2 = event.getX();
                float deltaX = x2 - x1;

                if (Math.abs(deltaX) > MIN_DISTANCE)
                {
                    // Left to Right swipe action
                    if (x2 > x1 )
                    {
                        if (imageUris !=null && currentScrenshot > 0) {
                            currentScrenshot--;
                            Picasso.with(this).load(imageUris.get(currentScrenshot))
                                    .into(picassoSwitcherHelper);
                        }
                    }

                    // Right to left swipe action
                    else if (imageUris != null && currentScrenshot < imageUris.size() )
                    {
                        currentScrenshot++;
                        Picasso.with(this).load(imageUris.get(currentScrenshot))
                                .into(picassoSwitcherHelper);
                    }

                }
                else
                {
                    // consider as something else - a screen tap for example
                }
                break;
        }
        return true;
    }
    //endregion

    //region Tabs
    private void setupViewPager(ViewPager viewPager) {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new GamePrices(), "Stores");
        viewPagerAdapter.addFragment(new GameInfo(), "Info");
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri){

    }
    //endregion

    //region Menu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_refresh){
           getAppDetails(plain);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //endregion


}
