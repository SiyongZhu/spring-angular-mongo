package com.syz.springangular.demo.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syz.springangular.demo.models.Book;
import com.syz.springangular.demo.repository.BookRepository;

@CrossOrigin(origins = "http://localhost:4200") //or use * to denote all requests origin are ok
@RestController
@RequestMapping("/books")
public class BookController {

	private BookRepository bookRepository;
	
	Logger logger = LoggerFactory.getLogger(BookController.class);
	
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@GetMapping("/{id}")
	public Book getById(@PathVariable String id) {
	    Optional<Book> book = this.bookRepository.findById(id);
	    return book.orElse(new Book());
	}
	@PostMapping
	//insert(): if id value not in collection, will insert, otherwise, throw duplicate key exception
	public void insert(@RequestBody Book book) {
	    this.bookRepository.insert(book);
	}
	
	@PutMapping
	//save(): if id value not in collection, will insert, otherwise, will update
	public void update(@RequestBody Book book) {
	    this.bookRepository.save(book);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
	    this.bookRepository.deleteById(id);
	}
	
	@GetMapping("/all")
	public List<Book> getAll(){
	    logger.info("Listing All Books");
		List<Book> books = this.bookRepository.findAll();
		books.sort(new Comparator<Book>() {
		    @Override
		    public int compare(Book o1, Book o2) {
		        return 0 - o1.getPublishDate().compareTo(o2.getPublishDate());
		    }
        });
		return books;
	}
	
	
}
