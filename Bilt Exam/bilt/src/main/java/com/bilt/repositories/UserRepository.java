package com.bilt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bilt.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	 User findByEmail(String email);
	    List<User> findAll();
}