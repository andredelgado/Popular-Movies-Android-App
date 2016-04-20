package xyz.adelgado.popularmovies.domain;

import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import xyz.adelgado.popularmovies.data.api.TheMovieDBService;
import xyz.adelgado.popularmovies.data.models.Movie;

public class GetPopularMovies {

  private TheMovieDBService theMovieDBService;

  @Inject public GetPopularMovies(TheMovieDBService theMovieDBService) {
    this.theMovieDBService = theMovieDBService;
  }

  public Observable<List<Movie>> get() {
    return theMovieDBService.fetchPopularMovies();
  }
}
