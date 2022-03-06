package com.archetana.xyz.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.archetana.xyz.model.Show;

@Repository
public interface ShowsRepository extends CrudRepository<Show, Integer> {
	List<Show> findAll();

	List<Show> findByTheatreId(Integer theatreId);
}
