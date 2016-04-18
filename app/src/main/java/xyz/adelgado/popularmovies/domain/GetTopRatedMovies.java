package xyz.adelgado.popularmovies.domain;

import javax.inject.Inject;
import rx.Observable;
import xyz.adelgado.popularmovies.data.api.TheMovieDBService;
import xyz.adelgado.popularmovies.data.models.MovieData;

/**
 * Created by andredelgado on 18/04/16.
 */
public class GetTopRatedMovies {

  private TheMovieDBService theMovieDBService;

  @Inject public GetTopRatedMovies(TheMovieDBService theMovieDBService) {
    this.theMovieDBService = theMovieDBService;
  }

  public Observable<MovieData> get() {
    return theMovieDBService.fetchTopRatedMovies();
  }
}

/*

return new Movie(
            String.valueOf(movieDetail.id),
            movieDetail.title, movieDetail.overview,
            movieDetail.releaseDate,
            movieDetail.voteAverage,
            movieDetail.posterPath,
            movieDetail.backdropPath);

 */