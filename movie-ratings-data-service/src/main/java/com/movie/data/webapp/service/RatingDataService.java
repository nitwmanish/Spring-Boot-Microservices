package com.movie.data.webapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.data.webapp.repository.RatingRepository;
import com.movie.data.webapp.repository.UserRepository;
import com.movie.data.webapp.repository.model.Rating;
import com.movie.data.webapp.repository.model.User;
import com.movie.data.webapp.view.model.ViewRating;
import com.movie.data.webapp.view.model.ViewUser;

@Service
public class RatingDataService {

	@Autowired
	private RatingRepository ratingRepository;

	@Autowired
	private UserRepository userRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(RatingDataService.class);

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
		User user = new User("abcd@gmail.com", "abcd", "8901234567", parseDate("1990-01-18"));
		Rating rating = new Rating(1L, 7.5, "This is fantasting movie, I love it");
		Rating rating2 = new Rating(2L, 8.5, "Great movie, it is base on true story");
		List<Rating> ratings = new ArrayList<>();
		ratings.add(rating);
		ratings.add(rating2);
		user.setRatings(ratings);
		rating.setUser(user);
		rating2.setUser(user);
		userRepository.save(user);

		user = new User("xyz@gmail.com", "xyz", "9981234567", parseDate("1995-07-31"));
		rating = new Rating(3L, 7.5, "This is a good movie, I do like it");
		rating2 = new Rating(4L, 8.5, "average movie, acting was very poor");
		user.setRatings(Arrays.asList(rating, rating2));
		rating.setUser(user);
		rating2.setUser(user);
		userRepository.save(user);

		user = new User("opq@gmail.com", "opq", "8881234567", parseDate("1985-11-07"));
		rating = new Rating(1L, 9.5, "wow! such great movie, I loveee itt");
		rating2 = new Rating(3L, 8.7, "nice movie, acting was mind blowing");
		user.setRatings(Arrays.asList(rating, rating2));
		rating.setUser(user);
		rating2.setUser(user);
		userRepository.save(user);

		user = new User("jkl@gmail.com", "jkl", "7981234567", parseDate("1985-03-17"));
		rating = new Rating(2L, 7.75, "amazing movie, I love this movie");
		rating2 = new Rating(4L, 8.1, "fabulous movie, great actor with dashing personality");
		user.setRatings(Arrays.asList(rating, rating2));
		rating.setUser(user);
		rating2.setUser(user);
		userRepository.save(user);

		LOGGER.info("init sucess");
	}

	public ViewRating getRatingsForAllMoviesRatedByUser(long userId) {
		Iterable<Rating> usersRatings = ratingRepository.findAll();
		ViewRating viewRating = new ViewRating();
		viewRating.setUserId(userId);
		for (Rating rating : usersRatings) {
			if (rating.getUser().getUserId() == userId) {

				viewRating.getRatings().add(rating);
			}
		}
		LOGGER.info("getRatingsForAllMoviesRatedByUser sucess");
		return viewRating;
	}

	public ViewUser getAllUsersRatedGivenMovie(long movieId) {
		Iterable<Rating> usersRatings = ratingRepository.findAll();
		ViewUser viewUser = new ViewUser();
		viewUser.setMovieId(movieId);
		for (Rating rating : usersRatings) {
			if (rating.getMovieId() == movieId) {
				viewUser.getUsers().add(userRepository.findById(rating.getUser().getUserId()).get());
			}
		}
		LOGGER.info("getAllUsersRatedGivenMovie sucess");
		return viewUser;
	}

	public List<User> getAllUser() {
		Iterable<User> iterable = userRepository.findAll();
		Iterator<User> iterator = iterable.iterator();
		List<User> users = new ArrayList<>();
		while (iterator.hasNext()) {
			users.add(iterator.next());
		}
		LOGGER.info("getAllUser sucess");
		return users;
	}

}
