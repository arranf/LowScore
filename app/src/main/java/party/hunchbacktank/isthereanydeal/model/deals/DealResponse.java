
package party.hunchbacktank.isthereanydeal.model.deals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DealResponse {

    @SerializedName(".meta")
    @Expose
    private Meta Meta;
    @SerializedName("data")
    @Expose
    private Data data;

    /**
     * 
     * @return
     *     The Meta
     */
    public Meta getMeta() {
        return Meta;
    }

    /**
     * 
     * @param Meta
     *     The .meta
     */
    public void setMeta(Meta Meta) {
        this.Meta = Meta;
    }

    /**
     * 
     * @return
     *     The data
     */
    public Data getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The data
     */
    public void setData(Data data) {
        this.data = data;
    }

}
