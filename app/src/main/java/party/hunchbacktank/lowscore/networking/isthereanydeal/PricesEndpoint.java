package party.hunchbacktank.lowscore.networking.isthereanydeal;

import party.hunchbacktank.lowscore.model.isthereanydeal.prices.PriceResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Arran on 19/05/2016.
 */
public interface PricesEndpoint {
    @GET("/v01/game/prices")
    Call<PriceResponse> fetchSingle(@Query("key") String apiKey, @Query("country") String country, @Query("plains") String plain);
}