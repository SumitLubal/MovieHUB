package me.sumeetlubal.moviehub.librarymanager.Model;

import java.util.List;

import info.movito.themoviedbapi.Utils;
import info.movito.themoviedbapi.model.Genre;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.Video;
import me.sumeetlubal.moviehub.librarymanager.API;

/**
 * Created by SAM on 15-09-2016.
 */
public class MovieTMDB implements MovieBase {
    MovieDb m_MovieDBObject;
    public MovieTMDB(MovieDb object){
        m_MovieDBObject = object;
    }
    @Override
    public long getID() {
        return m_MovieDBObject.getId();
    }

    @Override
    public String getTitle() {
        return m_MovieDBObject.getTitle();
    }

    @Override
    public String getOriginalTitle() {
        return m_MovieDBObject.getOriginalTitle();
    }

    @Override
    public String getDescription() {
        return m_MovieDBObject.getOverview();
    }

    @Override
    public String getPoster() {
        return Utils.createImageUrl(API.getTmdbapi(), m_MovieDBObject.getPosterPath(), "w45").toString(); //TODO: please change from w45 to desired format on device to save downloading of images based on network.
    }

    @Override
    public float getRating() {
        return m_MovieDBObject.getUserRating();
    }

    @Override
    public String getTrailerLink() {
        List<Video> result = API.getTmdbapi().getMovies().getVideos(m_MovieDBObject.getId(), ""); //TODO:specify language here
        if(result.size()!=0) {
            return API.createYOUTUBEUrl(result.get(0).getSite(), result.get(0).getKey());
        }
        return null;
    }

    @Override
    public String getRealseDate() {
        return m_MovieDBObject.getReleaseDate();
    }

    @Override
    public List<Genre> getGenre() {
        return API.getTmdbapi().getMovies().getMovie(m_MovieDBObject.getId(),"en").getGenres();
    }
}
