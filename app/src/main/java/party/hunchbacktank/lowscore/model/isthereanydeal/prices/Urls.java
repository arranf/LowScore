package party.hunchbacktank.lowscore.model.isthereanydeal.prices;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Arran on 19/05/2016.
 */
public class Urls {
    @SerializedName("game")
    @Expose
    private String game;

    /**
     *
     * @return
     * The game
     */
    public String getGame() {
        return game;
    }

    /**
     *
     * @param game
     * The game
     */
    public void setGame(String game) {
        this.game = game;
    }
}
