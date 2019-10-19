package com.movie.catalog.webapp.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.movie.catalog.webapp.model.Rating;
import com.movie.catalog.webapp.model.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class UserRatingService {

	@Autowired
	private RestTemplate restTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRatingService.class);

	@HystrixCommand(fallbackMethod = "getFallbackUserRating", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000") })
	public UserRating getUserRating(long userId) {
//		UserRating userRating = restTemplate.getForObject("http://localhost:11001/ratingsdata/users/" + userId,
//				UserRating.class);
		LOGGER.info("User userId " + userId);
		UserRating userRating = restTemplate
				.getForObject("http://movie-ratings-data-service/ratingsdata/user/" + userId, UserRating.class);
		return userRating;
	}

	public UserRating getFallbackUserRating(@PathVariable("userId") long userId) {
		return new UserRating(userId, Arrays.asList(new Rating(0, 0, "Fallback moview UserReview")));
	}

}
