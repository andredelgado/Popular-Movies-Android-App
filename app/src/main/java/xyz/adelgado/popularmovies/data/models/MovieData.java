package xyz.adelgado.popularmovies.data.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andredelgado on 19/04/16.
 */
public class MovieData {

  public Integer page;
  public List<MovieDetail> movieDetails = new ArrayList<MovieDetail>();
  public Integer totalResults;
  public Integer totalPages;
}
