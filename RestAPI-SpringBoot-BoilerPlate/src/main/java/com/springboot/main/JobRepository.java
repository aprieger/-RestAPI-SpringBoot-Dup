package com.springboot.main;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.dto.JobDb;

public interface JobRepository extends MongoRepository<JobDb, String> {

	public List<JobDb> findAll();
	public JobDb findByRef(String ref);
	public JobDb findById(String id);
}