package com.archetana.xyz.theatre;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Theatre implements Serializable {

	private int id;

	private String name;

	private String pincode;
}