package xyz.adelgado.popularmovies.data.api.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andredelgado on 19/04/16.
 */
public class MovieDetail {

  public String posterPath;
  public Boolean adult;
  public String overview;
  public String releaseDate;
  public List<Integer> genreIds = new ArrayList<Integer>();
  public Integer id;
  public String originalTitle;
  public String originalLanguage;
  public String title;
  public String backdropPath;
  public Double popularity;
  public Integer voteCount;
  public Boolean video;
  public Double voteAverage;
}
