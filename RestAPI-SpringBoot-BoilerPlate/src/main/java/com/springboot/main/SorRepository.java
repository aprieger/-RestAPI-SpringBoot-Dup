package com.aftt.main;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.aftt.dto.Sor;

public interface SorRepository extends MongoRepository<Sor, String> {

	public List<Sor> findAll();
}