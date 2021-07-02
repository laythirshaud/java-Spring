package com.ControllersViews.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ControllersViews.models.Event;

public interface EventRepository extends CrudRepository<Event, Long> {
	List<Event> findByStateNot(String state);
    List<Event> findAllByState(String state);
    void deleteEventById(Long id);
}

