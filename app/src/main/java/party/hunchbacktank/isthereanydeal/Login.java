package party.hunchbacktank.isthereanydeal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.math.BigInteger;
import java.security.SecureRandom;

import party.hunchbacktank.isthereanydeal.model.authentication.Token;
import party.hunchbacktank.isthereanydeal.networking.token.TokenEndpoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A login screen that offers login via email/password.
 */
public class Login extends AppCompatActivity {

    //region classvariables
    private Button loginButton;

    private final String CLIENT_ID = "***REMOVED***";
    private final String REDIRECT_URI = "isthereanydeal://authorise";
    private final String TAG = "Login";
    private final String CLIENT_SECRET = "***REMOVED***";
    private SharedPreferences preferences;
    //endregion

    //region activityLifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton = (Button) findViewById(R.id.login_button);
        preferences = getPreferences(MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Uri uri = getIntent().getData();
        //TODO Handle rejections
        if (uri != null && uri.toString().startsWith(REDIRECT_URI) && uri.getQueryParameter("state").equals(preferences.getString("State", "none"))) {
            String code = uri.getQueryParameter("code");
            getAccessToken(code);
        } else {
            // TODO throw exception
        }
    }
    //endregion

    //region Methods
    protected String generateUri() {
        SecureRandom random = new SecureRandom();
        String state = new BigInteger(130, random).toString(32);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("State", state);
        editor.apply();

        return String.format("https://api.isthereanydeal.com/oauth/authorize/?response_type=code&client_id=%1$s&state=%2$s&scope=coll_read coll_write wait_read wait_write&redirect_uri=%3$s&grant=authorization_code",
                CLIENT_ID, state, REDIRECT_URI);
    }

    public void getAccessToken(String code) {
        Retrofit.Builder builder = new Retrofit.Builder()
                //.baseUrl("https://api.isthereanydeal.com")
                .baseUrl("http://requestb.in")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        TokenEndpoint tokenService = retrofit.create(TokenEndpoint.class);

        Call<Token> call = tokenService.getToken("authorization_code", code, CLIENT_ID, CLIENT_SECRET, REDIRECT_URI);
        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                String body = response.body().toString();
            }

            @Override
            public void onFailure(Call<Token> call, Throwable e) {
                e.printStackTrace();
            }
        });
    }
    //endregion

    //region Events
    public void loginButtonClickHandler(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(generateUri()));
        startActivity(intent);
    }
    //endregion
}

