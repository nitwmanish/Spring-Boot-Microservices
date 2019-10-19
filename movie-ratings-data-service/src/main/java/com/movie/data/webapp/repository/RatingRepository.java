package com.movie.data.webapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.movie.data.webapp.repository.model.Rating;

public interface RatingRepository extends CrudRepository<Rating, Long> {

}
