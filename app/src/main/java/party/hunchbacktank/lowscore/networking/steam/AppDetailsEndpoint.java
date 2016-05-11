package party.hunchbacktank.lowscore.networking.steam;

import java.util.Map;

import party.hunchbacktank.lowscore.model.steam.AppDetail;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Arran on 10/05/2016.
 */
public interface AppDetailsEndpoint {
    @GET("appdetails")
    Call<Map<String, AppDetail>> get(@Query("appids") String appid);

}
