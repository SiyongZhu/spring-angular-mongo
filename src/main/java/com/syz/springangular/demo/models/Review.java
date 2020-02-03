package com.syz.springangular.demo.models;

public class Review {
	private String reviewer;
	private String message;
	
	
	public Review(String reviewer, String message) {
		super();
		this.reviewer = reviewer;
		this.message = message;
	}

	public String getReviewer() {
		return reviewer;
	}

	public String getMessage() {
		return message;
	}
	
	
	
	

}
