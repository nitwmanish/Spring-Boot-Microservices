package com.movie.info.webapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.movie.info.webapp.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {

}
