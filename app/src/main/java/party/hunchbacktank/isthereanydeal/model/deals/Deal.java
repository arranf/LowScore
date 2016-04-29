
package party.hunchbacktank.isthereanydeal.model.deals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Deal {

    @SerializedName("plain")
    @Expose
    private String plain;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("price_new")
    @Expose
    private Double priceNew;
    @SerializedName("price_old")
    @Expose
    private Double priceOld;
    @SerializedName("price_cut")
    @Expose
    private Integer priceCut;
    @SerializedName("added")
    @Expose
    private Integer added;
    @SerializedName("shop")
    @Expose
    private Shop shop;
    @SerializedName("drm")
    @Expose
    private java.util.List<String> drm = new ArrayList<String>();
    @SerializedName("urls")
    @Expose
    private Urls urls;

    /**
     * 
     * @return
     *     The plain
     */
    public String getPlain() {
        return plain;
    }

    /**
     * 
     * @param plain
     *     The plain
     */
    public void setPlain(String plain) {
        this.plain = plain;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The priceNew
     */
    public Double getPriceNew() {
        return priceNew;
    }

    /**
     * 
     * @param priceNew
     *     The price_new
     */
    public void setPriceNew(Double priceNew) {
        this.priceNew = priceNew;
    }

    /**
     * 
     * @return
     *     The priceOld
     */
    public Double getPriceOld() {
        return priceOld;
    }

    /**
     * 
     * @param priceOld
     *     The price_old
     */
    public void setPriceOld(Double priceOld) {
        this.priceOld = priceOld;
    }

    /**
     * 
     * @return
     *     The shop
     */
    public Integer getPriceCut() {
        return priceCut;
    }

    /**
     * 
     * @param priceCut
     *     The price_cut
     */
    public void setPriceCut(Integer priceCut) {
        this.priceCut = priceCut;
    }

    /**
     * 
     * @return
     *     The added
     */
    public Integer getAdded() {
        return added;
    }

    /**
     * 
     * @param added
     *     The added
     */
    public void setAdded(Integer added) {
        this.added = added;
    }

    /**
     * 
     * @return
     *     The shop
     */
    public Shop getShop() {
        return shop;
    }

    /**
     * 
     * @param shop
     *     The shop
     */
    public void setShop(Shop shop) {
        this.shop = shop;
    }

    /**
     * 
     * @return
     *     The drm
     */
    public java.util.List<String> getDrm() {
        return drm;
    }

    /**
     * 
     * @param drm
     *     The drm
     */
    public void setDrm(java.util.List<String> drm) {
        this.drm = drm;
    }

    /**
     * 
     * @return
     *     The urls
     */
    public Urls getUrls() {
        return urls;
    }

    /**
     * 
     * @param urls
     *     The urls
     */
    public void setUrls(Urls urls) {
        this.urls = urls;
    }

}
