package me.sumeetlubal.moviehub.librarymanager;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import me.sumeetlubal.moviehub.display.adapter.HomeScreenRecycleAdapter;
import me.sumeetlubal.moviehub.display.model.SectionDataModel;
import me.sumeetlubal.moviehub.display.model.SingleItemModel;
import me.sumeetlubal.moviehub.librarymanager.Model.MovieBase;
import me.sumeetlubal.moviehub.librarymanager.Model.MovieCNM;
import me.sumeetlubal.moviehub.librarymanager.Model.MovieTMDB;
import me.sumeetlubal.moviehub.librarymanager.cinemalytics.data.model.MovieCinemalytics;
import me.sumeetlubal.moviehub.librarymanager.cinemalytics.data.model.MovieExtendedWithLinks;
import me.sumeetlubal.moviehub.librarymanager.cinemalytics.repo.Cinemalytics;
import me.sumeetlubal.moviehub.librarymanager.internalevents.NotifyCompleteEvent;
import me.sumeetlubal.moviehub.librarymanager.internalevents.WorkRequstEvent;

/**
 * Created by SAM on 15-09-2016.
 */
//this API will use APIBuilder pattern so we can use two or more DB for different countries and areas
public class API {
    private static final String TAG = "API";
    //TODO: need to add other language support after we successfully test HINDI and ENGLISH
    private static TmdbApi m_tmdbapi;
    private Cinemalytics m_CNMDAPI;

    public enum LANGUAGES {LANGUAGE_ENGLISH, LANGUAGE_HINDI}

    ;
    private String[] langs = {"en", "hi"};

    public enum DBTYPE {DB_TMDB, DB_CINEMALYTICS}

    ;
    private final String m_APIKey;
    private final DBTYPE m_DBType;
    private final LANGUAGES m_UserLanguage;
    volatile private ArrayList<List<MovieBase>> contents;
    volatile private ArrayList<SectionDataModel> dataViewModel;
    private boolean addWithoutImage = false;

    private API(APIBuilder builder) {
        EventBus.getDefault().register(this);
        m_APIKey = builder.APIKey;
        m_DBType = builder.DBType;
        m_UserLanguage = builder.userLanguage;
        if (m_DBType == DBTYPE.DB_TMDB) {
            m_tmdbapi = new TmdbApi(m_APIKey);
        } else if (m_DBType == DBTYPE.DB_CINEMALYTICS) {
            m_CNMDAPI = new Cinemalytics(m_APIKey);
        }
        contents = new ArrayList<>();
        if (dataViewModel == null) dataViewModel = new ArrayList<>();
        contents.add(null);
        contents.add(null);
        contents.add(null);
    }

    public List<MovieBase> getUpComingMovies() throws Exception {
        List<MovieBase> movies = new ArrayList<>();
        if (m_DBType == DBTYPE.DB_TMDB) {
            MovieResultsPage resultPage = m_tmdbapi.getMovies().getUpcoming("en", 1);//TODO:change after adding additional language support
            List<MovieDb> results = resultPage.getResults();
            for (MovieDb eachMovie : results) {
                movies.add(new MovieTMDB(eachMovie));
            }
        } else {
            List<MovieCinemalytics> upcomingMovies = m_CNMDAPI.GetMovieRepositoryInstance().GetUpcomingMovies();
            for (MovieCinemalytics eachMovie : upcomingMovies) {
                movies.add(new MovieCNM(eachMovie));
            }
        }
        return movies;
    }

    public List<MovieBase> getNowTrending() throws Exception {
        List<MovieBase> movies = new ArrayList<>();
        if (m_DBType == DBTYPE.DB_TMDB) {
            MovieResultsPage resultsPage = m_tmdbapi.getMovies().getUpcoming("en", 1);//TODO:change after adding additional language support
            List<MovieDb> result = resultsPage.getResults();
            for (MovieDb eachMovie : result) {
                movies.add(new MovieTMDB(eachMovie));
            }
        } else {
            List<MovieCinemalytics> upcomingMovies = m_CNMDAPI.GetMovieRepositoryInstance().GetReleasedThisWeekMovies();
            for (MovieCinemalytics eachMovie : upcomingMovies) {
                movies.add(new MovieCNM(eachMovie));
            }
        }
        return movies;
    }

    public List<MovieBase> getTopRatedMovies() throws Exception {
        List<MovieBase> movies = new ArrayList<MovieBase>();
        if (m_DBType == DBTYPE.DB_TMDB) {
            MovieResultsPage resultPage = m_tmdbapi.getMovies().getTopRatedMovies("en", 1);//TODO:change after adding additional language support
            List<MovieDb> results = resultPage.getResults();
            for (MovieDb eachMovie : results) {
                movies.add(new MovieTMDB(eachMovie));
            }
            return movies;
        } else {
            List<MovieCinemalytics> upcomingMovies = m_CNMDAPI.GetMovieRepositoryInstance().GetTop10Movies();
            for (MovieCinemalytics eachMovie : upcomingMovies) {
                movies.add(new MovieCNM(eachMovie));
            }
            return movies;
        }
    }

