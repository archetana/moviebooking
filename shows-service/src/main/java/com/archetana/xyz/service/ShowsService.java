package com.archetana.xyz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.archetana.xyz.model.Show;
import com.archetana.xyz.repo.ShowsRepository;

@Service
public class ShowsService {

	@Autowired
	private ShowsRepository showsRepository;

	public List<Show> getShows() {
		return showsRepository.findAll();
	}

	public Show addUpdateShows(Show shows) {
		return showsRepository.save(shows);
	}

	public Boolean deleteShows(Integer id) {
		showsRepository.deleteById(id);
		return true;
	}

	public Show getShowsById(Integer id) {
		return showsRepository.findById(id).get();
	}

	public List<Show> getShowsByTheatre(Integer theatreId) {
		return showsRepository.findByTheatreId(theatreId);
	}

}
