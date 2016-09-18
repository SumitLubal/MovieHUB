package me.sumeetlubal.moviehub;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import me.sumeetlubal.moviehub.librarymanager.API;
import me.sumeetlubal.moviehub.librarymanager.Model.MovieBase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG = "MainActivity";
    protected static final int ID_MOVIE_BLADE_RUNNER = 78;
    private final String API_KEY_CINEMALYTICS = "569A5D6CA5691E4C6B69D62E02F4114C", API_KEY_TMDB = "af270a1c3ba90195173e23eb5b191985";
    private Button btnLaunch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new FetchMovies().execute();
        btnLaunch = (Button) findViewById(R.id.button_launch);
        btnLaunch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, LaunchActivity.class);
        startActivity(intent);
    }

    class FetchMovies extends AsyncTask<Void, Void, Void> {
        void printMovies(API api, String s) {
            try {
                List<MovieBase> movies = api.getNowTrending();
                int i = 0;
                for (MovieBase movie : movies) {
                    Log.d(TAG, (i++) + " " + movie.getTitle());
                }
            } catch (Exception p) {
                Log.d(TAG, "Type " + s + " not available!!");
                p.printStackTrace();
            }
        }

        @Override
        protected Void doInBackground(Void... voids) {
            API.APIBuilder builder = new API.APIBuilder();
            API api = builder.APIKey(API_KEY_TMDB).DBType(API.DBTYPE.DB_TMDB).Language(API.LANGUAGES.LANGUAGE_ENGLISH).build();
            printMovies(api,"");
            return null;
        }
    }
}
