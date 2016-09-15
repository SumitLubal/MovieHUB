/**
 * 
 */
package me.sumeetlubal.moviehub.librarymanager.cinemalytics.data.model;

/**
 * @author Arjit
 *
 */
public class Song {
	
	private String id;
	private String title;
	private float duration;
	private short isFinal;
	
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
	 * @return the duration
	 */
	public float getDuration() {
		return duration;
	}
	
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(float duration) {
		this.duration = duration;
	}
	
	/**
	 * @return the isFinal
	 */
	public short getIsFinal() {
		return isFinal;
	}
	
	/**
	 * @param isFinal the isFinal to set
	 */
	public void setIsFinal(short isFinal) {
		this.isFinal = isFinal;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(duration);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + isFinal;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Song other = (Song) obj;
		if (Float.floatToIntBits(duration) != Float
				.floatToIntBits(other.duration))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isFinal != other.isFinal)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
        
}
