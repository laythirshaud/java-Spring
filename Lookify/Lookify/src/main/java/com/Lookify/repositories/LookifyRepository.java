package com.Lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Lookify.models.Lookify;

@Repository
public interface LookifyRepository extends CrudRepository<Lookify, Long> {
	List<Lookify> findAll();
	List<Lookify> findByArtistContaining(String searchName);
	List<Lookify> findTop10ByOrderByRatingDesc();

}
