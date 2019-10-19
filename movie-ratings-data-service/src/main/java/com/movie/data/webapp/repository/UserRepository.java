package com.movie.data.webapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.movie.data.webapp.repository.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
