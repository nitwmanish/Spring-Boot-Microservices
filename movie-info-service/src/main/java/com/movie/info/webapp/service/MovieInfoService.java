package com.movie.info.webapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.info.webapp.model.Movie;
import com.movie.info.webapp.repository.MovieRepository;

@Service
public class MovieInfoService {

	@Autowired
	private MovieRepository movieRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieInfoService.class);

	public static Date parseDate(String dateString) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
			LOGGER.info("parseDate sucess");
		} catch (ParseException e) {
			LOGGER.info("parseDate eception " + e.getMessage());
		}
		return date;
	}

	@PostConstruct
	private void init() {
		List<Movie> movies = Arrays.asList(new Movie("Titanic", "Drama|Disaster", parseDate("1997-11-18"),
				"A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic."),
				new Movie("Toy Story", "Animation|Adventure|Comedy ", parseDate(" 1995-11-22"),
						"A cowboy doll is profoundly threatened and jealous when a new spaceman figure supplants him as top toy in a boy's room."),
				new Movie("Dracula: Dead and Loving It", "Comedy|Fantasy|Horror ", parseDate("1995-12-22"),
						"Mel Brooks' parody of the classic vampire story and its famous film adaptations."),
				new Movie("Money Train", "Action|Comedy|Crime ", parseDate("1995-11-22"),
						"A vengeful New York City transit cop decides to steal a trainload of subway fares. His foster brother, a fellow cop, tries to protect him."),
				new Movie("Copycat ", "Drama|Mystery|Thriller ", parseDate("1997-10-27"),
						"An agoraphobic psychologist and a female detective must work together to take down a serial killer who copies serial killers from the past."));

		for (Movie movie : movies) {
			movieRepository.save(movie);
		}
		LOGGER.info("init sucess");
	}

	public List<Movie> getAllMovies() {
		List<Movie> movies = new ArrayList<>();
		movieRepository.findAll().forEach(movies::add);
		LOGGER.info("getAllMovies sucess");
		return movies;
	}

	public Optional<Movie> getMovie(long movieId) {
		LOGGER.info("getMovie sucess");
		return movieRepository.findById(movieId);
	}

	public void addMovie(Movie movie) {
		LOGGER.info("addMovie sucess");
		movieRepository.save(movie);
	}

	public void updateMovie(Movie movie, String movieId) {
		LOGGER.info("updateMovie sucess");
		movieRepository.save(movie);
	}

	public void deleteMovie(long movieId) {
		LOGGER.info("deleteMovie sucess");
		movieRepository.deleteById(movieId);
	}

}
