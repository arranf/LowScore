package party.hunchbacktank.lowscore.model.isthereanydeal.prices;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Created by Arran on 19/05/2016.
 */
public class Contents {
    @SerializedName("list")
    List<Price> prices;

    @SerializedName("urls")
    Urls url;

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public Urls getUrl() {
        return url;
    }

    public void setUrl(Urls url) {
        this.url = url;
    }
}
