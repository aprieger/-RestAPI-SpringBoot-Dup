package com.springboot.controller;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.dao.JobStatusDao;
import com.springboot.dto.JobStatus;

@RestController
@RequestMapping( value = "/jobstatus")
public class JobStatusController {	
	
	@Autowired
	private JobStatusDao jobStatusDao;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<JobStatus> getJobStatus(){
		return jobStatusDao.getJobStatus();
	}
    
	@PostMapping(value = "/add")
    public List<JobStatus> addJobs(@RequestBody List<JobStatus> jobStatusList) throws SQLException {
		jobStatusDao.addJobStatus(jobStatusList);
		return this.getJobStatus();
    }
	
	@PostMapping(value = "/delete/all")
    public List<JobStatus> deleteAllJobs() throws SQLException {
		jobStatusDao.deleteAllJobStatus();
		return this.getJobStatus();
    }	
}
