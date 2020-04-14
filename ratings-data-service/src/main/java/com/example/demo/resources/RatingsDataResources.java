package com.example.demo.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Rating;

@RestController
@RequestMapping("/ratings")
public class RatingsDataResources {

	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}
}
