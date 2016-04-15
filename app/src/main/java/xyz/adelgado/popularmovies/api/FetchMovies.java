package xyz.adelgado.popularmovies.api;

import android.os.AsyncTask;

/**
 * Created by andredelgado on 15/04/16.
 */
public class FetchMovies extends AsyncTask<Void, Void, Void> {

	public FetchMovies(String action) {
		switch(action) {
			case "popular":
				break;
			case "top":
				break;
		}
	}

	@Override
	protected Void doInBackground(Void... params) {
		return null;
	}
}
