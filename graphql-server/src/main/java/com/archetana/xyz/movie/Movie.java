package com.archetana.xyz.movie;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie implements Serializable {

	private int id;

	private String name;
}