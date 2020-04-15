package com.example.demo.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.CatalogItem;
import com.example.demo.models.Movie;
import com.example.demo.models.Rating;

@RestController
@RequestMapping("/catalog")
public class movieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		//Get All rated movie IDs
		List<Rating> ratings = Arrays.asList(
			new Rating("1234", 4),
			new Rating("1235", 3)
		);
		
		return ratings.stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName() , "Desc", rating.getRating());
		})
		.collect(Collectors.toList());
		
		
		//For each movieId call movie info service to get details
		
		//Put them all together
		
		
	}
}
