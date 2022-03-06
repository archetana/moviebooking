package com.archetana.xyz.show;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.archetana.xyz.movie.Movie;
import com.archetana.xyz.theatre.Theatre;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateShow implements Serializable {

	private int theatreId;
	private int movieId;
	private LocalDate dateTime;
	private int numSeats;
}