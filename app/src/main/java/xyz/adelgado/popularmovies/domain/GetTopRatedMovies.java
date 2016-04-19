package xyz.adelgado.popularmovies.domain;

import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;
import xyz.adelgado.popularmovies.data.api.TheMovieDBService;
import xyz.adelgado.popularmovies.data.models.Movie;
import xyz.adelgado.popularmovies.domain.Common.DataParser;

/**
 * Created by andredelgado on 18/04/16.
 */
public class GetTopRatedMovies {

  private TheMovieDBService theMovieDBService;
  private DataParser dataParser;

  @Inject public GetTopRatedMovies(TheMovieDBService theMovieDBService, DataParser dataParser) {
    this.theMovieDBService = theMovieDBService;
    this.dataParser = dataParser;
  }

  public Observable<List<Movie>> get() {
    return theMovieDBService.fetchTopRatedMovies().flatMap(moviesData ->
        Observable.create(new Observable.OnSubscribe<List<Movie>>() {
          @Override public void call(Subscriber<? super List<Movie>> subscriber) {
            subscriber.onNext(dataParser.parseMovies(moviesData));
            subscriber.onCompleted();
          }
        })
    );
  }

}