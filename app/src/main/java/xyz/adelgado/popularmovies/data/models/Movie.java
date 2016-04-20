package xyz.adelgado.popularmovies.data.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andredelgado on 15/04/16.
 */
public class Movie implements Parcelable {

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

  public Movie() {

  }

  public Movie(Parcel in) {
    String[] data = new String[7];

    in.readStringArray(data);
    this.id = Integer.valueOf(data[0]);
    this.title = data[1];
    this.overview = data[2];
    this.releaseDate = data[3];
    this.voteAverage = Double.parseDouble(data[4]);
    this.posterPath = data[5];
    this.backdropPath = data[6];
  }

  public String getId() {
    return String.valueOf(id);
  }

  public String getTitle() {
    return title;
  }

  public String getOverview() {
    return overview;
  }

  public String getReleaseYear() {
    return releaseDate;
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

  public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {

    @Override public Movie createFromParcel(Parcel source) {
      return new Movie(source);
    }

    @Override public Movie[] newArray(int size) {
      return new Movie[size];
    }
  };

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeStringArray(new String[] {
        String.valueOf(this.id), this.title, this.overview, this.releaseDate, String.valueOf(this.voteAverage),
        this.posterPath, this.backdropPath
    });
  }
}