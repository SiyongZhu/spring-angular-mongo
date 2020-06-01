package com.syz.springangular.demo;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("yyyy-MM");
		String sYearMonth = "2006-10";
	
		Book particle = new Book("Elementary Particle", 
		        sYearMonth,
				Arrays.asList("Michel Houellebecq"),
				Arrays.asList("sci-fi", "satire"),
				new ArrayList<>());
		
		//clean up the database
		this.bookRepository.deleteAll();
		
		List<Book> initBooks = Arrays.asList(particle);
		
		bookRepository.saveAll(initBooks);
		
				
	}

}
