package com.syz.springangular.demo.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

@Document(collection = "Books")
public class Book {

	@Id
	private String id;
	
	@TextIndexed
	private String title;
	@TextIndexed
	private List<String> authors;
	private String imageUrl;
	@Indexed(direction = IndexDirection.DESCENDING)
	private Date publishDate;
	@Indexed(direction = IndexDirection.ASCENDING)
	private Date createdDate;
	private List<String> tags;
	private List<Review> reviews;
	private boolean likes;
	
	@TextScore
	private Float textScore;
	
	public Book (){
        
    }
	
	public Book(String title, List<String> authors, Date publishDate, List<String> tags) {
		super();
		this.title = title;
		this.authors = authors;
		this.publishDate = publishDate;
		this.tags = tags;
		this.createdDate = new Date();
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

    public Float getTextScore() {
        return textScore;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
    
    

	
	
	
	
	
	
	
}
