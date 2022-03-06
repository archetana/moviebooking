package com.archetana.xyz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.archetana.xyz.model.Movie;
import com.archetana.xyz.repo.MovieDBRepository;

import liquibase.pro.packaged.O;

@Service
public class MovieService {

	@Autowired
	private MovieDBRepository movieRepository;


	public List<Movie> getMovies() {
		return movieRepository.findAll();
	}

	public Movie addUpdateMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	public Boolean deleteMovie(Integer id) {
		movieRepository.deleteById(id);
		return true;
	}

	public Movie getMovieById(Integer id) {
		return movieRepository.findById(id).get();
	}

//	public Movie postMovie(Movie movie) {
//		String message = "Message " + UUID.randomUUID();
//		redisMessagePublisher.publish(message);
//		return movie;
//	}

}
