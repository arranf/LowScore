
package party.hunchbacktank.isthereanydeal.model.steam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Highlighted {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("path")
    @Expose
    private String path;

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
     *     The path
     */
    public String getPath() {
        return path;
    }

    /**
     * 
     * @param path
     *     The path
     */
    public void setPath(String path) {
        this.path = path;
    }

}
