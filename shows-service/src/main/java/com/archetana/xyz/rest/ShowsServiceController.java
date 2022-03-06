package com.archetana.xyz.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.archetana.xyz.model.Show;
import com.archetana.xyz.service.ShowsService;

@RestController
class ShowsServiceController {

	@Autowired
	private ShowsService showsService;

	@RequestMapping("/shows/list")
	public List<Show> getShowss() {
		return showsService.getShows();
	}

	@RequestMapping(method = RequestMethod.POST, path = "/shows/add")
	public Show addUpdateShows(@RequestBody Show show) {
		return showsService.addUpdateShows(show);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/shows/delete/{id}")
	public Boolean deleteShows(@PathVariable Integer id) {
		return showsService.deleteShows(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/shows/get/{id}")
	public Show getShowsById(@PathVariable Integer id) {
		return showsService.getShowsById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/shows/listbyTheatre/{theatreId}")
	public List<Show> getShowsByTheatre(@PathVariable Integer theatreId) {
		return showsService.getShowsByTheatre(theatreId);
	}
}