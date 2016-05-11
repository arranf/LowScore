
package party.hunchbacktank.lowscore.model.steam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PriceOverview {

    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("initial")
    @Expose
    private int initial;
    @SerializedName("final")
    @Expose
    private int _final;
    @SerializedName("discount_percent")
    @Expose
    private int discountPercent;

    /**
     * 
     * @return
     *     The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 
     * @param currency
     *     The currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * 
     * @return
     *     The initial
     */
    public int getInitial() {
        return initial;
    }

    /**
     * 
     * @param initial
     *     The initial
     */
    public void setInitial(int initial) {
        this.initial = initial;
    }

    /**
     * 
     * @return
     *     The _final
     */
    public int getFinal() {
        return _final;
    }

    /**
     * 
     * @param _final
     *     The final
     */
    public void setFinal(int _final) {
        this._final = _final;
    }

    /**
     * 
     * @return
     *     The discountPercent
     */
    public int getDiscountPercent() {
        return discountPercent;
    }

    /**
     * 
     * @param discountPercent
     *     The discount_percent
     */
    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

}
