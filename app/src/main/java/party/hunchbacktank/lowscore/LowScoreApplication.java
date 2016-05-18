package party.hunchbacktank.lowscore;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Arran on 14/05/2016.
 */
public class LowScoreApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration config = new RealmConfiguration.Builder(this).name("grail.realm").build();
        Realm.setDefaultConfiguration(config);
    }
}