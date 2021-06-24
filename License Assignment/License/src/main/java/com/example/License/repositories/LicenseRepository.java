package com.example.License.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.License.models.Licenses;
import com.example.License.models.Person;

@Repository
public interface LicenseRepository extends CrudRepository<Licenses, Long> {
	List<Licenses> findAll();
	
}

