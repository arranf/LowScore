
package party.hunchbacktank.lowscore.model.steam.appdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Achievements {

    @SerializedName("total")
    @Expose
    private int total;
    @SerializedName("highlighted")
    @Expose
    private List<Highlighted> highlighted = new ArrayList<Highlighted>();

    /**
     * 
     * @return
     *     The total
     */
    public int getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * 
     * @return
     *     The highlighted
     */
    public List<Highlighted> getHighlighted() {
        return highlighted;
    }

    /**
     * 
     * @param highlighted
     *     The highlighted
     */
    public void setHighlighted(List<Highlighted> highlighted) {
        this.highlighted = highlighted;
    }

}
