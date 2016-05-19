package party.hunchbacktank.lowscore.model.isthereanydeal.prices;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Arran on 19/05/2016.
 */
public class Meta {
    @SerializedName("currency")
    @Expose
    private String currency;

    /**
     *
     * @return
     * The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     *
     * @param currency
     * The currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
