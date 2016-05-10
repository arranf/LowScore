
package party.hunchbacktank.isthereanydeal.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Game {
    private long id;
    private String title;
    private String plain;
    @SerializedName("greenlight")
    private boolean isGreenlight;
    @SerializedName("is_package")
    private boolean isPackage;
    @SerializedName("is_dlc")
    private boolean isDLC;
    @SerializedName("achievements")
    private boolean hasAchievements;
    @SerializedName("trading_cards")
    private boolean hasTradingcards;
    @SerializedName("early_access")
    private boolean isEarlyAccess;
    private ArrayList<Review> reviews;
}
