package com.archetana.xyz.show;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.archetana.xyz.movie.Movie;
import com.archetana.xyz.theatre.Theatre;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Show implements Serializable {

	public Show(int theatreId2, int movieId2, String dateTime2, int numSeats2) {
		this.theatreId = theatreId2;
		this.movieId = movieId2;
		this.dateTime = LocalDate.parse(dateTime2);
		this.numSeats = numSeats2;
	}

	private int id;
	private int theatreId;
	private int movieId;
	private LocalDate dateTime;
	private int numSeats;
}