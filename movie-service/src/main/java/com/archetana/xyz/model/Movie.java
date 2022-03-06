package com.archetana.xyz.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Movie implements Serializable {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

	private String name;
}