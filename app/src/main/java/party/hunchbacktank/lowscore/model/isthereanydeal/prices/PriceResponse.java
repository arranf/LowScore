package party.hunchbacktank.lowscore.model.isthereanydeal.prices;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by Arran on 19/05/2016.
 */
public class PriceResponse {
    @SerializedName(".meta")
    @Expose
    private Meta Meta;
    @SerializedName("data")
    @Expose
    private Map<String, Contents> data;

    /**
     *
     * @return
     * The Meta
     */
    public Meta getMeta() {
        return Meta;
    }

    /**
     *
     * @param meta
     * The .meta
     */
    public void setMeta(Meta meta) {
        this.Meta = meta;
    }

    /**
     *
     * @return
     * The data
     */
    public Map<String, Contents> getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(Map<String, Contents> data) {
        this.data = data;
    }
}
