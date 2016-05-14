
package party.hunchbacktank.lowscore.model.steam.appdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReleaseDate {

    @SerializedName("coming_soon")
    @Expose
    private boolean comingSoon;
    @SerializedName("date")
    @Expose
    private String date;

    /**
     * 
     * @return
     *     The comingSoon
     */
    public boolean isComingSoon() {
        return comingSoon;
    }

    /**
     * 
     * @param comingSoon
     *     The coming_soon
     */
    public void setComingSoon(boolean comingSoon) {
        this.comingSoon = comingSoon;
    }

    /**
     * 
     * @return
     *     The date
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(String date) {
        this.date = date;
    }

}
