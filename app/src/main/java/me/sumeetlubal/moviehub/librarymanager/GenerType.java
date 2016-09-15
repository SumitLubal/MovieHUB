package me.sumeetlubal.moviehub.librarymanager;

import java.util.HashMap;

/**
 * Created by SAM on 15-09-2016.
 */
public class GenerType {
    static HashMap<String, Integer> hm = new HashMap<String, Integer>(); //TODO: can be replaced with Sparcearray
    GenerType(){
        hm.put("action", 28);
        hm.put("adventure", 12);
        hm.put("animation", 16);
        hm.put("comedy", 35);
        hm.put("crime", 80);
        hm.put("drama", 18);
        hm.put("family", 10751);
        hm.put("horror", 27);
        hm.put("romance", 10749);
        hm.put("thriller", 53);
    }
    public static int getID(String name){
        return hm.get(name);
    }
}
