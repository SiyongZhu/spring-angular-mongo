package com.syz.springangular.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/all")
	public List<Book> getAll(){
		List<Book> hotels = this.bookRepository.findAll();
		return hotels;
	}
	
}
