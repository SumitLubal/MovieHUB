package me.sumeetlubal.moviehub;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import me.sumeetlubal.moviehub.librarymanager.API;
import me.sumeetlubal.moviehub.librarymanager.Model.MovieBase;
import me.sumeetlubal.moviehub.librarymanager.cinemalytics.data.model.MovieCinemalytics;
import me.sumeetlubal.moviehub.librarymanager.cinemalytics.repo.Cinemalytics;
import me.sumeetlubal.moviehub.librarymanager.cinemalytics.repo.MovieRepository;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    protected static final int ID_MOVIE_BLADE_RUNNER = 78;
    private final String API_KEY_CINEMALYTICS="569A5D6CA5691E4C6B69D62E02F4114C",API_KEY_TMDB="af270a1c3ba90195173e23eb5b191985";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new FetchMovies().execute();
    }

    class FetchMovies extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            API.APIBuilder builder = new API.APIBuilder();
            API api = builder.APIKey(API_KEY_CINEMALYTICS).DBType(API.DBTYPE.DB_CINEMALYTICS).Language(API.LANGUAGES.LANGUAGE_ENGLISH).build();
            try {
                List<MovieBase> movies = api.listMoviesByGendre("action");
                Log.d(TAG,"I got "+ movies.size()+ " movies");
                int i=0;
                for(MovieBase movie: movies){
                    Log.d(TAG,(i++)+" "+movie.getTitle());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
