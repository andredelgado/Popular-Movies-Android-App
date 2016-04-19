package xyz.adelgado.popularmovies.data.api.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andredelgado on 19/04/16.
 */
public class MovieData {

  public Integer page;
  public List<MovieDetail> movieDetails = new ArrayList<>();
  public Integer totalResults;
  public Integer totalPages;
}
