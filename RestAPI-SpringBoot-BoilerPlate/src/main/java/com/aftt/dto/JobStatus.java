package com.aftt.dto;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jobstatus")
public class JobStatus {

    @Id
    public String id;

    public String jobName;
    public String jobNumber;
    public String runDate;
    public String runTime;
    public String schedule;
    public String status;
    
	public JobStatus() {
	}
	public JobStatus(String id, String jobName, String jobNumber, String runDate, String runTime, String schedule,
			String status) {
		this.id = id;
		this.jobName = jobName;
		this.jobNumber = jobNumber;
		this.runDate = runDate;
		this.runTime = runTime;
		this.schedule = schedule;
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}
	public String getRunDate() {
		return runDate;
	}
	public void setRunDate(String runDate) {
		this.runDate = runDate;
	}
	public String getRunTime() {
		return runTime;
	}
	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "id=" + id + ", jobName=" + jobName + ", jobNumber=" + jobNumber + ", runDate=" + runDate
				+ ", runTime=" + runTime + ", schedule=" + schedule + ", status=" + status;
	}
}