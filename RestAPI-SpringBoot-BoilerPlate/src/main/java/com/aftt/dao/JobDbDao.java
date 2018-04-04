package com.aftt.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aftt.dto.JobDb;
import com.aftt.main.JobRepository;

@Component
public class JobDbDao  {

	@Autowired
	private JobRepository repository;
	
	private List<JobDb> jobRepo;
	private List<JobDb> jobOrderedList;
	
	//Get all the jobs in the repository
	public List<JobDb> getJobs(){	
		return repository.findAll();
	}
        
	public List<JobDb> getOrderedJobs(){        
        jobRepo = new ArrayList<>();
        jobOrderedList = new ArrayList<>();
        
        repository.findAll().forEach((job) -> {
            addJobToOrderedList(job);
        });

        return jobOrderedList;
	}
	
	private void addJobToOrderedList(JobDb job) {
        boolean jobListed = false;
        if (job != null) {
            if (jobOrderedList != null) {
                for (JobDb testJob : jobOrderedList) {
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
                        JobDb job2Add = repository.findByRef(dep.get("ref"));
                        addJobToOrderedList(job2Add);
                    }
                    jobOrderedList.add(job);
                }
            }
        }
	}
	
	//Post the new list of jobs to the repo
	public void addJobs(List<JobDb> jobList) {
		repository.insert(jobList);
	}
	
	//Delete all the data from the jobs repo
	public void deleteAllJobs() {
		repository.deleteAll();
	}
}