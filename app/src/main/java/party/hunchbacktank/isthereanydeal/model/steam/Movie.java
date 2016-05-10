
package party.hunchbacktank.isthereanydeal.model.steam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("webm")
    @Expose
    private Webm webm;
    @SerializedName("highlight")
    @Expose
    private boolean highlight;

    /**
     * 
     * @return
     *     The id
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(int id) {
        this.id = id;
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
     *     The thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * 
     * @param thumbnail
     *     The thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * 
     * @return
     *     The webm
     */
    public Webm getWebm() {
        return webm;
    }

    /**
     * 
     * @param webm
     *     The webm
     */
    public void setWebm(Webm webm) {
        this.webm = webm;
    }

    /**
     * 
     * @return
     *     The highlight
     */
    public boolean isHighlight() {
        return highlight;
    }

    /**
     * 
     * @param highlight
     *     The highlight
     */
    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }

}
