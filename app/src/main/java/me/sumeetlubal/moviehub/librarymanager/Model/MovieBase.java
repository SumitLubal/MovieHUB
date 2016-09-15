package me.sumeetlubal.moviehub.librarymanager.Model;

import java.util.ArrayList;
import java.util.List;

import info.movito.themoviedbapi.model.Genre;

/**
 * Created by SAM on 15-09-2016.
 */
public interface MovieBase {
    long getID();
    String getTitle();
    String getOriginalTitle();
    String getDescription();
    String getPoster();
    float getRating();
    String getTrailerLink();
    String getRealseDate();
    List<Genre> getGenre();
}
