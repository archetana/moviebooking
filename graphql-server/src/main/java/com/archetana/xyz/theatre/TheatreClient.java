package com.archetana.xyz.theatre;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TheatreClient {

	private final RestTemplate restTemplate;
	
	@Value(value = "${theatreurl}")
	private String theatreurl;

	public TheatreClient(RestTemplateBuilder builder) {
		restTemplate = builder.build();
	}

	public List<Theatre> getAllTheatres() {
		return restTemplate.exchange(String.format("%s/list",theatreurl), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Theatre>>() {
				}).getBody();
	}

	public Theatre getTheatreById(int id) {
		return restTemplate.exchange(String.format("%s/get/%d",theatreurl, id), HttpMethod.GET, null,
				new ParameterizedTypeReference<Theatre>() {
				}).getBody();
	}
}