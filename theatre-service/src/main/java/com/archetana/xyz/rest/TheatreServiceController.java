package com.archetana.xyz.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.archetana.xyz.model.Theatre;
import com.archetana.xyz.service.TheatreService;

@RestController
class TheatreServiceController {

	@Autowired
	private TheatreService theatreService;

	@RequestMapping("/theatres/list")
	public List<Theatre> getTheatres() {
		return theatreService.getTheatres();
	}

	@RequestMapping(method = RequestMethod.POST, path = "/theatres/add")
	public Theatre addUpdateTheatre(@RequestBody Theatre theater) {
		return theatreService.addUpdateTheatre(theater);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/theatres/get/{id}")
	public Theatre getTheatreById(@PathVariable Integer id) {
		return theatreService.getTheatreById(id);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/theatres/delete/{id}")
	public Boolean deleteTheatre(@PathVariable Integer id) {
		return theatreService.deleteTheatre(id);
	}

}