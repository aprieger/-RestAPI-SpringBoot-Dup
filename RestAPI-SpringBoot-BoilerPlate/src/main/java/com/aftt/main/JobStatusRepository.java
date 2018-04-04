package com.aftt.main;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.aftt.dto.JobStatus;

public interface JobStatusRepository extends MongoRepository<JobStatus, String> {

	public List<JobStatus> findAll();
	public JobStatus findById(String id);
	public JobStatus findByJobName(String jobName);
}