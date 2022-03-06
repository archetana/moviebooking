package com.archetana.xyz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.archetana.xyz.model.Theatre;
import com.archetana.xyz.repo.TheatreDBRepository;

@Service
public class TheatreService {

	@Autowired
	private TheatreDBRepository theaterRepository;


	public List<Theatre> getTheatres() {
		return theaterRepository.findAll();
	}

	public Theatre addUpdateTheatre(Theatre Theatre) {
		return theaterRepository.save(Theatre);
	}

	public Boolean deleteTheatre(Integer id) {
		theaterRepository.deleteById(id);
		return true;
	}

	public Theatre getTheatreById(Integer id) {
		return theaterRepository.findById(id).get();
	}


}
