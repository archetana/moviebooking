package com.archetana.xyz.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.archetana.xyz.model.Movie;

@Repository
public interface MovieDBRepository extends CrudRepository<Movie, Integer> {
	List<Movie> findAll();
}
