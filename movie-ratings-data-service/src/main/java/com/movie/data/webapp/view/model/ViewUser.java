package com.movie.data.webapp.view.model;

import java.util.ArrayList;
import java.util.List;

import com.movie.data.webapp.repository.model.User;

public class ViewUser {

	private long movieId;
	private List<User> users;

	public ViewUser() {
		super();
		users = new ArrayList<>();
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
