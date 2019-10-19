package com.movie.catalog.webapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.movie.catalog.webapp.model.CatalogItem;
import com.movie.catalog.webapp.model.Movie;
import com.movie.catalog.webapp.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class MovieInfoService {

	@Autowired
	private RestTemplate restTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieInfoService.class);

	@HystrixCommand(fallbackMethod = "getFallbackCatalogItems", threadPoolKey = "movieInfoPool", threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "20"), @HystrixProperty(name = "maxQueueSize", value = "10") })
	public List<CatalogItem> getCatalogItems(Rating rating) {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
//		Movie movie = restTemplate.getForObject("http://localhost:10001/movies/" + rating.getMovieId(), Movie.class);
		List<CatalogItem> catalogs = new ArrayList<>();
		LOGGER.info("Movie movieId " + movie.getMovieId());
		catalogs.add(new CatalogItem(movie.getMovieName(), movie.getMovieGenre(), movie.getMovieReleaseDate(),
				movie.getMovieDescription(), rating.getMovieRating(), rating.getUserReview()));
		return catalogs;
	}

	public List<CatalogItem> getFallbackCatalogItems(@PathVariable("userId") long userId, Rating rating) {
		return Arrays.asList(new CatalogItem("Fallback moview", "Fallback moview Genre", null,
				"Fallback moview Description", 0, "Fallback moview UserReview"));
	}
}
