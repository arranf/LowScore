package party.hunchbacktank.isthereanydeal.networking.deal;

import party.hunchbacktank.isthereanydeal.model.deals.DealResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Arran on 14/03/2016.
 */
public interface DealEndpoint {
    @GET("/v01/deals/list?limit=20")
    Call<DealResponse> fetch(@Query("region") String region, @Query("key") String apiKey, @Query("country") String country, @Query("offset") int offset);
}
