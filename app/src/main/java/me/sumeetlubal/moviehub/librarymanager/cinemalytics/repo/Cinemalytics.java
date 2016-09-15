/**
 * 
 */
package me.sumeetlubal.moviehub.librarymanager.cinemalytics.repo;

/**
 * @author Arjit
 *
 */
public class Cinemalytics {

	private static String authToken = "";

	/**
	 * Constructs an instance with provided authToken
	 * 
	 * @param authToken
	 */
	public Cinemalytics(String authToken) {
		Cinemalytics.authToken = authToken;
	}

	/**
	 * Gets the MovieRepository singleton instance. MovieRepository is endpoint
	 * for all movie related queries
	 * 
	 * @return
	 */
	public MovieRepository GetMovieRepositoryInstance() {
		MovieRepository mr = MovieRepository.Instance();
		mr.SetAuthToken(authToken);
		return mr;
	}
}
