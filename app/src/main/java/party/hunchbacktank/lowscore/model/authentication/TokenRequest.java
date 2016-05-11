package party.hunchbacktank.lowscore.model.authentication;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Arran on 14/03/2016.
 */
public class TokenRequest {
    @SerializedName("refresh_token")
    private String refreshToken;
    private String code;
    @SerializedName("redirect_uri")
    private String redirectUri;
    @SerializedName("client_id")
    private String clientId;
    @SerializedName("client_secret")
    private String clientSecret;
    @SerializedName("grant_type")
    private transient TokenRequestType type;

    public TokenRequest(TokenRequestType type, String code, String redirectUri, String clientId, String clientSecret) {
        this.type = type;
        this.code = code;
        this.redirectUri = redirectUri;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public TokenRequestType getType() {
        return type;
    }

    public void setType(TokenRequestType type) {
        this.type = type;
    }
}
