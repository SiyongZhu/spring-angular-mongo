package com.syz.springangular.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.syz.springangular.demo.models.Book;
import com.syz.springangular.demo.repository.BookRepository;

//interface CommandLineRunner class means function in run(String... args)
//will run when spring boot application starts
@Component
public class DbSeeder implements CommandLineRunner {
	
	
	private BookRepository bookRepository;
	
	@Autowired
	public DbSeeder(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("\n\nPrepare Mongo DB\n\n");
		
		Book particle = new Book("Elementary Particle", 
				"One man invented clone tech to stay imortal", 
				Arrays.asList("Michel Heclluqbec"),
				"fiction",
				Arrays.asList("sci-fi", "satire"),
				new ArrayList<>());
		
		//clean up the database
		this.bookRepository.deleteAll();
		
		List<Book> initBooks = Arrays.asList(particle);
		
		bookRepository.saveAll(initBooks);
		
				
	}

}
