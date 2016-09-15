package me.sumeetlubal.moviehub.librarymanager.Model;

import java.util.ArrayList;
import java.util.List;

import info.movito.themoviedbapi.model.Genre;
import me.sumeetlubal.moviehub.librarymanager.cinemalytics.data.model.MovieCinemalytics;

/**
 * Created by SAM on 15-09-2016.
 */
public class MovieCNM implements MovieBase {
    MovieCinemalytics m_MovieObject;
    public MovieCNM(MovieCinemalytics object){
        m_MovieObject = object;
    }
    @Override
    public long getID() {
        return Long.parseLong("AA0F245C", 16);//TODO:check this as api returns string and i am using long
    }

    @Override
    public String getTitle() {
        return m_MovieObject.getTitle();
    }

    @Override
    public String getOriginalTitle() {
        return m_MovieObject.getOriginalTitle();
    }

    @Override
    public String getDescription() {
        return m_MovieObject.getDescription();
    }

    @Override
    public String getPoster() {
        return m_MovieObject.getPosterPath();
    }

    @Override
    public float getRating() {
        return m_MovieObject.getRating();
    }

    @Override
    public String getTrailerLink() {
        return m_MovieObject.getTrailerLink();
    }

    @Override
    public String getRealseDate() {
        return m_MovieObject.getReleaseDate();
    }

    @Override
    public List<Genre> getGenre() {
        ArrayList<Genre> gens = new ArrayList<>();
        Genre g = new Genre();
        g.setId(2);//TODO:setting this to random as I havent impimented connection of gener between two DB's
        g.setName(m_MovieObject.getGenre());
        gens.add(g);
        return gens;
    }
}
