package com.springboot.main;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.dto.JobStatus;

public interface JobStatusRepository extends MongoRepository<JobStatus, String> {

	public List<JobStatus> findAll();
	public JobStatus findById(String id);
	public JobStatus findByJobName(String jobName);
	public List<JobStatus> findBySchedule(String schedule);
}