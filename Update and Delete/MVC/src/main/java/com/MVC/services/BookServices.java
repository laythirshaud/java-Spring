package com.MVC.services;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.MVC.models.Book;
import com.MVC.repositories.BookRepository;
@Service
public class BookServices {
    private final BookRepository bookRepository;
    
    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
 
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Book book1=this.findBook(id);
		book1.setDescription(desc);
		book1.setLanguage(lang);
		book1.setTitle(title);
		book1.setNumberOfPages(numOfPages);
		return bookRepository.save(book1);
	}

	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
		
	}
	
}