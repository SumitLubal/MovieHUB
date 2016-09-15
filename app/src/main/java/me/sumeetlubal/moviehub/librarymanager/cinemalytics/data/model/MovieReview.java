/**
 * 
 */
package me.sumeetlubal.moviehub.librarymanager.cinemalytics.data.model;

/**
 * @author Arjit
 *
 */
public class MovieReview {

	private int id;
	private String movieId;
	private String criticId;
	private int orgId;
	private String excerpt;
	private String reviewLink;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the movieId
	 */
	public String getMovieId() {
		return movieId;
	}
	
	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	
	/**
	 * @return the criticId
	 */
	public String getCriticId() {
		return criticId;
	}
	
	/**
	 * @param criticId the criticId to set
	 */
	public void setCriticId(String criticId) {
		this.criticId = criticId;
	}
	
	/**
	 * @return the orgId
	 */
	public int getOrgId() {
		return orgId;
	}
	
	/**
	 * @param orgId the orgId to set
	 */
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	
	/**
	 * @return the excerpt
	 */
	public String getExcerpt() {
		return excerpt;
	}
	
	/**
	 * @param excerpt the excerpt to set
	 */
	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}
	
	/**
	 * @return the reviewLink
	 */
	public String getReviewLink() {
		return reviewLink;
	}
	
	/**
	 * @param reviewLink the reviewLink to set
	 */
	public void setReviewLink(String reviewLink) {
		this.reviewLink = reviewLink;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((criticId == null) ? 0 : criticId.hashCode());
		result = prime * result + ((excerpt == null) ? 0 : excerpt.hashCode());
		result = prime * result + id;
		result = prime * result + ((movieId == null) ? 0 : movieId.hashCode());
		result = prime * result + orgId;
		result = prime * result
				+ ((reviewLink == null) ? 0 : reviewLink.hashCode());
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
		MovieReview other = (MovieReview) obj;
		if (criticId == null) {
			if (other.criticId != null)
				return false;
		} else if (!criticId.equals(other.criticId))
			return false;
		if (excerpt == null) {
			if (other.excerpt != null)
				return false;
		} else if (!excerpt.equals(other.excerpt))
			return false;
		if (id != other.id)
			return false;
		if (movieId == null) {
			if (other.movieId != null)
				return false;
		} else if (!movieId.equals(other.movieId))
			return false;
		if (orgId != other.orgId)
			return false;
		if (reviewLink == null) {
			if (other.reviewLink != null)
				return false;
		} else if (!reviewLink.equals(other.reviewLink))
			return false;
		return true;
	}	
	
}
