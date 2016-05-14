package party.hunchbacktank.lowscore.helpers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import party.hunchbacktank.lowscore.activities.SettingsActivity;

/**
 * Created by Joel on 14/05/2016.
 */
public class SettingsHelper {

    public static void startSettingsActivity(AppCompatActivity currentActivity) {
        Intent intent = new Intent(currentActivity, SettingsActivity.class);
        currentActivity.startActivity(intent);
    }

}
