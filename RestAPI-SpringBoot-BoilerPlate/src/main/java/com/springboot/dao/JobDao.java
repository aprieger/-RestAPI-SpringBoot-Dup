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
import com.aftt.dto.Sor;
import com.aftt.dto.JobStatus;
import com.aftt.dao.JobStatusDao;
import com.aftt.dao.SorDao;

@Component
public class JobDao  {
	
	private List<Job> jobRepo;
	private List<Job> jobOrderedList;
	private JobStatusDao jobStatusDao = new JobStatusDao();
	private SorDao sorDao = new SorDao();
	
	private List<Sor> sorRepo;
	private List<JobStatus> jobStatusRepo;
	
	//Get all the jobs in the repository
	public List<Job> getJobs(){	
		sorRepo = new ArrayList<>();
		jobStatusRepo = new ArrayList<>();
		
		return null;
	}
        
	public List<Job> getOrderedJobs(){        
        jobRepo = new ArrayList<>();
        jobOrderedList = new ArrayList<>();

        return jobOrderedList;
	}
	
	private void addJobToOrderedList(Job job) {
		boolean jobListed = false;
		if (job != null) {
            if (jobOrderedList != null) {
                for (Job testJob : jobOrderedList) {
                    if (job.jobName.equals(testJob.jobName)) {
                        jobListed = true;
                    }
                }
            }
            if (!jobListed) {
            		if (job.getPredecessors().isEmpty()) {
            			jobOrderedList.add(job);
            		}
            		else {
            			for (int i=0; i < job.getPredecessors().size(); i++) {
            				List<Job> predecessors= job.getPredecessors();
            				Job job2Add = null;
            				for (int j=0; j < jobRepo.size(); j++)
            					if (jobRepo.get(i).jobName.equals(predecessors.get(i).jobName))
            						job2Add = jobRepo.get(i);
            				if (job2Add != null)
            					addJobToOrderedList(job2Add);
                    }
                    jobOrderedList.add(job);
                }
            }
        }
	}
}