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

import xyz.adelgado.popularmovies.adapters.MoviesAdapter;
import xyz.adelgado.popularmovies.models.Movie;

/**
 * Created by andredelgado on 15/04/16.
 */
public class FetchMovies extends AsyncTask<String, Void, ArrayList<Movie>> {

	private static final String TAG = FetchMovies.class.getSimpleName();

	private MoviesAdapter moviesAdapter;

	public FetchMovies(MoviesAdapter moviesAdapter) {
		this.moviesAdapter = moviesAdapter;
	}

	@Override
	protected ArrayList<Movie> doInBackground(String... params) {
		final String ACTION;

		if(params[0].equals("popular") || params[0].equals("top_rated")) {
			ACTION = params[0];
		} else {
			return null;
		}

		String fetchedMoviesStr = null;
		HttpURLConnection urlConnection = null;
		BufferedReader reader = null;
		StringBuilder result = new StringBuilder();

		try {
			final String FORECAST_BASE_URL =
					"http://api.themoviedb.org/3/movie/" + ACTION;
			final String API_KEY_PARAM = "api_key";

			Uri builtUri = Uri.parse(FORECAST_BASE_URL).buildUpon()
					.appendQueryParameter(API_KEY_PARAM, "KEY")
					.build();

			URL url = new URL(builtUri.toString());

			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.connect();

			InputStream inputStream = urlConnection.getInputStream();
			if(inputStream == null) {
				return null;
			}

			reader = new BufferedReader(new InputStreamReader(inputStream));

			String line;
			while((line = reader.readLine()) != null) {
				result.append(line);
			}
			fetchedMoviesStr = result.toString();

		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if (urlConnection != null) {
				urlConnection.disconnect();
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}

		Log.d(TAG, fetchedMoviesStr);
		return new DataParser().parseMovies(fetchedMoviesStr);
	}

	@Override
	protected void onPostExecute(ArrayList<Movie> movies) {
		moviesAdapter.addData(movies);
	}
}
