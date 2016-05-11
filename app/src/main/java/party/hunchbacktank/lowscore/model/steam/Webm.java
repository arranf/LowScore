
package party.hunchbacktank.lowscore.model.steam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Webm {

    @SerializedName("480")
    @Expose
    private String SD;
    @SerializedName("HD")
    @Expose
    private String HD;

    /**
     * 
     * @return
     *     The SD
     */
    public String getSD() {
        return SD;
    }

    /**
     * 
     * @param url
     *     The 480
     */
    public void setSD(String url) {
        this.SD = url;
    }

    /**
     * 
     * @return
     *     The HD
     */
    public String getHD() {
        return HD;
    }

    /**
     * 
     * @param url
     *     The HD
     */
    public void setHD(String url) {
        this.HD = url;
    }

}
