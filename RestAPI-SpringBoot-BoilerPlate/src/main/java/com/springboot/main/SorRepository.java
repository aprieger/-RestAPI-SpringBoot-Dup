package com.springboot.main;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.dto.Sor;

public interface SorRepository extends MongoRepository<Sor, String> {

	public List<Sor> findAll();
}