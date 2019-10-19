package com.movie.info.webapp.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movie.info.webapp.model.Movie;
import com.movie.info.webapp.service.MovieInfoService;

@RestController
public class MovieInfoController {

	@Autowired
	private MovieInfoService movieService;

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieInfoController.class);

	@RequestMapping("/movies")
	public ResponseEntity<List<Movie>> getAllMovies() {
		List<Movie> movies = null;
		try {
			movies = movieService.getAllMovies();
			LOGGER.info("getAllMovies sucess");
			return new ResponseEntity<>(movies, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("getAllMovies eception " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/movies/{movieId}")
	public ResponseEntity<Movie> getMovie(@PathVariable long movieId) {
		Optional<Movie> optional = null;
		try {
			optional = movieService.getMovie(movieId);
			Movie movie = optional.get();
			LOGGER.info("getMovie sucess");
			return new ResponseEntity<>(movie, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("getMovie eception " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = "/movies")
	public ResponseEntity<?> addMovie(@RequestBody Movie movie) {
		try {
			movieService.addMovie(movie);
			LOGGER.info("addMovie sucess");
			return new ResponseEntity(HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.error("addMovie eception " + e.getMessage());
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/movies/{movieId}")
	public ResponseEntity<?> updateMovie(@RequestBody Movie movie, @PathVariable String movieId) {

		try {
			movieService.updateMovie(movie, movieId);
			LOGGER.info("updateMovie sucess");
			return new ResponseEntity(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			LOGGER.error("updateMovie eception " + e.getMessage());
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.PATCH, value = "/movies/{movieId}")
	public ResponseEntity<?> partialUpdateMovie(@RequestBody Movie movie, @PathVariable String movieId) {

		try {
			movieService.updateMovie(movie, movieId);
			LOGGER.info("partialUpdateMovie sucess");
			return new ResponseEntity(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			LOGGER.error("partialUpdateMovie eception " + e.getMessage());
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/movies/{movieId}")
	public ResponseEntity<?> deleteMovie(@PathVariable long movieId) {
		try {
			movieService.deleteMovie(movieId);
			LOGGER.info("deleteMovie sucess");
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			LOGGER.error("deleteMovie eception " + e.getMessage());
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
