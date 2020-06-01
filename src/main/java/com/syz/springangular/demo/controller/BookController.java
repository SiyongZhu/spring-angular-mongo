package com.syz.springangular.demo.controller;

import java.util.List;

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

@RestController
@RequestMapping("/books")
public class BookController {

	private BookRepository bookRepository;
	
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
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
		List<Book> books = this.bookRepository.findAll();
		return books;
	}
	
	
}
