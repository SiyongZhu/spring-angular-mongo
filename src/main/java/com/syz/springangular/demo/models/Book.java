package com.syz.springangular.demo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.TextScore;

import com.syz.springangular.demo.utils.SharedParameters;

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
		this.reviews = new ArrayList<Review>();
		
//		tags.forEach(t -> {
//			BookTag bookTag = SharedParameters.booktags.stream().filter(bt -> bt.getTagName().equals(t)).findFirst().orElse(new BookTag(t));
//			boolean tagPresent = SharedParameters.booktags.stream().filter(bt -> bt.getTagName().equals(t)).findFirst().isPresent();
			
//			if(!tagPresent) {
//				System.out.println("Found new tag " + t);
//				BookTag newTag = new BookTag(t);
//				SharedParameters.booktags.add(newTag);
//			}else {
//				SharedParameters.booktags.get(0);
//			}
//		});
	}
	
	public String getId() {
		return this.id;
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
	
	public void addTag(String tag) {
	    tags.add(tag);
	}

	public boolean getLikes() {
		return likes;
	}

	public List<Review> getReviews() {
		return reviews;
	}
	
	public void addReview(Review review) {
	    this.reviews.add(review);
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
