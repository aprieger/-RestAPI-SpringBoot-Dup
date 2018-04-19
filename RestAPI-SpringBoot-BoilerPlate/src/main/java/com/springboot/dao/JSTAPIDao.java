package com.springboot.dao;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.springboot.dto.InputData;
import com.springboot.dto.JobStatus;
import com.springboot.main.JobStatusRepository;

import static com.mongodb.client.model.Filters.*;

@Component
public class JSTAPIDao  {
	final long ONE_MIN = 60000;
	final long LONG_MAX = 2147483647;
	
	@Autowired
	JobStatusRepository jobStatusRepo;
	@Autowired
	private Environment env;
	
	public List<JobStatus> getJobStatusByDatetime(InputData inputDate) {
		try{
			List<JobStatus> jobStatusList = new ArrayList<JobStatus>();
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy HH.mm.ss");
			Date formattedDate = formatter.parse(inputDate.date);
			System.out.println(formattedDate);
			long dateInLong = formattedDate.getTime();
			System.out.println(dateInLong);
			long runDateStart = dateInLong - (15*60000);
			long runDateEnd = dateInLong + (15*60000);
			
			MongoClient client = new MongoClient();
			MongoDatabase database = client.getDatabase(env.getProperty("spring.data.mongodb.database"));
			MongoCollection<Document> collection = database.getCollection("jobstatus");
			
			List<Document> documents = (List<Document>) collection.find(and(gte("runDatetime", runDateStart), 
					lte("runDatetime", runDateEnd))).into(new ArrayList<Document>());
			for (Document docJobStatus : documents) {
				double runDateTimeDouble = docJobStatus.getDouble("runDatetime");
				jobStatusList.add(new JobStatus("", docJobStatus.getString("jobName"), docJobStatus.getString("jobNumber"),
						(long) runDateTimeDouble, docJobStatus.getString("schedule"), 
						docJobStatus.getString("status")));
			}
			
			client.close();
			
			String scheudleStr = (getSchedule(jobStatusList, formattedDate));
			return jobStatusRepo.findBySchedule(scheudleStr);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<JobStatus>();
		}
	}
	
	private String getSchedule(List<JobStatus> jobStatusList, Date runDatetime) {
		String tempSchedule="";
		long datetimeDifference = LONG_MAX;
		for (JobStatus jobStatus : jobStatusList) {
			long repoDateNum = jobStatus.runDatetime;
			long testDateNum = runDatetime.getTime();
			if (Math.abs(repoDateNum-testDateNum) < datetimeDifference) {
				tempSchedule = jobStatus.schedule;
				datetimeDifference = Math.abs(repoDateNum-testDateNum);
			}
		}
		return tempSchedule;
	}
}