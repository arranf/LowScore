
package party.hunchbacktank.lowscore.model.steam.appdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SupportInfo {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("email")
    @Expose
    private String email;

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
