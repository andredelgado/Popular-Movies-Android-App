package xyz.adelgado.popularmovies.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.adelgado.popularmovies.R;
import xyz.adelgado.popularmovies.adapters.MoviesAdapter;
import xyz.adelgado.popularmovies.api.FetchMovies;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

	public MainActivityFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_main, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		MoviesAdapter moviesAdapter = new MoviesAdapter(getContext());
		RecyclerView moviesList = (RecyclerView) view.findViewById(R.id.movies_recyclerview);

		moviesList.setHasFixedSize(true);
		moviesList.setLayoutManager(
				new GridLayoutManager(getContext(), 2)
		);
		moviesList.setAdapter(moviesAdapter);
		FetchMovies fetchMovies = new FetchMovies(moviesAdapter);
		fetchMovies.execute("popular");
	}
}
