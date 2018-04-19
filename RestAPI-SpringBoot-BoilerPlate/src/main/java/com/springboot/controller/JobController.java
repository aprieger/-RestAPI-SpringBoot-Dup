package com.aftt.controller;

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

import com.aftt.dao.JobDbDao;
import com.aftt.dto.JobDb;

@RestController
@RequestMapping( value = "/jobs")
public class JobController {	
	
	@Autowired
	private JobDbDao jobDbDao;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<JobDb> getJobs(){
		return jobDbDao.getJobs();
	}
        
    @RequestMapping(value = "/all/ordered", method = RequestMethod.GET)
	public List<JobDb> getJobsOrdered(){
		return jobDbDao.getOrderedJobs();
	}
    
	@PostMapping(value = "/add")
    public List<JobDb> addJobs(@RequestBody List<JobDb> jobList) throws SQLException {
		jobDbDao.addJobs(jobList);
		return this.getJobs();
    }
	
	@PostMapping(value = "/delete/all")
    public List<JobDb> deleteAllJobs() throws SQLException {
		jobDbDao.deleteAllJobs();
		return this.getJobs();
    }	
}
