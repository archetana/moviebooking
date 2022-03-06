package com.archetana.xyz.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.archetana.xyz.model.Movie;
import com.archetana.xyz.service.MovieService;

@RestController
class MovieController {

	@Autowired
	private MovieService movieService;

	@RequestMapping("/movies/list")
	public List<Movie> getMovies() {
		return movieService.getMovies();
	}

	@RequestMapping(method = RequestMethod.POST, path = "/movies/add")
	public Movie addUpdateMovie(@RequestBody Movie movie) {
		return movieService.addUpdateMovie(movie);
	}
	
//	@RequestMapping(method = RequestMethod.POST, path = "/movies/post")
//	public Movie postMovie(@RequestBody Movie movie) {
//		return movieService.postMovie(movie);
//	}

	@RequestMapping(method = RequestMethod.GET, path = "/movies/get/{id}")
	public Movie getMovieById(@PathVariable Integer id) {
		return movieService.getMovieById(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/movies/delete/{id}")
	public Boolean deleteMovie(@PathVariable Integer id) {
		return movieService.deleteMovie(id);
	}

}