package com.syz.springangular.demo.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Books")
public class Book {

	@Id
	private String id;
	private String title;
	private List<String> authors;
	private String imageUrl;
	private Date publishDate;
	private List<String> tags;
	private List<Review> reviews;
	private boolean likes;
	
	
	public Book(String title, List<String> authors, Date publishDate, List<String> tags) {
		super();
		this.title = title;
		this.authors = authors;
		this.publishDate = publishDate;
		this.tags = tags;
	}

	public String getTitle() {
		return title;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public List<String> getTags() {
		return tags;
	}

	public boolean getLikes() {
		return likes;
	}

	public List<Review> getReviews() {
		return reviews;
	}

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
	
	
	
	
	
	
	
}
