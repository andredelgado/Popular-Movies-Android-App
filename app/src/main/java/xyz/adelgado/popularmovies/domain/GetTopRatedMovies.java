package xyz.adelgado.popularmovies.domain;

import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import xyz.adelgado.popularmovies.data.api.TheMovieDBService;
import xyz.adelgado.popularmovies.data.models.Movie;

/**
 * Created by andredelgado on 18/04/16.
 */
public class GetTopRatedMovies {

  private TheMovieDBService theMovieDBService;

  @Inject public GetTopRatedMovies(TheMovieDBService theMovieDBService) {
    this.theMovieDBService = theMovieDBService;
  }

  public Observable<List<Movie>> get() {
    return theMovieDBService.fetchTopRatedMovies();
  }

}