/**
 * 
 */
package me.sumeetlubal.moviehub.librarymanager.cinemalytics.repo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import me.sumeetlubal.moviehub.librarymanager.cinemalytics.data.model.Actor;
import me.sumeetlubal.moviehub.librarymanager.cinemalytics.data.model.MovieCinemalytics;
import me.sumeetlubal.moviehub.librarymanager.cinemalytics.util.UrlUtil;

/**
 * @author Arjit
 *
 */
public class ActorRepository {

	private static ActorRepository instance;
	private static String authToken = null;

	private static final Gson gson = new Gson();

	private ActorRepository() {
	}

	public static ActorRepository Instance() {
		if (instance == null) {
			instance = new ActorRepository();
		}
		return instance;
	}

	void SetAuthToken(String authToken) {
		if (ActorRepository.authToken == null || ActorRepository.authToken.isEmpty()) {
			ActorRepository.authToken = authToken;
		}
	}

	/**
	 * Gets actor by id
	 * @param actorId
	 * @return
	 * @throws Exception
	 */
	public Actor GetActorById(String actorId) throws Exception {

		String url = "http://api.cinemalytics.in/v2/actor/id/" + actorId + "?auth_token=" + authToken;
		String jsonResponse = UrlUtil.MakeGetCall(url);

		Type type = new TypeToken<Actor>() {}.getType();
		return gson.fromJson(jsonResponse, type);
	}

	/**
	 * Gets actor by name
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public Actor GetActorByName(String name) throws Exception {
		String url = "http://api.cinemalytics.in/v2/actor/name/" + name + "?auth_token=" + authToken;
		String jsonResponse = UrlUtil.MakeGetCall(url);

		Type type = new TypeToken<Actor>() {}.getType();
		return gson.fromJson(jsonResponse, type);
	}

	/**
	 * Get all movies for actorId
	 * @param actorId
	 * @return
	 * @throws Exception
	 */
	public List<MovieCinemalytics> GetMoviesForActorById(String actorId) throws Exception {
		String url = "http://api.cinemalytics.in/v2/actor/" + actorId + "/movies?auth_token=" + authToken;
		String jsonResponse = UrlUtil.MakeGetCall(url);

		Type type = new TypeToken<List<MovieCinemalytics>>() {}.getType();
		return gson.fromJson(jsonResponse, type);
	}
}
