package xyz.adelgado.popularmovies.domain;

import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;
import xyz.adelgado.popularmovies.data.api.TheMovieDBService;
import xyz.adelgado.popularmovies.data.models.Movie;
import xyz.adelgado.popularmovies.domain.Common.DataParser;

public class GetPopularMovies {

  private TheMovieDBService theMovieDBService;
  private DataParser dataParser;

  @Inject public GetPopularMovies(TheMovieDBService theMovieDBService, DataParser dataParser) {
    this.theMovieDBService = theMovieDBService;
    this.dataParser = dataParser;
  }

  public Observable<List<Movie>> get() {
    return theMovieDBService.fetchPopularMovies().flatMap(moviesData ->
        Observable.create(new Observable.OnSubscribe<List<Movie>>() {
          @Override public void call(Subscriber<? super List<Movie>> subscriber) {
            subscriber.onNext(dataParser.parseMovies(moviesData));
            subscriber.onCompleted();
          }
        })
    );
  }
}
