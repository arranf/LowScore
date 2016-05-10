package party.hunchbacktank.isthereanydeal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import party.hunchbacktank.isthereanydeal.data.adapter.DealsAdapter;
import party.hunchbacktank.isthereanydeal.model.deals.Deal;
import party.hunchbacktank.isthereanydeal.model.deals.DealResponse;
import party.hunchbacktank.isthereanydeal.networking.deal.DealEndpoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Deal> deals = new ArrayList<>();
    private final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Recommended Deals");

        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //TODO Rewrite the adapter for our needs
        adapter = new DealsAdapter(recyclerView, deals);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
            getDeals();
        }

        return super.onOptionsItemSelected(item);
    }

    public void getDeals() {
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
