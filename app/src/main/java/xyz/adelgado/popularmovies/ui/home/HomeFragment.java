package xyz.adelgado.popularmovies.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import xyz.adelgado.popularmovies.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeFragment extends Fragment {

  private MoviesAdapter moviesAdapter;

  public HomeFragment() {
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    return inflater.inflate(R.layout.fragment_main, container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    moviesAdapter = new MoviesAdapter(getContext());
    RecyclerView moviesList = (RecyclerView) view.findViewById(R.id.movies_recyclerview);

    moviesList.setHasFixedSize(true);

    if (getActivity().getResources().getConfiguration().orientation == 1) {
      moviesList.setLayoutManager(new GridLayoutManager(getContext(), 2));
    } else if (getActivity().getResources().getConfiguration().orientation == 2) {
      moviesList.setLayoutManager(new GridLayoutManager(getContext(), 4));
    }
    moviesList.setAdapter(moviesAdapter);
  }

  /*public void updateMovies(String action) {
    FetchMovies fetchMovies =
        new FetchMovies(getContext(), new FetchMovies.OnFetchMoviesCompleted() {
          @Override public void onFetchMoviesCompleted(ArrayList<Movie> response) {
            if(response != null) {
              moviesAdapter.clear();
              moviesAdapter.addData(response);
            } else {
              Toast.makeText(getContext(), "No internet connection!", Toast.LENGTH_LONG).show();
            }
          }
        });
    fetchMovies.execute(action);
  }*/
}
