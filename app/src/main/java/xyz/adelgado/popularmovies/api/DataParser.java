package xyz.adelgado.popularmovies.api;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import xyz.adelgado.popularmovies.models.Movie;

/**
 * Created by andredelgado on 16/04/16.
 */
public class DataParser {

	private static final String TAG = DataParser.class.getSimpleName();

	private static final String ID_FIELD = "id";
	private static final String TITLE_FIELD = "original_title";
	private static final String OVERVIEW_FIELD = "overview";
	private static final String RELEASE_DATE_FIELD = "release_date";
	private static final String VOTE_AVERAGE_FIELD = "vote_average";
	private static final String POSTER_PATH_FIELD = "poster_path";
	private static final String BACKDROP_PATH_FIELD = "backdrop_path";

	private static final String IMAGE_URL_SLUG = "http://image.tmdb.org/t/p/w780";

	public ArrayList<Movie> parseMovies(String moviesStr) {

		ArrayList<Movie> movies = new ArrayList<>();

		try {
			JSONObject jsonData = new JSONObject(moviesStr);
			JSONArray results = jsonData.getJSONArray("results");

			for(int i = 0; i < results.length(); i++) {
				JSONObject result = results.getJSONObject(i);

				String id = result.getString(ID_FIELD);
				String title = result.getString(TITLE_FIELD);
				String overview = result.getString(OVERVIEW_FIELD);
				String releaseYear = result.getString(RELEASE_DATE_FIELD).substring(0,4);
				Double voteAverage = result.getDouble(VOTE_AVERAGE_FIELD);
				String posterPath = IMAGE_URL_SLUG + result.getString(POSTER_PATH_FIELD);
				String backdropPath = IMAGE_URL_SLUG + result.getString(BACKDROP_PATH_FIELD);

				movies.add(
						new Movie(
								id,
								title,
								overview,
								releaseYear,
								voteAverage,
								posterPath,
								backdropPath
						)
				);
			}

		} catch(JSONException e) {
			Log.d(TAG, e.getMessage());
		}

		return movies;
	}
}
