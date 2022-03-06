package com.archetana.xyz.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Show {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

	private int theatreId;
	private int movieId;
	private Date dateTime;
	private int numSeats;
}