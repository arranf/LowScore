package party.hunchbacktank.lowscore.model;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;
import party.hunchbacktank.lowscore.model.realm.RealmString;

/**
 * Created by Arran on 18/05/2016.
 */
public class Game extends RealmObject {
    @Required
    @Index
    @PrimaryKey
    private String plain;
    private int steamAppId;
    private int gogId;
    private String originId;
    @Required
    @Index
    private String title;
    private String description;
    private String publisher;
    private String developer;
    private Date releaseDate;

    private RealmList<Review> reviews;
    //TODO Implement GSON adapter
/* Implemented as objects as suggested by Realm guy from SO
Gist explains how: https://gist.github.com/cmelchior/1a97377df0c49cd4fca9 */
    private RealmList<RealmString> genres;
    private RealmList<RealmString> supportedLanguages;
    private String headerImage;
    private String website;
    private boolean isEarly;
    private boolean isDLC;
    private boolean isSingleplayer;
    private boolean isMultiplayer;
    private boolean isCoop;
    private boolean hasVRSupport;
    private String controllerSupport;
    private boolean hasSteamCloud;
    private boolean hasSteasmWorkshop;
    private boolean hasLevelEditor;

    //Steam Specific
    private boolean hasAchievements;
    private boolean hasTradingcards;
    private boolean hasLeaderboards;

    //GOG Specific
    private RealmList<RealmString> bonuses;

    public String getPlain() {
        return plain;
    }

    public void setPlain(String plain) {
        this.plain = plain;
    }

    public int getSteamAppId() {
        return steamAppId;
    }

    public void setSteamAppId(int steamAppId) {
        this.steamAppId = steamAppId;
    }

    public int getGogId() {
        return gogId;
    }

    public void setGogId(int gogId) {
        this.gogId = gogId;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public RealmList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(RealmList<Review> reviews) {
        this.reviews = reviews;
    }

    public RealmList<RealmString> getGenres() {
        return genres;
    }

    public void setGenres(RealmList<RealmString> genres) {
        this.genres = genres;
    }

    public RealmList<RealmString> getSupportedLanguages() {
        return supportedLanguages;
    }

    public void setSupportedLanguages(RealmList<RealmString> supportedLanguages) {
        this.supportedLanguages = supportedLanguages;
    }

    public String getHeaderImage() {
        return headerImage;
    }

    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isEarly() {
        return isEarly;
    }

    public void setEarly(boolean early) {
        isEarly = early;
    }

    public boolean isDLC() {
        return isDLC;
    }

    public void setDLC(boolean DLC) {
        isDLC = DLC;
    }

    public boolean isSingleplayer() {
        return isSingleplayer;
    }

    public void setSingleplayer(boolean singleplayer) {
        isSingleplayer = singleplayer;
    }

    public boolean isMultiplayer() {
        return isMultiplayer;
    }

    public void setMultiplayer(boolean multiplayer) {
        isMultiplayer = multiplayer;
    }

    public boolean isCoop() {
        return isCoop;
    }

    public void setCoop(boolean coop) {
        isCoop = coop;
    }

    public boolean isHasVRSupport() {
        return hasVRSupport;
    }

    public void setHasVRSupport(boolean hasVRSupport) {
        this.hasVRSupport = hasVRSupport;
    }

    public String getControllerSupport() {
        return controllerSupport;
    }

    public void setControllerSupport(String controllerSupport) {
        this.controllerSupport = controllerSupport;
    }

    public boolean isHasSteamCloud() {
        return hasSteamCloud;
    }

    public void setHasSteamCloud(boolean hasSteamCloud) {
        this.hasSteamCloud = hasSteamCloud;
    }

    public boolean isHasSteasmWorkshop() {
        return hasSteasmWorkshop;
    }

    public void setHasSteasmWorkshop(boolean hasSteasmWorkshop) {
        this.hasSteasmWorkshop = hasSteasmWorkshop;
    }

    public boolean isHasLevelEditor() {
        return hasLevelEditor;
    }

    public void setHasLevelEditor(boolean hasLevelEditor) {
        this.hasLevelEditor = hasLevelEditor;
    }

    public boolean isHasAchievements() {
        return hasAchievements;
    }

    public void setHasAchievements(boolean hasAchievements) {
        this.hasAchievements = hasAchievements;
    }

    public boolean isHasTradingcards() {
        return hasTradingcards;
    }

    public void setHasTradingcards(boolean hasTradingcards) {
        this.hasTradingcards = hasTradingcards;
    }

    public boolean isHasLeaderboards() {
        return hasLeaderboards;
    }

    public void setHasLeaderboards(boolean hasLeaderboards) {
        this.hasLeaderboards = hasLeaderboards;
    }

    public RealmList<RealmString> getBonuses() {
        return bonuses;
    }

    public void setBonuses(RealmList<RealmString> bonuses) {
        this.bonuses = bonuses;
    }
}