package com.index.repository;

import org.springframework.data.repository.CrudRepository;

import com.index.model.User;
import java.lang.String;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUserName(String username);

	/**
	 * http://docs.spring.io/spring-data/jpa/docs/current/reference/html/
	 * 
	 */
}
