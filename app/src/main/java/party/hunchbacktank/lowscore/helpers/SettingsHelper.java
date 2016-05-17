package party.hunchbacktank.lowscore.helpers;

import android.content.Context;
import android.content.Intent;

import party.hunchbacktank.lowscore.activities.SettingsActivity;

/**
 * Created by Joel on 14/05/2016.
 */
public class SettingsHelper {

    public static void startSettingsActivity(Context currentActivity) {
        Intent intent = new Intent(currentActivity, SettingsActivity.class);
        currentActivity.startActivity(intent);
    }

}
