package party.hunchbacktank.isthereanydeal.networking.deal;

import party.hunchbacktank.isthereanydeal.model.deals.DealResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;

/**
 * Created by Arran on 14/03/2016.
 */
public interface DealEndpoint {
    @GET("/v01/deals/list")
    Call<DealResponse> fetch(@Field("region") String region, @Field("key") String apiKey, @Field("country") String country, @Field("offset") int offset, @Field("limit") int limit);
}
