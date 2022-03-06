package com.archetana.xyz.movie;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.archetana.xyz.theatre.Theatre;

import java.util.List;

@Component
public class MovieClient {

	private final RestTemplate restTemplate;
	
	@Value("${movieurl}")
	String movieurl;

	public MovieClient(RestTemplateBuilder builder) {
		restTemplate = builder.build();
	}

	public List<Movie> getAllMovies() {
		return restTemplate.exchange(String.format("%s/list",movieurl), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Movie>>() {
				}).getBody();
	}

	public Movie getMovieById(int id) {
		return restTemplate.exchange(String.format("%s/get/%d",movieurl, id), HttpMethod.GET, null,
				new ParameterizedTypeReference<Movie>() {
				}).getBody();
	}
}