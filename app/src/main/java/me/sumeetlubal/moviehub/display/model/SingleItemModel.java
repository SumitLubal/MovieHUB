package me.sumeetlubal.moviehub.display.model;

import me.sumeetlubal.moviehub.librarymanager.Model.MovieBase;

/**
 * Created by pratap.kesaboyina on 01-12-2015.
 */
public class SingleItemModel {


    private String name;
    private String url;
    private String description;
    private MovieBase movieBase;

    public SingleItemModel() {
    }

    public SingleItemModel(String name, String url) {
        this.name = name;
        this.url = url;
        this.movieBase = null;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
