package xyz.adelgado.popularmovies.domain.Common;

import java.util.ArrayList;
import java.util.List;
import xyz.adelgado.popularmovies.data.api.pojo.MovieDetail;
import xyz.adelgado.popularmovies.data.models.Movie;
import xyz.adelgado.popularmovies.data.api.pojo.MovieData;

public class DataParser {

  public List<Movie> parseMovies(MovieData moviesData) {

    List<MovieDetail> movieDetails = moviesData.movieDetails;
    List<Movie> movies = new ArrayList<>();

    for(MovieDetail o : movieDetails) {
      String id = String.valueOf(o.id);
      String title = o.title;
      String overview = o.overview;
      String releaseYear = o.releaseDate.substring(0,4);
      Double voteAverage = o.voteAverage;
      String posterPath = "http://image.tmdb.org/t/p/w500/" + o.posterPath;
      String backdropPath = "http://image.tmdb.org/t/p/w500/" + o.backdropPath;

      Movie movie = new Movie();
      movie.setId(id);
      movie.setTitle(title);
      movie.setOverview(overview);
      movie.setReleaseYear(releaseYear);
      movie.setVoteAverage(voteAverage);
      movie.setPosterPath(posterPath);
      movie.setBackdropPath(backdropPath);
      movies.add(movie);
    }

    return movies;
  }

}