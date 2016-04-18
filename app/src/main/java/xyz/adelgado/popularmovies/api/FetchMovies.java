package xyz.adelgado.popularmovies.api;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import xyz.adelgado.popularmovies.BuildConfig;
import xyz.adelgado.popularmovies.models.Movie;

/**
 * Created by andredelgado on 15/04/16.
 */
public class FetchMovies extends AsyncTask<String, Void, ArrayList<Movie>> {

	private static final String TAG = FetchMovies.class.getSimpleName();

	private static final String API_KEY_PARAM = "api_key";
	private static final String BASE_URL = "http://api.themoviedb.org/3/movie/";

	private static final String POPULAR_MOVIES = "popular";
	private static final String TOP_RATED_MOVIES = "top_rated";

	private static final String REQUEST_METHOD = "GET";

	private OnFetchMoviesCompleted listener;

	public interface OnFetchMoviesCompleted {
		void onFetchMoviesCompleted(ArrayList<Movie> response);
	}

	public FetchMovies(OnFetchMoviesCompleted listener) {
		this.listener = listener;
	}

	@Override
	protected ArrayList<Movie> doInBackground(String... params) {
		final String action;

		if(params[0].equals(POPULAR_MOVIES) || params[0].equals(TOP_RATED_MOVIES)) action = params[0];
		else return null;

		String fetchedMoviesStr = null;
		HttpURLConnection urlConnection = null;
		BufferedReader reader = null;
		StringBuilder result = new StringBuilder();

		try {
			final String FINAL_URL = BASE_URL + action;

			Uri builtUri = Uri.parse(FINAL_URL).buildUpon()
					.appendQueryParameter(API_KEY_PARAM, BuildConfig.THE_MOVIE_DATABASE_API_KEY)
					.build();

			URL url = new URL(builtUri.toString());

			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod(REQUEST_METHOD);
			urlConnection.connect();

			InputStream inputStream = urlConnection.getInputStream();
			if(inputStream == null) return null;

			reader = new BufferedReader(new InputStreamReader(inputStream));

			String line;
			while((line = reader.readLine()) != null) result.append(line);

			fetchedMoviesStr = result.toString();

		} catch(IOException e) {
			Log.e(TAG, e.getMessage());
		} finally {
			if (urlConnection != null) urlConnection.disconnect();
			if (reader != null) {
				try {
					reader.close();
				} catch (final IOException e) {
					Log.e(TAG, e.getMessage());
				}
			}
		}

		return new DataParser().parseMovies(fetchedMoviesStr);
	}

	@Override
	protected void onPostExecute(ArrayList<Movie> movies) {
		listener.onFetchMoviesCompleted(movies);
	}
}
