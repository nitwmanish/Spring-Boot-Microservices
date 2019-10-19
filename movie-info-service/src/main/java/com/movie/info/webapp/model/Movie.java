package com.movie.info.webapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MOVIE_TABLE")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name = "MOVIE_ID")
	private long movieId;

	@Column(name = "MOVIE_NAME")
	private String movieName;

	@Column(name = "MOVIE_GENRE")
	private String movieGenre;

	@Temporal(TemporalType.DATE)
	@Column(name = "MOVIE_RELEASE_DATE")
	private Date movieReleaseDate;

	@Column(name = "MOVIE_DESCRIPTION")
	private String movieDescription;

	public Movie() {
		super();
	}

	public Movie(String movieName, String movieGenre, Date movieReleaseDate, String movieDescription) {
		super();
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieReleaseDate = movieReleaseDate;
		this.movieDescription = movieDescription;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
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

}
