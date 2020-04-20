package com.example.demo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.models.CatalogItem;
import com.example.demo.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class movieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	
	@Autowired
	MovieInfo movieInfo;
	
	@Autowired
	UserRatingInfo userRatingInfo;
	
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		//Get All rated movie IDs
		UserRating userRating = userRatingInfo.getUserRating(userId);
		
		//For each movieId call movie info service to get details
		return userRating.getUserRatings()
						.stream()
						.map(rating -> movieInfo.getCatalogItem(rating))
						.collect(Collectors.toList());
	}
}

/**
Movie movie = webClientBuilder.build()
				.get()
				.uri("http://localhost:8082/movies/"+rating.getMovieId())
				.retrieve()
				.bodyToMono(Movie.class)
				.block();
*/
