package com.aftt.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aftt.dto.Job;
import com.aftt.main.JobRepository;

@Component
public class JobDao  {

	@Autowired
	private JobRepository repository;
	
	private List<Job> jobRepo;
	private List<Job> jobOrderedList;
	
	//Get all the jobs in the repository
	public List<Job> getJobs(){	
		return repository.findAll();
	}
        
	public List<Job> getOrderedJobs(){        
        jobRepo = new ArrayList<>();
        jobOrderedList = new ArrayList<>();
        
        repository.findAll().forEach((job) -> {
            addJobToOrderedList(job);
        });

        return jobOrderedList;
	}
	
	private void addJobToOrderedList(Job job) {
        boolean jobListed = false;
        if (job != null) {
            if (jobOrderedList != null) {
                for (Job testJob : jobOrderedList) {
                    if (job.id.equals(testJob.id)) {
                        jobListed = true;
                    }
                }
            }
            if (!jobListed) {
                if (job.getDependencies().isEmpty()) {
                    jobOrderedList.add(job);
                }
                else {
                    for (int i=0; i < job.getDependencies().size(); i++) {
                        JSONArray depArry = job.getDependencies();
                        HashMap<String, String> dep = (HashMap<String, String>) depArry.get(i);
                        Job job2Add = repository.findByRef(dep.get("ref"));
                        addJobToOrderedList(job2Add);
                    }
                    jobOrderedList.add(job);
                }
            }
        }
	}
	
	//Post the new list of jobs to the repo
	public void addJobs(List<Job> jobList) {
		repository.insert(jobList);
	}
	
	//Delete all the data from the jobs repo
	public void deleteAllJobs() {
		repository.deleteAll();
	}
}