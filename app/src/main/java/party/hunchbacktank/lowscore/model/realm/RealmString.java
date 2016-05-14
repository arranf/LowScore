package party.hunchbacktank.lowscore.model.realm;

import io.realm.RealmObject;

/**
 * Created by Arran on 14/05/2016.
 */
public class RealmString extends RealmObject {
    private String val;

    public RealmString() {
    }

    public RealmString(String val) {
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
