
package party.hunchbacktank.isthereanydeal.model.steam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Screenshot {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("path_thumbnail")
    @Expose
    private String pathThumbnail;
    @SerializedName("path_full")
    @Expose
    private String pathFull;

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
     *     The pathThumbnail
     */
    public String getPathThumbnail() {
        return pathThumbnail;
    }

    /**
     * 
     * @param pathThumbnail
     *     The path_thumbnail
     */
    public void setPathThumbnail(String pathThumbnail) {
        this.pathThumbnail = pathThumbnail;
    }

    /**
     * 
     * @return
     *     The pathFull
     */
    public String getPathFull() {
        return pathFull;
    }

    /**
     * 
     * @param pathFull
     *     The path_full
     */
    public void setPathFull(String pathFull) {
        this.pathFull = pathFull;
    }

}
