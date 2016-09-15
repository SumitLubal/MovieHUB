/**
 * 
 */
package me.sumeetlubal.moviehub.librarymanager.cinemalytics.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author Arjit
 *
 */
public class MovieCinemalytics {

	@SerializedName("Id")
	private String id;
	
	@SerializedName("ImdbId")
	private String imdbId;
	
	@SerializedName("OriginalTitle")
	private String originalTitle;
	
	@SerializedName("Title")
	private String title;
	
	@SerializedName("Description")
	private String description;
	
	@SerializedName("TrailerLink")
	private String trailerLink;
	
	@SerializedName("TrailerEmbedCode")
	private String trailerEmbedCode;
	
	@SerializedName("Country")
	private String country;
	
	@SerializedName("Region")
	private String region;
	
	@SerializedName("Genre")
	private String genre;
	
	@SerializedName("RatingCount")
	private int ratingCount;
	
	@SerializedName("Rating")
	private float rating;
	
	@SerializedName("CensorRating")
	private String censorRating;
	
	@SerializedName("ReleaseDate")
	private String releaseDate;
	
	@SerializedName("Runtime")
	private int runtime;
	
	@SerializedName("Budget")
	private long budget;
	
	@SerializedName("Revenue")
	private long revenue;
	
	@SerializedName("PosterPath")
	private String posterPath;	

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the imdbId
	 */
	public String getImdbId() {
		return imdbId;
	}

	/**
	 * @param imdbId the imdbId to set
	 */
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	/**
	 * @return the originalTitle
	 */
	public String getOriginalTitle() {
		return originalTitle;
	}

	/**
	 * @param originalTitle the originalTitle to set
	 */
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the trailerLink
	 */
	public String getTrailerLink() {
		return trailerLink;
	}


	/**
	 * @param trailerLink the trailerLink to set
	 */
	public void setTrailerLink(String trailerLink) {
		this.trailerLink = trailerLink;
	}


	/**
	 * @return the trailerEmbedCode
	 */
	public String getTrailerEmbedCode() {
		return trailerEmbedCode;
	}


	/**
	 * @param trailerEmbedCode the trailerEmbedCode to set
	 */
	public void setTrailerEmbedCode(String trailerEmbedCode) {
		this.trailerEmbedCode = trailerEmbedCode;
	}


	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the ratingCount
	 */
	public int getRatingCount() {
		return ratingCount;
	}

	/**
	 * @param ratingCount the ratingCount to set
	 */
	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
	}

	/**
	 * @return the rating
	 */
	public float getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(float rating) {
		this.rating = rating;
	}

	/**
	 * @return the censorRating
	 */
	public String getCensorRating() {
		return censorRating;
	}

	/**
	 * @param censorRating the censorRating to set
	 */
	public void setCensorRating(String censorRating) {
		this.censorRating = censorRating;
	}

	/**
	 * @return the releaseDate
	 */
	public String getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * @return the runtime
	 */
	public int getRuntime() {
		return runtime;
	}

	/**
	 * @param runtime the runtime to set
	 */
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	/**
	 * @return the budget
	 */
	public long getBudget() {
		return budget;
	}

	/**
	 * @param budget the budget to set
	 */
	public void setBudget(long budget) {
		this.budget = budget;
	}

	/**
	 * @return the revenue
	 */
	public long getRevenue() {
		return revenue;
	}

	/**
	 * @param revenue the revenue to set
	 */
	public void setRevenue(long revenue) {
		this.revenue = revenue;
	}

	/**
	 * @return the posterPath
	 */
	public String getPosterPath() {
		return posterPath;
	}

	/**
	 * @param posterPath the posterPath to set
	 */
	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (budget ^ (budget >>> 32));
		result = prime * result + ((censorRating == null) ? 0 : censorRating.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imdbId == null) ? 0 : imdbId.hashCode());
		result = prime * result + ((originalTitle == null) ? 0 : originalTitle.hashCode());
		result = prime * result + ((posterPath == null) ? 0 : posterPath.hashCode());
		result = prime * result + Float.floatToIntBits(rating);
		result = prime * result + ratingCount;
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + (int) (revenue ^ (revenue >>> 32));
		result = prime * result + runtime;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((trailerEmbedCode == null) ? 0 : trailerEmbedCode.hashCode());
		result = prime * result + ((trailerLink == null) ? 0 : trailerLink.hashCode());
		return result;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieCinemalytics other = (MovieCinemalytics) obj;
		if (budget != other.budget)
			return false;
		if (censorRating == null) {
			if (other.censorRating != null)
				return false;
		} else if (!censorRating.equals(other.censorRating))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imdbId == null) {
			if (other.imdbId != null)
				return false;
		} else if (!imdbId.equals(other.imdbId))
			return false;
		if (originalTitle == null) {
			if (other.originalTitle != null)
				return false;
		} else if (!originalTitle.equals(other.originalTitle))
			return false;
		if (posterPath == null) {
			if (other.posterPath != null)
				return false;
		} else if (!posterPath.equals(other.posterPath))
			return false;
		if (Float.floatToIntBits(rating) != Float.floatToIntBits(other.rating))
			return false;
		if (ratingCount != other.ratingCount)
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		if (revenue != other.revenue)
			return false;
		if (runtime != other.runtime)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (trailerEmbedCode == null) {
			if (other.trailerEmbedCode != null)
				return false;
		} else if (!trailerEmbedCode.equals(other.trailerEmbedCode))
			return false;
		if (trailerLink == null) {
			if (other.trailerLink != null)
				return false;
		} else if (!trailerLink.equals(other.trailerLink))
			return false;
		return true;
	}
	
	
}
