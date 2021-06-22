package com.example.books.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.books.models.Books;
import com.example.books.repositories.BookRepository;

@Service
public class BookService {
	final private BookRepository BookRepo;
	
	BookService(BookRepository BookRepo){
		this.BookRepo = BookRepo;
	}
	
	
	List<Books> getAllBooks(){
		return (List<Books>) BookRepo.findAll();
	}
	Books createBook(Books b, String title, String description ,String language, Integer numberofpages) {
		b.setTitle(title);
		b.setDescription(description);
		b.setLanguage(language);
		b.setNumberofpages(numberofpages);
		
		return BookRepo.save(b);
	}
}
