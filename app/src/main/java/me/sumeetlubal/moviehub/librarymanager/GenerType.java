package me.sumeetlubal.moviehub.librarymanager;

import java.util.HashMap;

/**
 * Created by SAM on 15-09-2016.
 */
public class GenerType {
    static HashMap<String, Integer> hm = new HashMap<String, Integer>(); //TODO: can be replaced with Sparcearray
    private static GenerType mGenreMap = null;
    GenerType(){
        hm.put("action", 28);
        hm.put("Adventure", 12); //not available with Cinematics
        hm.put("Animation", 16); //not available with Cinematics
        hm.put("comedy", 35);
        hm.put("crime", 80);
        hm.put("drama", 18);
        hm.put("Family", 10751); //not available with Cinematics
        hm.put("horror", 27);
        hm.put("romance", 10749);
        hm.put("thriller", 53);
    }
    public static int getID(String name){
        if(mGenreMap==null){
            mGenreMap = new GenerType();
        }
        return hm.get(name);
    }
}
