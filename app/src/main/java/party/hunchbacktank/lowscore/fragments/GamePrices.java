package party.hunchbacktank.lowscore.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import party.hunchbacktank.lowscore.BuildConfig;
import party.hunchbacktank.lowscore.R;
import party.hunchbacktank.lowscore.adapters.PricesAdapter;
import party.hunchbacktank.lowscore.model.isthereanydeal.prices.Price;
import party.hunchbacktank.lowscore.model.isthereanydeal.prices.PriceResponse;
import party.hunchbacktank.lowscore.networking.isthereanydeal.PricesEndpoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GamePrices extends Fragment {
    private static final String TAG = "GamePrices";

    @BindView(R.id.recycler_view_prices)
    protected RecyclerView recyclerView;
    protected PricesAdapter pricesAdapter;
    protected RecyclerView.LayoutManager layoutManager;
    protected List<Price> prices = new ArrayList<Price>() {};
    String plain;

    public GamePrices(){}

    public static GamePrices newInstance(String plain){
        GamePrices gamePrices = new GamePrices();
        Bundle args = new Bundle();
        args.putString("plain", plain);
        gamePrices.setArguments(args);
        return gamePrices;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey("plain") && getArguments().get("plain") != null) {
            plain = getArguments().get("plain").toString();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_game_prices, container, false);
        ButterKnife.bind(this, rootView);
        rootView.setTag(TAG);
        if (savedInstanceState != null || plain != null) {
            plain = getArguments().getString("plain");
            pricesAdapter = new PricesAdapter(recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(pricesAdapter);
            getPrices();
        }
        return rootView;
    }

    private void getPrices(){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(getString(R.string.itad_api))
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        PricesEndpoint pricesEndpoint = retrofit.create(PricesEndpoint.class);
        Call<PriceResponse> call = pricesEndpoint.fetchSingle(BuildConfig.API_KEY, "uk", plain);
        call.enqueue(new Callback<PriceResponse>() {
            @Override
            public void onResponse(Call<PriceResponse> call, retrofit2.Response<PriceResponse> response) {
                if (response.body() != null) {
                    pricesAdapter.setPrices(response.body().getData().get(plain).getPrices());
                }
            }

            @Override
            public void onFailure(Call<PriceResponse> call, Throwable e) {
                e.printStackTrace();
                //TODO Prompt for second attempt, explain error to user
            }
        });
    }
}
