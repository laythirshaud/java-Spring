package com.bilt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bilt.models.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {
	List<Course> findAll();

}
