package com.MVC.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.MVC.models.Book;
import com.MVC.services.BookServices;



@Controller
public class BooksController {
	private final BookServices bookService;

	public BooksController(BookServices bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";
	}
	@RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/new.jsp";
    }
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
	@RequestMapping("/books/{id}")
    public String show(Model model ,@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		model.addAttribute("book",book);
        return "/books/show.jsp";
    }
//	@RequestMapping(value="/books/{id}/edit")
//    public String update(Model model ,@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
//        Book book1 = bookService.updateBook(id, title, desc, lang, numOfPages);
//        model.addAttribute("book",book1);
//        return "/books/edit.jsp";
//	}
}
