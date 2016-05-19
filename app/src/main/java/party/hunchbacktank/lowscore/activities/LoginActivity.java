package party.hunchbacktank.lowscore.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import party.hunchbacktank.lowscore.BuildConfig;
import party.hunchbacktank.lowscore.R;
import party.hunchbacktank.lowscore.model.isthereanydeal.authentication.Token;
import party.hunchbacktank.lowscore.model.isthereanydeal.authentication.TokenRequestType;
import party.hunchbacktank.lowscore.networking.isthereanydeal.TokenEndpoint;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    public static final int ACCESS_TOKEN_LIFESPAN = 2073595;
    private Button loginButton;

    private final String CLIENT_ID = BuildConfig.CLIENT_ID;
    private final String REDIRECT_URI = "isthereanydeal://authorise";
    private final String TAG = "LoginActivity";
    private SharedPreferences preferences;
    private final String OAUTHPREFERENCES = "OAuthPreferences";

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
        //TODO Handle URI exceptional events
        if (uri != null && uri.toString().startsWith(REDIRECT_URI) && uri.getQueryParameter("state").equals(preferences.getString("State", "none"))) {
            String code = uri.getQueryParameter("code");
            getAccessToken(code);
        }
        else {
            checkTokenExpiry();
        }
    }
    //endregion

    //region Methods
    private void checkTokenExpiry() {
        String expiryDate = preferences.getString("accessTokenExpiry", null);
        if (expiryDate != null) {
            Date expiryDateTime = null;
            try {
                expiryDateTime = new SimpleDateFormat().parse(expiryDate);
            } catch (ParseException e) {
                Log.e(TAG, e.getMessage());
            }

            //TODO Rework this to only refresh if the time is less than 23 days
            if (expiryDateTime != null && expiryDateTime.compareTo(new Date()) <= 0) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.remove("accessToken");
                editor.apply();
                // TODO Prompt user to reauthenticate
            } else {
                String refreshToken = preferences.getString("refreshToken", null);
                if (refreshToken != null) {
                    refreshAccessToken(refreshToken);
                }
            }
        }
        startMainActivity();
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    protected String generateUri() {
        SecureRandom random = new SecureRandom();
        String state = new BigInteger(130, random).toString(32);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("State", state);
        editor.apply();

        return String.format("https://api.isthereanydeal.com/oauth/authorize/?response_type=code&client_id=%1$s&state=%2$s&scope=coll_read coll_write wait_read wait_write&redirect_uri=%3$s&grant=authorization_code",
                CLIENT_ID, state, REDIRECT_URI);
    }

    //TODO Move these somewhere as these calls will want to be repeated
    //TODO Collapse refresh and get into smaller methods relying on a generic AccessToken method, they're too similar
    public void refreshAccessToken(String refreshToken){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.isthereanydeal.com")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        TokenEndpoint tokenService = retrofit.create(TokenEndpoint.class);
        Call<Token> call = tokenService.authorise(TokenRequestType.REFRESH.toString(), refreshToken, CLIENT_ID, BuildConfig.CLIENT_SECRET, REDIRECT_URI);
        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, retrofit2.Response<Token> response) {
                SharedPreferences preferences = getSharedPreferences(OAUTHPREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("accessToken", response.body().getAccessToken());
                editor.putString("refreshToken", response.body().getRefreshToken());
                Calendar currentDateTime = new GregorianCalendar();
                currentDateTime.add(Calendar.SECOND, ACCESS_TOKEN_LIFESPAN);
                editor.putString("accessTokenExpiry", currentDateTime.toString());
                editor.apply();
                startMainActivity();
            }

            @Override
            public void onFailure(Call<Token> call, Throwable e) {
                e.printStackTrace();
                //TODO Handle better? Perhaps it can silently fail.
            }
        });
    }

    public void getAccessToken(String code) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.isthereanydeal.com")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        TokenEndpoint tokenService = retrofit.create(TokenEndpoint.class);

        String CLIENT_SECRET = BuildConfig.CLIENT_SECRET;
        Call<Token> call = tokenService.authorise(TokenRequestType.CODE.toString(), code, CLIENT_ID, CLIENT_SECRET, REDIRECT_URI);
        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, retrofit2.Response<Token> response) {
                if (response.body() != null) {
                    SharedPreferences preferences = getSharedPreferences(OAUTHPREFERENCES, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("accessToken", response.body().getAccessToken());
                    editor.putString("refreshToken", response.body().getRefreshToken());
                    Calendar currentDateTime = new GregorianCalendar();
                    currentDateTime.add(Calendar.SECOND, ACCESS_TOKEN_LIFESPAN);
                    editor.putString("accessTokenExpiry", currentDateTime.toString());
                    editor.apply();
                }
                startMainActivity();
            }

            @Override
            public void onFailure(Call<Token> call, Throwable e) {
                e.printStackTrace();
                //TODO Prompt for second attempt, explain error to user
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

