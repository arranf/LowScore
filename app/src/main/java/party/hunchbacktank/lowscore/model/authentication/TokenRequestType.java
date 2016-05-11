package party.hunchbacktank.lowscore.model.authentication;

/**
 * Created by Arran on 28/04/2016.
 */
public enum TokenRequestType {
    REFRESH("refresh_token"),
    CODE("authorization_code");

    private final String grantType;

    TokenRequestType(String grantType) {
        this.grantType = grantType;
    }

    @Override
    public String toString(){
        return grantType;
    }
}
