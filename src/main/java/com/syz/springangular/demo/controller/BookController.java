package com.syz.springangular.demo.controller;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.syz.springangular.demo.models.Book;
import com.syz.springangular.demo.repository.BookRepository;
import com.syz.springangular.demo.utils.SharedParameters;
import com.syz.springangular.demo.utils.SharedUtilsFunction;

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
//		Page<Book> books = this.bookRepository.findAll( SharedParameters.sortByPublishDatePage );

		return this.bookRepository.findAll();
	}
	
	@GetMapping("/tag/{tag}")
	public List<Book> getBooksByTag(@PathVariable String tag){
	     
	    logger.info("Get Books by Tag "+tag);
	    Page<Book> pageBooks = this.bookRepository.findByTags(tag.toLowerCase(), SharedParameters.sortByPublishDatePage);
	    logger.info("Found total pages "+pageBooks.getTotalPages()); 

	    return pageBooks.getContent();
	}
	
	@GetMapping("/author/{author}")
	public List<Book> getBooksByAuthor(@PathVariable String author){
	     
	    logger.info("Get Books by Author "+author);
	    List<Book> books = this.bookRepository.findAllByAuthors(author);

	    return books;
	}
	
	@GetMapping("/multi-tags")
	public List<Book> getBooksByTags(@RequestParam("tags") String[] tags){
	    logger.info("search books for "+ Arrays.toString(tags));
	    
//	    Page<Book> pageBooks = this.bookRepository.findByTagsIn(Arrays.asList(tags), SharedParameters.sortByPublishDatePage);
//	    Page<Book> pageBooks = this.bookRepository.findByTags(Arrays.asList(tags), SharedParameters.sortByPublishDatePage);
//	    return pageBooks.getContent();
	    List<Book> books = this.bookRepository.findAnyOfTags(tags);
	    return books;
	    
	}
	
	@GetMapping("/search/{text}")
	public List<Book> getBooksByTextSearch(@PathVariable String text){
	    logger.info("Search Books that fits "+text);
	    TextCriteria criteria = TextCriteria.forDefaultLanguage().matching(text);
	    List<Book> books = bookRepository.findAllBy(criteria, Sort.by(Order.desc("textScore")));
	    
	    return books;
	}
	
	@GetMapping("/date/{year}/{month}")
	public List<Book> getBookByYearMonth(@PathVariable String year, @PathVariable String month) {
	    Date publish;
        try {
            publish = SharedUtilsFunction.constructDateByYearMonth(year, month);
            List<Book> books = this.bookRepository.findAllByPublishDate(publish);
            logger.info(String.format("Found %d books published in %s", books.size(), publish));
            return books;
        } catch (ParseException e) {
            logger.error(String.format("Failed to parse %s and %s", year, month));
            return null;
        }
	    
	}
	
	
}
