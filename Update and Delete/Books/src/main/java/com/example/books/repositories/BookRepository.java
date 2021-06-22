package com.example.books.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.books.models.Books;

@Repository
public interface BookRepository extends CrudRepository<Books, Long>{
	

}
