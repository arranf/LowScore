package party.hunchbacktank.lowscore.activities;/*
 * Copyright 2014 Realm Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import io.realm.Realm;
import party.hunchbacktank.lowscore.R;
import party.hunchbacktank.lowscore.model.Game;

/*
** This example demonstrates how you can migrate your data through different updates
** of your models.
*/
public class MigrationActivity extends Activity {

    public static final String TAG = MigrationActivity.class.getName();

    private LinearLayout rootLayout = null;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_migration);

        copyBundledRealmFile(this.getResources().openRawResource(R.raw.grail), "grail.realm");

        realm = Realm.getDefaultInstance();
        showStatus(realm);
        realm.close();
        startActivity(new Intent(this, MainActivity.class));
    }

    private String copyBundledRealmFile(InputStream inputStream, String outFileName) {
        try {
            File file = new File(this.getFilesDir(), outFileName);
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buf)) > 0) {
                outputStream.write(buf, 0, bytesRead);
            }
            outputStream.close();
            return file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String realmString(Realm realm) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Game game : realm.where(Game.class).findAll()) {
            stringBuilder.append(game.toString()).append("\n");
        }

        return (stringBuilder.length() == 0) ? "<data was deleted>" : stringBuilder.toString();
    }

    private void showStatus(Realm realm) {
        showStatus(realmString(realm));
    }

    private void showStatus(String txt) {
        Log.i(TAG, txt);
    }
}