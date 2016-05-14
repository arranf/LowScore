
package party.hunchbacktank.lowscore.model.steam.appdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PcRequirements {

    @SerializedName("minimum")
    @Expose
    private String minimum;
    @SerializedName("recommended")
    @Expose
    private String recommended;

    /**
     * 
     * @return
     *     The minimum
     */
    public String getMinimum() {
        return minimum;
    }

    /**
     * 
     * @param minimum
     *     The minimum
     */
    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

    /**
     * 
     * @return
     *     The recommended
     */
    public String getRecommended() {
        return recommended;
    }

    /**
     * 
     * @param recommended
     *     The recommended
     */
    public void setRecommended(String recommended) {
        this.recommended = recommended;
    }

}
