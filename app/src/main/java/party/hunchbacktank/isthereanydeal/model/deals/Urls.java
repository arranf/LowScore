
package party.hunchbacktank.isthereanydeal.model.deals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Urls {

    @SerializedName("buy")
    @Expose
    private String buy;
    @SerializedName("game")
    @Expose
    private String game;

    /**
     * 
     * @return
     *     The buy
     */
    public String getBuy() {
        return buy;
    }

    /**
     * 
     * @param buy
     *     The buy
     */
    public void setBuy(String buy) {
        this.buy = buy;
    }

    /**
     * 
     * @return
     *     The game
     */
    public String getGame() {
        return game;
    }

    /**
     * 
     * @param game
     *     The game
     */
    public void setGame(String game) {
        this.game = game;
    }

}
