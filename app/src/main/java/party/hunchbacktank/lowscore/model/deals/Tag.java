
package party.hunchbacktank.lowscore.model.deals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tag {

    @SerializedName("deals")
    @Expose
    private String deals;

    /**
     * 
     * @return
     *     The deals
     */
    public String getDeals() {
        return deals;
    }

    /**
     * 
     * @param deals
     *     The deals
     */
    public void setDeals(String deals) {
        this.deals = deals;
    }

}
