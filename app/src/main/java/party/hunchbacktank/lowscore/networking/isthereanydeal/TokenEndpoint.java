package party.hunchbacktank.lowscore.networking.isthereanydeal;

import party.hunchbacktank.lowscore.model.isthereanydeal.authentication.Token;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Arran on 14/03/2016.
 */
public interface TokenEndpoint {
    @FormUrlEncoded
    @POST("/oauth/token")
    Call<Token> authorise(@Field("grant_type") String grantType, @Field("code") String code, @Field("client_id") String clientId, @Field("client_secret") String clientSecret, @Field("redirect_uri") String redirectUri);

    @FormUrlEncoded
    @POST("/oauth/token")
    Call<Token> refresh(@Field("grant_type") String grantType, @Field("refresh_token") String code, @Field("client_id") String clientId, @Field("client_secret") String clientSecret);

}
