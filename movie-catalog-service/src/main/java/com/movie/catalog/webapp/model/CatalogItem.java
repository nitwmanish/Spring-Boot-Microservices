package com.movie.catalog.webapp.model;

import java.util.Date;

public class CatalogItem {
	private String movieName;
	private String movieGenre;
	private Date movieReleaseDate;
	private String movieDescription;
	private double movieRating;
	private String userReview;

	public CatalogItem() {
		super();
	}

	public CatalogItem(String movieName, String movieGenre, Date movieReleaseDate, String movieDescription,
			double movieRating, String userReview) {
		super();
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieReleaseDate = movieReleaseDate;
		this.movieDescription = movieDescription;
		this.movieRating = movieRating;
		this.userReview = userReview;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public Date getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public void setMovieReleaseDate(Date movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
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
