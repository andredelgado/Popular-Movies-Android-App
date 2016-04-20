package xyz.adelgado.popularmovies.data.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;
import xyz.adelgado.popularmovies.BuildConfig;
import xyz.adelgado.popularmovies.data.models.Movie;

@Singleton public class TheMovieDBService {

  private static final String API_KEY = BuildConfig.THE_MOVIE_DATABASE_API_KEY;
  private static final String BASE_URL = "http://api.themoviedb.org/3/movie/";

  private TheMovieDBWebService theMovieDBWebService;

  @Inject public TheMovieDBService(OkHttpClient client) {

    Gson gson =
        new GsonBuilder()
            .registerTypeAdapter(Movie.class, new MoviesDeserializer<List<Movie>>())
            .create();

    Retrofit retrofit =
        new Retrofit.Builder().client(client)
          .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
          .addConverterFactory(GsonConverterFactory.create(gson))
          .baseUrl(BASE_URL)
          .build();

    theMovieDBWebService = retrofit.create(TheMovieDBWebService.class);
  }

  public interface TheMovieDBWebService {
    @GET("popular?api_key=" + API_KEY) Observable<List<Movie>> fetchPopularMovies();
    @GET("top_rated?api_key=" + API_KEY) Observable<List<Movie>> fetchTopRatedMovies();
  }

  public Observable<List<Movie>> fetchPopularMovies() {
    return theMovieDBWebService.fetchPopularMovies();
  }

  public Observable<List<Movie>> fetchTopRatedMovies() {
    return theMovieDBWebService.fetchTopRatedMovies();
  }
}
