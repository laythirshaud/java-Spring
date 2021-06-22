package com.example.Languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Languages.models.LanguagesModel;
@Repository
public interface LanguagesRepository extends CrudRepository<LanguagesModel, Long> {
	List<LanguagesModel> findAll();
	
//	List<LanguagesModel> findByDescriptionContaining(String search);
//	Long deleteByTitleStartingWith(String search);
	

}
