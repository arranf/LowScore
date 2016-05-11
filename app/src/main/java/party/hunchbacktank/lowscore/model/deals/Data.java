
package party.hunchbacktank.lowscore.model.deals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Data {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("list")
    @Expose
    private java.util.List<Deal> deals = new ArrayList<Deal>();
    @SerializedName("urls")
    @Expose
    private Tag urls;

    /**
     * 
     * @return
     *     The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 
     * @return
     *     The deals
     */
    public java.util.List<Deal> getDeals() {
        return deals;
    }

    /**
     * 
     * @param deals
     *     The deals
     */
    public void setDeals(java.util.List<Deal> deals) {
        this.deals = deals;
    }

    /**
     * 
     * @return
     *     The urls
     */
    public Tag getUrls() {
        return urls;
    }

    /**
     * 
     * @param urls
     *     The urls
     */
    public void setUrls(Tag urls) {
        this.urls = urls;
    }

}
