package com.springboot.dao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import com.springboot.dto.JobLocal;

@Component
public class JobDaoLocal  {
	
	List<JobLocal> jobList = new ArrayList<JobLocal>();
	List<JobLocal> jobRepo = new ArrayList<JobLocal>();
	
	public List<JobLocal> getJobs(){
		final long startTime = System.currentTimeMillis();

		jobList = new ArrayList<JobLocal>();
		
		JSONParser parser = new JSONParser();
		JSONArray jobArray = new JSONArray();
		String filePath = "";
		try {
			filePath = new File( "src/main/java/com/pel2/dao/JobList.json" ).getCanonicalPath();
		} catch (IOException e1) {e1.printStackTrace();}
		
		try {
			jobArray = (JSONArray) parser.parse(new FileReader(filePath));
		} catch (Exception e) {System.out.println(e.getMessage());}
		
		if (jobArray != null) {
			for (Object obj : jobArray) {
				JSONObject jObj = (JSONObject) obj;
				JobLocal job = new JobLocal();
				job.id = null;
				job.category = (String) jObj.get("category");
				job.type = (String) jObj.get("type");
				job.ref = (String) jObj.get("ref");
				job.state = Integer.parseInt(jObj.get("state").toString());
				job.scheduled = Integer.parseInt(jObj.get("scheduled").toString());
				
				JSONArray depJSONArray = (JSONArray) jObj.get("dependencies");
				ArrayList<String> depAL = new ArrayList<String>();
				for (Object depObj : depJSONArray)
			    {
					JSONObject jDepObj = (JSONObject) depObj;
			      	depAL.add((String) jDepObj.get("ref"));
			    }
				job.dependencies = depAL.toArray(new String[depAL.size()]);

				jobRepo.add(job);
			}
		}
		for (JobLocal job : jobRepo) {
			addJob(job);
		}
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) );
		
		return jobRepo;
	}
	
	private void addJob(JobLocal job) {
		boolean exists = false;
		for (JobLocal listJob : jobList) {
			if (listJob.equals(job))
				exists = true;
		}
		if (!exists) {
			if (job.getDependencies().length==0) {
				jobList.add(job);
			}
			else {
				for (int i=0; i < job.getDependencies().length; i++) {
					for (JobLocal repoJob : jobRepo) {
						if (repoJob.ref.equals(job.getDependencies()[i]))
							addJob(repoJob);
					}
				}
				jobList.add(job);
			}
		}
	}
}