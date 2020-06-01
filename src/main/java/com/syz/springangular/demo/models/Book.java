package com.syz.springangular.demo.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Books")
public class Book {

	@Id
	private String id;
	private String title;
	private List<String> authors;
	private List<String> tags;
	private List<Review> reviews;
	private String publication;
	private int likes;
	
	
	public Book(String title, String publication, List<String> authors, List<String> tags, List<Review> reviews) {
		super();
		this.title = title;
		this.publication = publication;
		this.authors = authors;
		this.tags = tags;
		this.reviews = reviews;
	}

	public String getTitle() {
		return title;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public String getPublication() {
	    return publication;
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
