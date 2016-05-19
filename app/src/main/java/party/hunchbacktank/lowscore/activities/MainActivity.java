package party.hunchbacktank.lowscore.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import party.hunchbacktank.lowscore.BuildConfig;
import party.hunchbacktank.lowscore.R;
import party.hunchbacktank.lowscore.adapters.DealsAdapter;
import party.hunchbacktank.lowscore.model.isthereanydeal.recommendeddeal.Deal;
import party.hunchbacktank.lowscore.model.isthereanydeal.recommendeddeal.DealResponse;
import party.hunchbacktank.lowscore.networking.isthereanydeal.DealEndpoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity  {
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.toolbar) Toolbar toolbar;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Deal> deals = new ArrayList<>();
    private final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setTitle("Recommended Deals");
        setSupportActionBar(toolbar);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_run), false);
        if(!previouslyStarted) {
            SharedPreferences.Editor edit = prefs.edit();
            edit.putBoolean(getString(R.string.pref_previously_run), Boolean.TRUE);
            edit.apply();
            doMigration();
        }
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //TODO Rewrite the adapter for our needs
        adapter = new DealsAdapter(recyclerView, deals);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        getDeals();

    }

    @Override
    protected void onResume(){
        super.onResume();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

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
            getDeals(true);
        }

        return super.onOptionsItemSelected(item);
    }

    private void doMigration(){
        startActivity(new Intent(this, MigrationActivity.class));
    }

    public void getDeals(){
        getDeals(false);
    }

    public void getDeals(final boolean refresh) {
        Log.d(TAG, "Fetching deals");
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.isthereanydeal.com")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        DealEndpoint dealEndpoint = retrofit.create(DealEndpoint.class);

        String apiKey = BuildConfig.API_KEY;
        Call<DealResponse> call = dealEndpoint.fetch("uk", apiKey, "uk", 0);
        call.enqueue(new Callback<DealResponse>() {
            @Override
            public void onResponse(Call<DealResponse> call, retrofit2.Response<DealResponse> response) {
                if (response.body() != null) {
                    List<Deal> dealList = response.body().getData().getDeals();
                    if (refresh && !deals.isEmpty()){
                        deals.clear();
                    }
                    for (Deal deal: dealList) {
                        deals.add(deal);
                        adapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<DealResponse> call, Throwable e) {
                e.printStackTrace();
                //TODO Prompt for second attempt, explain error to user
            }
        });

    }

}
