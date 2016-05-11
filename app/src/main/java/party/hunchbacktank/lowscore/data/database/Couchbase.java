package party.hunchbacktank.lowscore.data.database;

import android.content.Context;
import android.util.Log;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Manager;
import com.couchbase.lite.android.AndroidContext;

import java.io.IOException;

/**
 * Created by Arran on 10/05/2016.
 */
public class Couchbase {
    private static Manager manager;
    private static Database database;
    private final static String DB_NAME = "DEAL_DB";
    final String TAG = "Couchbase Singleton";

    public Manager getManagerInstance(Context context) throws IOException {
        if (manager == null) {
            manager = new Manager(new AndroidContext(context), Manager.DEFAULT_OPTIONS);
        }
        return manager;
    }

    public Database getDatabaseInstance(Context context) throws CouchbaseLiteException {
        if (database == null) {
            try {
                database = getManagerInstance(context).getDatabase(DB_NAME);
            }
            catch (IOException e){
                Log.e(TAG, e.getMessage());
            }
        }
        return database;
    }
}
