package com.syz.springangular.demo.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Books")
public class Book {

	@Id
	private String id;
	private String title;
	private String description;
	private String author;
	private String genre;
	private List<String> tags;
	private List<Review> reviews;
	private int likes;
	
	public Book(String title, String description, String author, 
			String genre, List<String> tags, List<Review> reviews) {
		super();
		this.title = title;
		this.description = description;
		this.author = author;
		this.genre = genre;
		this.tags = tags;
		this.reviews = reviews;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getAuthor() {
		return author;
	}

	public String getGenre() {
		return genre;
	}

	public List<String> getTags() {
		return tags;
	}

	public int getLikes() {
		return likes;
	}

	public List<Review> getReviews() {
		return reviews;
	}
	
	
	
	
	
	
	
}
