package com.movie.catalog.webapp.model;

public class Rating {

	private long movieId;
	private double movieRating;
	private String userReview;

	public Rating() {
		super();
	}

	public Rating(long movieId, double movieRating, String userReview) {
		super();
		this.movieId = movieId;
		this.movieRating = movieRating;
		this.userReview = userReview;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public double getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(double movieRating) {
		this.movieRating = movieRating;
	}

	public String getUserReview() {
		return userReview;
	}

	public void setUserReview(String userReview) {
		this.userReview = userReview;
	}

}
