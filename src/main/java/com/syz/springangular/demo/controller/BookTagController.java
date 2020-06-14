package com.syz.springangular.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syz.springangular.demo.models.BookTag;
import com.syz.springangular.demo.repository.BookTagRepository;

@CrossOrigin(origins = "http://localhost:4200") //or use * to denote all requests origin are ok
@RestController
@RequestMapping("/book-tag")
public class BookTagController {

	private BookTagRepository bookTagRepository;
	
	Logger logger = LoggerFactory.getLogger(BookTagController.class);
	
	public BookTagController(BookTagRepository bookTagRepository) {
		this.bookTagRepository = bookTagRepository;
	}
	
	@GetMapping("/all")
	public List<BookTag> getAllBookTags(){
		return bookTagRepository.findAll();
	}
}
