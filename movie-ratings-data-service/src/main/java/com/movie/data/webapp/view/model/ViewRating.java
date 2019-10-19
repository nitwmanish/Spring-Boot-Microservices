package com.movie.data.webapp.view.model;

import java.util.ArrayList;
import java.util.List;

import com.movie.data.webapp.repository.model.Rating;

public class ViewRating {

	private long userId;
	private List<Rating> ratings;

	public ViewRating() {
		super();
		ratings = new ArrayList<>();
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
