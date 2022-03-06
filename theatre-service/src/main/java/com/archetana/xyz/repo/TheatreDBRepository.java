package com.archetana.xyz.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.archetana.xyz.model.Theatre;

@Repository
public interface TheatreDBRepository extends CrudRepository<Theatre, Integer> {
	List<Theatre> findAll();
}
