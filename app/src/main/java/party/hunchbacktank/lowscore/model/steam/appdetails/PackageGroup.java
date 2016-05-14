
package party.hunchbacktank.lowscore.model.steam.appdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PackageGroup {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("selection_text")
    @Expose
    private String selectionText;
    @SerializedName("save_text")
    @Expose
    private String saveText;
    @SerializedName("display_type")
    @Expose
    private int displayType;
    @SerializedName("is_recurring_subscription")
    @Expose
    private String isRecurringSubscription;
    @SerializedName("subs")
    @Expose
    private List<Sub> subs = new ArrayList<Sub>();

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
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The selectionText
     */
    public String getSelectionText() {
        return selectionText;
    }

    /**
     * 
     * @param selectionText
     *     The selection_text
     */
    public void setSelectionText(String selectionText) {
        this.selectionText = selectionText;
    }

    /**
     * 
     * @return
     *     The saveText
     */
    public String getSaveText() {
        return saveText;
    }

    /**
     * 
     * @param saveText
     *     The save_text
     */
    public void setSaveText(String saveText) {
        this.saveText = saveText;
    }

    /**
     * 
     * @return
     *     The displayType
     */
    public int getDisplayType() {
        return displayType;
    }

    /**
     * 
     * @param displayType
     *     The display_type
     */
    public void setDisplayType(int displayType) {
        this.displayType = displayType;
    }

    /**
     * 
     * @return
     *     The isRecurringSubscription
     */
    public String getIsRecurringSubscription() {
        return isRecurringSubscription;
    }

    /**
     * 
     * @param isRecurringSubscription
     *     The is_recurring_subscription
     */
    public void setIsRecurringSubscription(String isRecurringSubscription) {
        this.isRecurringSubscription = isRecurringSubscription;
    }

    /**
     * 
     * @return
     *     The subs
     */
    public List<Sub> getSubs() {
        return subs;
    }

    /**
     * 
     * @param subs
     *     The subs
     */
    public void setSubs(List<Sub> subs) {
        this.subs = subs;
    }

}
