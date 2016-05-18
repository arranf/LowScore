
package party.hunchbacktank.lowscore.model.steam.appdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("steam_appid")
    @Expose
    private int steamAppid;
    @SerializedName("required_age")
    @Expose
    private int requiredAge;
    @SerializedName("is_free")
    @Expose
    private boolean isFree;
    @SerializedName("controller_support")
    @Expose
    private String controllerSupport;
    @SerializedName("dlc")
    @Expose
    private List<Integer> dlc = new ArrayList<Integer>();
    @SerializedName("detailed_description")
    @Expose
    private String detailedDescription;
    @SerializedName("about_the_game")
    @Expose
    private String aboutTheGame;
    @SerializedName("supported_languages")
    @Expose
    private String supportedLanguages;
    @SerializedName("header_image")
    @Expose
    private String headerImage;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("pc_requirements")
    @Expose
    private Requirements pcRequirements;
    @SerializedName("mac_requirements")
    @Expose
    private Requirements macRequirements;
    @SerializedName("linux_requirements")
    @Expose
    private Requirements linuxRequirements;
    @SerializedName("legal_notice")
    @Expose
    private String legalNotice;
    @SerializedName("developers")
    @Expose
    private List<String> developers = new ArrayList<String>();
    @SerializedName("publishers")
    @Expose
    private List<String> publishers = new ArrayList<String>();
    @SerializedName("price_overview")
    @Expose
    private PriceOverview priceOverview;
    @SerializedName("packages")
    @Expose
    private List<Integer> packages = new ArrayList<Integer>();
    @SerializedName("package_groups")
    @Expose
    private List<PackageGroup> packageGroups = new ArrayList<PackageGroup>();
    @SerializedName("platforms")
    @Expose
    private Platforms platforms;
    @SerializedName("metacritic")
    @Expose
    private Metacritic metacritic;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = new ArrayList<Category>();
    @SerializedName("genres")
    @Expose
    private List<Genre> genres = new ArrayList<Genre>();
    @SerializedName("screenshots")
    @Expose
    private List<Screenshot> screenshots = new ArrayList<Screenshot>();
    @SerializedName("movies")
    @Expose
    private List<Movie> movies = new ArrayList<Movie>();
    @SerializedName("recommendations")
    @Expose
    private Recommendations recommendations;
    @SerializedName("achievements")
    @Expose
    private Achievements achievements;
    @SerializedName("release_date")
    @Expose
    private ReleaseDate releaseDate;
    @SerializedName("support_info")
    @Expose
    private SupportInfo supportInfo;
    @SerializedName("background")
    @Expose
    private String background;

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The steamAppid
     */
    public int getSteamAppid() {
        return steamAppid;
    }

    /**
     * 
     * @param steamAppid
     *     The steam_appid
     */
    public void setSteamAppid(int steamAppid) {
        this.steamAppid = steamAppid;
    }

    /**
     * 
     * @return
     *     The requiredAge
     */
    public int getRequiredAge() {
        return requiredAge;
    }

    /**
     * 
     * @param requiredAge
     *     The required_age
     */
    public void setRequiredAge(int requiredAge) {
        this.requiredAge = requiredAge;
    }

    /**
     * 
     * @return
     *     The isFree
     */
    public boolean isIsFree() {
        return isFree;
    }

    /**
     * 
     * @param isFree
     *     The is_free
     */
    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

    /**
     * 
     * @return
     *     The controllerSupport
     */
    public String getControllerSupport() {
        return controllerSupport;
    }

    /**
     * 
     * @param controllerSupport
     *     The controller_support
     */
    public void setControllerSupport(String controllerSupport) {
        this.controllerSupport = controllerSupport;
    }

    /**
     * 
     * @return
     *     The dlc
     */
    public List<Integer> getDlc() {
        return dlc;
    }

    /**
     * 
     * @param dlc
     *     The dlc
     */
    public void setDlc(List<Integer> dlc) {
        this.dlc = dlc;
    }

    /**
     * 
     * @return
     *     The detailedDescription
     */
    public String getDetailedDescription() {
        return detailedDescription;
    }

    /**
     * 
     * @param detailedDescription
     *     The detailed_description
     */
    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }

    /**
     * 
     * @return
     *     The aboutTheGame
     */
    public String getAboutTheGame() {
        return aboutTheGame;
    }

    /**
     * 
     * @param aboutTheGame
     *     The about_the_game
     */
    public void setAboutTheGame(String aboutTheGame) {
        this.aboutTheGame = aboutTheGame;
    }

    /**
     * 
     * @return
     *     The supportedLanguages
     */
    public String getSupportedLanguages() {
        return supportedLanguages;
    }

    /**
     * 
     * @param supportedLanguages
     *     The supported_languages
     */
    public void setSupportedLanguages(String supportedLanguages) {
        this.supportedLanguages = supportedLanguages;
    }

    /**
     * 
     * @return
     *     The headerImage
     */
    public String getHeaderImage() {
        return headerImage;
    }

    /**
     * 
     * @param headerImage
     *     The header_image
     */
    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
    }

    /**
     * 
     * @return
     *     The website
     */
    public String getWebsite() {
        return website;
    }

    /**
     * 
     * @param website
     *     The website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public Requirements getPcRequirements() {
        return pcRequirements;
    }

    public void setPcRequirements(Requirements pcRequirements) {
        this.pcRequirements = pcRequirements;
    }

    public Requirements getMacRequirements() {
        return macRequirements;
    }

    public void setMacRequirements(Requirements macRequirements) {
        this.macRequirements = macRequirements;
    }

    public Requirements getLinuxRequirements() {
        return linuxRequirements;
    }

    public void setLinuxRequirements(Requirements linuxRequirements) {
        this.linuxRequirements = linuxRequirements;
    }

    /**
     * 
     * @return
     *     The legalNotice
     */
    public String getLegalNotice() {
        return legalNotice;
    }

    /**
     * 
     * @param legalNotice
     *     The legal_notice
     */
    public void setLegalNotice(String legalNotice) {
        this.legalNotice = legalNotice;
    }

    /**
     * 
     * @return
     *     The developers
     */
    public List<String> getDevelopers() {
        return developers;
    }

    /**
     * 
     * @param developers
     *     The developers
     */
    public void setDevelopers(List<String> developers) {
        this.developers = developers;
    }

    /**
     * 
     * @return
     *     The publishers
     */
    public List<String> getPublishers() {
        return publishers;
    }

    /**
     * 
     * @param publishers
     *     The publishers
     */
    public void setPublishers(List<String> publishers) {
        this.publishers = publishers;
    }

    /**
     * 
     * @return
     *     The priceOverview
     */
    public PriceOverview getPriceOverview() {
        return priceOverview;
    }

    /**
     * 
     * @param priceOverview
     *     The price_overview
     */
    public void setPriceOverview(PriceOverview priceOverview) {
        this.priceOverview = priceOverview;
    }

    /**
     * 
     * @return
     *     The packages
     */
    public List<Integer> getPackages() {
        return packages;
    }

    /**
     * 
     * @param packages
     *     The packages
     */
    public void setPackages(List<Integer> packages) {
        this.packages = packages;
    }

    /**
     * 
     * @return
     *     The packageGroups
     */
    public List<PackageGroup> getPackageGroups() {
        return packageGroups;
    }

    /**
     * 
     * @param packageGroups
     *     The package_groups
     */
    public void setPackageGroups(List<PackageGroup> packageGroups) {
        this.packageGroups = packageGroups;
    }

    /**
     * 
     * @return
     *     The platforms
     */
    public Platforms getPlatforms() {
        return platforms;
    }

    /**
     * 
     * @param platforms
     *     The platforms
     */
    public void setPlatforms(Platforms platforms) {
        this.platforms = platforms;
    }

    /**
     * 
     * @return
     *     The metacritic
     */
    public Metacritic getMetacritic() {
        return metacritic;
    }

    /**
     * 
     * @param metacritic
     *     The metacritic
     */
    public void setMetacritic(Metacritic metacritic) {
        this.metacritic = metacritic;
    }

    /**
     * 
     * @return
     *     The categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * 
     * @param categories
     *     The categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /**
     * 
     * @return
     *     The genres
     */
    public List<Genre> getGenres() {
        return genres;
    }

    /**
     * 
     * @param genres
     *     The genres
     */
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    /**
     * 
     * @return
     *     The screenshots
     */
    public List<Screenshot> getScreenshots() {
        return screenshots;
    }

    /**
     * 
     * @param screenshots
     *     The screenshots
     */
    public void setScreenshots(List<Screenshot> screenshots) {
        this.screenshots = screenshots;
    }

    /**
     * 
     * @return
     *     The movies
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * 
     * @param movies
     *     The movies
     */
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    /**
     * 
     * @return
     *     The recommendations
     */
    public Recommendations getRecommendations() {
        return recommendations;
    }

    /**
     * 
     * @param recommendations
     *     The recommendations
     */
    public void setRecommendations(Recommendations recommendations) {
        this.recommendations = recommendations;
    }

    /**
     * 
     * @return
     *     The achievements
     */
    public Achievements getAchievements() {
        return achievements;
    }

    /**
     * 
     * @param achievements
     *     The achievements
     */
    public void setAchievements(Achievements achievements) {
        this.achievements = achievements;
    }

    /**
     * 
     * @return
     *     The releaseDate
     */
    public ReleaseDate getReleaseDate() {
        return releaseDate;
    }

    /**
     * 
     * @param releaseDate
     *     The release_date
     */
    public void setReleaseDate(ReleaseDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * 
     * @return
     *     The supportInfo
     */
    public SupportInfo getSupportInfo() {
        return supportInfo;
    }

    /**
     * 
     * @param supportInfo
     *     The support_info
     */
    public void setSupportInfo(SupportInfo supportInfo) {
        this.supportInfo = supportInfo;
    }

    /**
     * 
     * @return
     *     The background
     */
    public String getBackground() {
        return background;
    }

    /**
     * 
     * @param background
     *     The background
     */
    public void setBackground(String background) {
        this.background = background;
    }

}