    public List<MovieBase> listMoviesByGenre(String genre) throws Exception {
        List<MovieBase> movies = new ArrayList<MovieBase>();
        if (m_DBType == DBTYPE.DB_TMDB) {
            MovieResultsPage resultsPage = m_tmdbapi.getGenre().getGenreMovies(GenerType.getID(genre), "en", 1, true);//TODO:change after adding additional language support
            List<MovieDb> results = resultsPage.getResults();
            for (MovieDb eachMovie : results) {
                movies.add(new MovieTMDB(eachMovie));
            }
            return movies;
        } else {
            //TODO: this method is not working correctly
            List<MovieExtendedWithLinks> upcomingMovies = m_CNMDAPI.GetMovieRepositoryInstance().GetMoviesWithLinks(genre);
            for (MovieExtendedWithLinks eachMovie : upcomingMovies) {
                movies.add(new MovieCNM(eachMovie.getMovieCinemalytics()));
            }
            return movies;
        }
    }

    public static class APIBuilder {
        private static final String TAG = "APIBuilder";
        private String APIKey; // required
        private DBTYPE DBType;
        private LANGUAGES userLanguage;
        private boolean addwithoutimagel;

        public APIBuilder() {
        }

        public APIBuilder APIKey(String APIKey) {
            this.APIKey = APIKey;
            return this;
        }

        public APIBuilder DBType(DBTYPE type) {
            DBType = type;
            return this;
        }

        public APIBuilder Language(LANGUAGES type) {
            userLanguage = type;
            return this;
        }


        public API build() {
            validateParameters();
            return new API(this);
        }

        private void validateParameters() {
            if (APIKey == null || APIKey.isEmpty()) {
                Log.d(TAG, "You should have API key specified.. Get it from Database sites");
            } else if (DBType == null) {
                Log.d(TAG, "DBType not set. Falling back to TMDB");
                DBType = DBTYPE.DB_TMDB; //fallback to TMDB
            } else if (userLanguage == null) {
                Log.d(TAG, "Language not set. Falling back to English");
                userLanguage = LANGUAGES.LANGUAGE_ENGLISH; //fallback to english
            }
        }
    }

    public static TmdbApi getTmdbapi() {
        if (m_tmdbapi == null) Log.d(TAG, "Forgot to initiate API first ??");
        return m_tmdbapi;
    }

    @Nullable
    public static String createYOUTUBEUrl(String site, String Key) {
        if (site == null || Key == null || !site.toLowerCase().contains("youtube")) {
            return null;
        } else {
            Uri.Builder uri = new Uri.Builder();
            uri.scheme("https").authority("www.youtube.com").appendPath("watch").appendQueryParameter("v", Key);
            return uri.build().toString();
        }
    }

    interface WORK {
        List<MovieBase> doWork();

        void onResult(List<MovieBase> movies);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void handleRequest(WorkRequstEvent event) {
        ArrayList<SectionDataModel> allSampleData = new ArrayList<>();
        List<MovieBase> data = null;
        try {
            data = getTopRatedMovies();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ;
        for (int i = 1; i <= 5; i++) {

            SectionDataModel dm = new SectionDataModel();

            dm.setHeaderTitle("Section " + i);

            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (int j = 0; j <= 5; j++) {
                singleItem.add(new SingleItemModel("Item " + j, "URL " + j));
            }

            dm.setAllItemsInSection(singleItem);

            allSampleData.add(dm);

        }
        if(true) {
            Log.d(TAG,"Returning something");
            EventBus.getDefault().post(new NotifyCompleteEvent(event.getmType(), allSampleData));
            return;
        }
        //get data
        try {
            //if (event.getmType() == NotifyCompleteEvent.NotifyCompleteEventType.POPULAR) {
                if (contents.get(0) == null) {
                    data = getTopRatedMovies();
                    contents.set(0, data);
                    ArrayList<SingleItemModel> model = convertToViewModel(data);
                    dataViewModel.add(0, new SectionDataModel("Poplar Movies", model));
                }
           // } else if (event.getmType() == NotifyCompleteEvent.NotifyCompleteEventType.NOWTRENDING) {
                if (contents.get(1) == null) {
                    data = getNowTrending();
                    contents.set(1, data);
                    ArrayList<SingleItemModel> model = convertToViewModel(data);
                    dataViewModel.add(1, new SectionDataModel("Now Trending", model));
                }

           // } else if (event.getmType() == NotifyCompleteEvent.NotifyCompleteEventType.UPCOMING) {
                if (contents.get(2) == null) {
                    data = getUpComingMovies();
                    contents.set(2, data);
                    ArrayList<SingleItemModel> model = convertToViewModel(data);
                    dataViewModel.add(2, new SectionDataModel("Upcomings", model));
                }

            //}
            //send this to GUI's
            EventBus.getDefault().post(new NotifyCompleteEvent(event.getmType(), dataViewModel));
            //return with event
        } catch (Exception eex) {
            eex.printStackTrace();
        }
    }

    private ArrayList<SingleItemModel> convertToViewModel(List<MovieBase> data) {
        ArrayList<SingleItemModel> model = new ArrayList<>();
        for (MovieBase movie : data) {
            if (movie != null && movie.getPoster() != null &&movie.getTitle() != null)
                model.add(new SingleItemModel(movie.getTitle(), movie.getPoster()));
        }
        return model;
    }
}
