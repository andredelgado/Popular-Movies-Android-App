package xyz.adelgado.popularmovies.data.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by andredelgado on 15/04/16.
 */
public class Movie implements Parcelable {

  public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {

    @Override public Movie createFromParcel(Parcel source) {
      return new Movie(source);
    }

    @Override public Movie[] newArray(int size) {
      return new Movie[size];
    }
  };
  private String id;
  private String title;
  private String overview;
  private String releaseYear;
  private Double voteAverage;
  private String posterPath;
  private String backdropPath;

  public Movie() {

  }

  public Movie(Parcel in) {
    String[] data = new String[7];

    in.readStringArray(data);
    this.id = data[0];
    this.title = data[1];
    this.overview = data[2];
    this.releaseYear = data[3];
    this.voteAverage = Double.parseDouble(data[4]);
    this.posterPath = data[5];
    this.backdropPath = data[6];
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setOverview(String overview) {
    this.overview = overview;
  }

  public void setReleaseYear(String releaseYear) {
    this.releaseYear = releaseYear;
  }

  public void setVoteAverage(Double voteAverage) {
    this.voteAverage = voteAverage;
  }

  public void setPosterPath(String posterPath) {
    this.posterPath = posterPath;
  }

  public void setBackdropPath(String backdropPath) {
    this.backdropPath = backdropPath;
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getOverview() {
    return overview;
  }

  public String getReleaseYear() {
    return releaseYear;
  }

  public Double getVoteAverage() {
    return voteAverage;
  }

  public String getPosterPath() {
    return posterPath;
  }

  public String getBackdropPath() {
    return backdropPath;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeStringArray(new String[] {
        this.id, this.title, this.overview, this.releaseYear, String.valueOf(this.voteAverage),
        this.posterPath, this.backdropPath
    });
  }
}