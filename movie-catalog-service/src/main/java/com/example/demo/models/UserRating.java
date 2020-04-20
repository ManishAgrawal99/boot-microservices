package com.example.demo.models;

import java.util.List;

public class UserRating {
	
	private List<Rating> userRatings;
	private String userId;

	public UserRating() {
		super();
	}

	public UserRating(List<Rating> userRatings) {
		super();
		this.userRatings = userRatings;
	}

	public List<Rating> getUserRatings() {
		return userRatings;
	}

	public void setUserRatings(List<Rating> userRatings) {
		this.userRatings = userRatings;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
}
