package com.syz.springangular.demo.models;

public class Review {
	private String reviewer;
	private String message;
	private String reviewUrl;
	
	
	public Review(String reviewer) {
		super();
		this.reviewer = reviewer;
	}

	public String getReviewer() {
		return reviewer;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
	    this.message = message;
	}

    public String getReviewURL() {
        return reviewUrl;
    }

    public void setReviewUrl(String reviewURL) {
        this.reviewUrl = reviewURL;
    }

	
	
	

}
