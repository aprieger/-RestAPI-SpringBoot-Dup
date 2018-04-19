package com.aftt.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aftt.dto.JobStatus;
import com.aftt.main.JobStatusRepository;

@Component
public class JobStatusDao  {

	@Autowired
	private JobStatusRepository repository;
	
	//Get all the jobs in the repository
	public List<JobStatus> getJobStatus(){	
		return repository.findAll();
	}
	
	//Post the new list of jobs to the repo
	public void addJobStatus(List<JobStatus> jobStatusList) {
		repository.insert(jobStatusList);
	}
	
	//Delete all the data from the jobs repo
	public void deleteAllJobStatus() {
		repository.deleteAll();
	}
}