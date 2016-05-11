
package party.hunchbacktank.lowscore.model.steam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Platforms {

    @SerializedName("windows")
    @Expose
    private boolean windows;
    @SerializedName("mac")
    @Expose
    private boolean mac;
    @SerializedName("linux")
    @Expose
    private boolean linux;

    /**
     * 
     * @return
     *     The windows
     */
    public boolean isWindows() {
        return windows;
    }

    /**
     * 
     * @param windows
     *     The windows
     */
    public void setWindows(boolean windows) {
        this.windows = windows;
    }

    /**
     * 
     * @return
     *     The mac
     */
    public boolean isMac() {
        return mac;
    }

    /**
     * 
     * @param mac
     *     The mac
     */
    public void setMac(boolean mac) {
        this.mac = mac;
    }

    /**
     * 
     * @return
     *     The linux
     */
    public boolean isLinux() {
        return linux;
    }

    /**
     * 
     * @param linux
     *     The linux
     */
    public void setLinux(boolean linux) {
        this.linux = linux;
    }

}
