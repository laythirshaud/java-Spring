package com.example.Events.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.Events.models.Event;

public interface EventRepository extends CrudRepository<Event, Long>{
	List<Event> findByState(String state);
	List<Event> findByStateIsNot(String state);
}