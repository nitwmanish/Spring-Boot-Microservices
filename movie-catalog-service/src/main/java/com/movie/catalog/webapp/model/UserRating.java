package com.movie.catalog.webapp.model;

import java.util.List;

public class UserRating {

	private long userId;
	private List<Rating> ratings;

	public UserRating() {
		super();
	}

	public UserRating(long userId, List<Rating> ratings) {
		super();
		this.userId = userId;
		this.ratings = ratings;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

}
