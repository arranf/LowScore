
package party.hunchbacktank.isthereanydeal.model.steam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sub {

    @SerializedName("packageid")
    @Expose
    private int packageid;
    @SerializedName("percent_savings_text")
    @Expose
    private String percentSavingsText;
    @SerializedName("percent_savings")
    @Expose
    private int percentSavings;
    @SerializedName("option_text")
    @Expose
    private String optionText;
    @SerializedName("option_description")
    @Expose
    private String optionDescription;
    @SerializedName("can_get_free_license")
    @Expose
    private String canGetFreeLicense;
    @SerializedName("is_free_license")
    @Expose
    private boolean isFreeLicense;
    @SerializedName("price_in_cents_with_discount")
    @Expose
    private int priceInCentsWithDiscount;

    /**
     * 
     * @return
     *     The packageid
     */
    public int getPackageid() {
        return packageid;
    }

    /**
     * 
     * @param packageid
     *     The packageid
     */
    public void setPackageid(int packageid) {
        this.packageid = packageid;
    }

    /**
     * 
     * @return
     *     The percentSavingsText
     */
    public String getPercentSavingsText() {
        return percentSavingsText;
    }

    /**
     * 
     * @param percentSavingsText
     *     The percent_savings_text
     */
    public void setPercentSavingsText(String percentSavingsText) {
        this.percentSavingsText = percentSavingsText;
    }

    /**
     * 
     * @return
     *     The percentSavings
     */
    public int getPercentSavings() {
        return percentSavings;
    }

    /**
     * 
     * @param percentSavings
     *     The percent_savings
     */
    public void setPercentSavings(int percentSavings) {
        this.percentSavings = percentSavings;
    }

    /**
     * 
     * @return
     *     The optionText
     */
    public String getOptionText() {
        return optionText;
    }

    /**
     * 
     * @param optionText
     *     The option_text
     */
    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    /**
     * 
     * @return
     *     The optionDescription
     */
    public String getOptionDescription() {
        return optionDescription;
    }

    /**
     * 
     * @param optionDescription
     *     The option_description
     */
    public void setOptionDescription(String optionDescription) {
        this.optionDescription = optionDescription;
    }

    /**
     * 
     * @return
     *     The canGetFreeLicense
     */
    public String getCanGetFreeLicense() {
        return canGetFreeLicense;
    }

    /**
     * 
     * @param canGetFreeLicense
     *     The can_get_free_license
     */
    public void setCanGetFreeLicense(String canGetFreeLicense) {
        this.canGetFreeLicense = canGetFreeLicense;
    }

    /**
     * 
     * @return
     *     The isFreeLicense
     */
    public boolean isIsFreeLicense() {
        return isFreeLicense;
    }

    /**
     * 
     * @param isFreeLicense
     *     The is_free_license
     */
    public void setIsFreeLicense(boolean isFreeLicense) {
        this.isFreeLicense = isFreeLicense;
    }

    /**
     * 
     * @return
     *     The priceInCentsWithDiscount
     */
    public int getPriceInCentsWithDiscount() {
        return priceInCentsWithDiscount;
    }

    /**
     * 
     * @param priceInCentsWithDiscount
     *     The price_in_cents_with_discount
     */
    public void setPriceInCentsWithDiscount(int priceInCentsWithDiscount) {
        this.priceInCentsWithDiscount = priceInCentsWithDiscount;
    }

}
