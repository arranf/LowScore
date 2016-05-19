package party.hunchbacktank.lowscore.model.isthereanydeal.prices;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import party.hunchbacktank.lowscore.model.isthereanydeal.recommendeddeal.Shop;

/**
 * Created by Arran on 19/05/2016.
 */
public class Price {
    @SerializedName("price_new")
    @Expose
    private Double priceNew;
    @SerializedName("price_old")
    @Expose
    private Double priceOld;
    @SerializedName("price_cut")
    @Expose
    private Integer priceCut;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("shop")
    @Expose
    private Shop shop;
    @SerializedName("drm")
    @Expose
    private java.util.List<String> drm = new ArrayList<String>();

    /**
     *
     * @return
     * The priceNew
     */
    public Double getPriceNew() {
        return priceNew;
    }

    /**
     *
     * @param priceNew
     * The price_new
     */
    public void setPriceNew(Double priceNew) {
        this.priceNew = priceNew;
    }

    /**
     *
     * @return
     * The priceOld
     */
    public Double getPriceOld() {
        return priceOld;
    }

    /**
     *
     * @param priceOld
     * The price_old
     */
    public void setPriceOld(Double priceOld) {
        this.priceOld = priceOld;
    }

    /**
     *
     * @return
     * The priceCut
     */
    public Integer getPriceCut() {
        return priceCut;
    }

    /**
     *
     * @param priceCut
     * The price_cut
     */
    public void setPriceCut(Integer priceCut) {
        this.priceCut = priceCut;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The shop
     */
    public Shop getShop() {
        return shop;
    }

    /**
     *
     * @param shop
     * The shop
     */
    public void setShop(Shop shop) {
        this.shop = shop;
    }

    /**
     *
     * @return
     * The drm
     */
    public java.util.List<String> getDrm() {
        return drm;
    }

    /**
     *
     * @param drm
     * The drm
     */
    public void setDrm(java.util.List<String> drm) {
        this.drm = drm;
    }
}
