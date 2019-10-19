package com.movie.data.webapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.data.webapp.repository.model.User;
import com.movie.data.webapp.service.RatingDataService;
import com.movie.data.webapp.view.model.ViewRating;
import com.movie.data.webapp.view.model.ViewUser;

@RestController
@RequestMapping("/ratingsdata")
public class MovieRatingsController {

	@Autowired
	private RatingDataService ratingDataService;

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieRatingsController.class);

	@RequestMapping("/users")
	public ResponseEntity<List<User>> getAllUser() {

		try {
			List<User> users = ratingDataService.getAllUser();
			LOGGER.info("getAllUser sucess");
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("getAllUser eception " + e.getMessage());
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping("/users/{userId}")
	public ResponseEntity<ViewRating> getRatingsForAllMoviesRatedByUser(@PathVariable("userId") long userId) {

		try {
			ViewRating viewRating = ratingDataService.getRatingsForAllMoviesRatedByUser(userId);
			LOGGER.info("getRatingsForAllMoviesRatedByUser sucess");
			return new ResponseEntity<>(viewRating, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("getRatingsForAllMoviesRatedByUser eception " + e.getMessage());
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping("/movies/{movieId}")
	public ResponseEntity<ViewUser> getAllUsersRatedGivenMovie(@PathVariable("movieId") long movieId) {

		try {
			ViewUser viewUser = ratingDataService.getAllUsersRatedGivenMovie(movieId);
			LOGGER.info("getAllUsersRatedGivenMovie sucess");
			return new ResponseEntity<>(viewUser, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("getAllUsersRatedGivenMovie eception " + e.getMessage());
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
