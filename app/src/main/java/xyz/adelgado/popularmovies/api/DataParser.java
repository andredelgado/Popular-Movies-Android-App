package xyz.adelgado.popularmovies.api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import xyz.adelgado.popularmovies.models.Movie;

/**
 * Created by andredelgado on 16/04/16.
 */
public class DataParser {

	public ArrayList<Movie> parseMovies(String moviesStr) {
		ArrayList<Movie> movies = new ArrayList<>();

		try {
			JSONObject jsonData = new JSONObject(moviesStr);
			JSONArray results = jsonData.getJSONArray("results");

			for(int i = 0; i < results.length(); i++) {
				JSONObject result = results.getJSONObject(i);

				String id = result.getString("id");
				String title = result.getString("original_title");
				String overview = result.getString("overview");
				String releaseYear = result.getString("release_date").substring(0,3);
				Double voteAverage = result.getDouble("vote_average");
				String posterPath = "http://image.tmdb.org/t/p/w500" + result.getString("poster_path");
				String backdropPath = result.getString("backdrop_path");

				movies.add(new Movie(id, title, overview, releaseYear, voteAverage, posterPath, backdropPath));
			}

		} catch(JSONException e) {
			e.printStackTrace();
		}

		return movies;
	}
}
