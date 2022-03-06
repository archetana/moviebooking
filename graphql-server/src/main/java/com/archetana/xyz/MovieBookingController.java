package com.archetana.xyz;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.archetana.xyz.movie.Movie;
import com.archetana.xyz.movie.MovieClient;
import com.archetana.xyz.show.Show;
import com.archetana.xyz.show.ShowClient;
import com.archetana.xyz.theatre.Theatre;
import com.archetana.xyz.theatre.TheatreClient;

@Controller
public class MovieBookingController {

	private final MovieClient movieClient;
	private final TheatreClient theatreClient;
	private final ShowClient showClient;

	public MovieBookingController(MovieClient movieClient, TheatreClient theatreClient, ShowClient showClient) {
		this.movieClient = movieClient;
		this.theatreClient = theatreClient;
		this.showClient = showClient;
	}

	/**
	 * Query -> "movies"
	 */
	@QueryMapping
	public List<Movie> movies() {
		return movieClient.getAllMovies();
	}

	/**
	 * Query -> "theatres"
	 */
	@QueryMapping
	public List<Theatre> theatres() {
		return theatreClient.getAllTheatres();
	}

	/**
	 * Query -> "shows"
	 */
	@QueryMapping(name = "shows")
	public List<Show> show() {
		return showClient.getAllShows();
	}

	@QueryMapping
	public List<Show> showsByTheatre(@Argument int theatreId) {
		return showClient.getShowsByTheatreId(theatreId);
	}

	@SchemaMapping(typeName = "Show", field = "theatre")
	public Theatre getTheatre(Show show) {
		return theatreClient.getTheatreById(show.getTheatreId());
	}

	@SchemaMapping(typeName = "Show", field = "movie")
	public Movie getMovie(Show show) {
		return movieClient.getMovieById(show.getMovieId());
	}

	@MutationMapping
	public Show addUpdateShow(@Argument int theatreId, @Argument int movieId, @Argument String dateTime,
			@Argument int numSeats) {
		return showClient.addUpdateShow(theatreId, movieId, dateTime, numSeats);
	}
}
