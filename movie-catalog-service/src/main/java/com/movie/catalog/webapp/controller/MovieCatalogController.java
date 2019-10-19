package com.movie.catalog.webapp.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.catalog.webapp.model.CatalogItem;
import com.movie.catalog.webapp.model.Rating;
import com.movie.catalog.webapp.model.UserRating;
import com.movie.catalog.webapp.service.MovieInfoService;
import com.movie.catalog.webapp.service.UserRatingService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	@Autowired
	private UserRatingService userRatingService;

	@Autowired
	private MovieInfoService movieInfoService;

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieCatalogController.class);

	@RequestMapping("/{userId}")
	@HystrixCommand(fallbackMethod = "getFallbackCatalog")
	public ResponseEntity<List<CatalogItem>> getCatalogs(@PathVariable("userId") long userId) {
		try {

			UserRating userRating = userRatingService.getUserRating(userId);
			LOGGER.info("UserRating userId " + userRating.getUserId());
			List<CatalogItem> catalogs = null;
			for (Rating rating : userRating.getRatings()) {
				catalogs = movieInfoService.getCatalogItems(rating);
			}
			LOGGER.info("getCatalog sucess");
			return new ResponseEntity<>(catalogs, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("getCatalog eception " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<CatalogItem>> getFallbackCatalog(@PathVariable("userId") long userId) {
		return new ResponseEntity<>(Arrays.asList(new CatalogItem("Fallback moview", "Fallback moview Genre", null,
				"Fallback moview Description", 0, "Fallback moview UserReview")), HttpStatus.OK);
	}
}