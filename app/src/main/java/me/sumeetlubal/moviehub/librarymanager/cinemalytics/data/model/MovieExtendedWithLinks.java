/**
 * 
 */
package me.sumeetlubal.moviehub.librarymanager.cinemalytics.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author Arjit
 *
 */
public class MovieExtendedWithLinks {
	@SerializedName("Movie")
    private MovieCinemalytics movieCinemalytics;
	@SerializedName("ErosNow")
    private String erosNow;
	@SerializedName("YouTube")
    private String youTube;
	@SerializedName("BigFlix")
    private String bigFlix;
	@SerializedName("Hotstar")
    private String hotstar;
	@SerializedName("Spuul")
    private String spuul;
	@SerializedName("BoxTV")
    private String boxTV;
	@SerializedName("SonyTiv")
    private String sonyLiv;
	
    /**
	 * @return the movieCinemalytics
	 */
	public MovieCinemalytics getMovieCinemalytics() {
		return movieCinemalytics;
	}
	
	/**
	 * @param movieCinemalytics the movieCinemalytics to set
	 */
	public void setMovieCinemalytics(MovieCinemalytics movieCinemalytics) {
		this.movieCinemalytics = movieCinemalytics;
	}
	
	/**
	 * @return the erosNow
	 */
	public String getErosNow() {
		return erosNow;
	}
	
	/**
	 * @param erosNow the erosNow to set
	 */
	public void setErosNow(String erosNow) {
		this.erosNow = erosNow;
	}
	
	/**
	 * @return the youTube
	 */
	public String getYouTube() {
		return youTube;
	}
	
	/**
	 * @param youTube the youTube to set
	 */
	public void setYouTube(String youTube) {
		this.youTube = youTube;
	}
	
	/**
	 * @return the bigFlix
	 */
	public String getBigFlix() {
		return bigFlix;
	}
	
	/**
	 * @param bigFlix the bigFlix to set
	 */
	public void setBigFlix(String bigFlix) {
		this.bigFlix = bigFlix;
	}
	
	/**
	 * @return the hotstar
	 */
	public String getHotstar() {
		return hotstar;
	}
	
	/**
	 * @param hotstar the hotstar to set
	 */
	public void setHotstar(String hotstar) {
		this.hotstar = hotstar;
	}
	
	/**
	 * @return the spuul
	 */
	public String getSpuul() {
		return spuul;
	}
	
	/**
	 * @param spuul the spuul to set
	 */
	public void setSpuul(String spuul) {
		this.spuul = spuul;
	}
	
	/**
	 * @return the boxTV
	 */
	public String getBoxTV() {
		return boxTV;
	}
	
	/**
	 * @param boxTV the boxTV to set
	 */
	public void setBoxTV(String boxTV) {
		this.boxTV = boxTV;
	}
	
	/**
	 * @return the sonyLiv
	 */
	public String getSonyLiv() {
		return sonyLiv;
	}
	
	/**
	 * @param sonyLiv the sonyLiv to set
	 */
	public void setSonyLiv(String sonyLiv) {
		this.sonyLiv = sonyLiv;
	}
    
    
}
