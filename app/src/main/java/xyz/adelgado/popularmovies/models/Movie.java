package xyz.adelgado.popularmovies.models;

/**
 * Created by andredelgado on 15/04/16.
 */
public class Movie {

	private String id;
	private String title;
	private String overview;
	private String releaseDate;
	private Double voteAverage;
	private String posterPath;
	private String backdropPath;

	public Movie(String id, String title, String overview, String releaseDate, Double voteAverage, String posterPath, String backdropPath) {
		this.id = id;
		this.title = title;
		this.overview = overview;
		this.releaseDate = releaseDate;
		this.voteAverage = voteAverage;
		this.posterPath = posterPath;
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

	public String getReleaseDate() {
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
}