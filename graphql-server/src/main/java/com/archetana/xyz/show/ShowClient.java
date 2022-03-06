package com.archetana.xyz.show;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ShowClient {

	private final RestTemplate restTemplate;

	@Value("${showurl}")
	private String showurl;

	public ShowClient(RestTemplateBuilder builder) {
		restTemplate = builder.build();
	}

	public List<Show> getAllShows() {
		return restTemplate.exchange(String.format("%s/list", showurl), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Show>>() {
				}).getBody();
	}

	public List<Show> getShowsByTheatreId(int theatreId) {
		return restTemplate.exchange(String.format("%s/listbyTheatre/%d", showurl, theatreId), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Show>>() {
				}).getBody();
	}

	public Show addUpdateShow(int theatreId, int movieId, String dateTime, int numSeats) {
		return restTemplate.exchange(String.format("%s/add", showurl), HttpMethod.POST,
				new HttpEntity<Show>(new Show(theatreId, movieId, dateTime, numSeats)),
				new ParameterizedTypeReference<Show>() {
				}).getBody();
	}
}