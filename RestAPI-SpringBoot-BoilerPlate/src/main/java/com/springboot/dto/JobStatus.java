package com.springboot.dto;

import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONArray;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Document(collection = "jobstatus")
@JsonInclude(Include.NON_NULL)
public class JobStatus {

    @Id
    public String id;

    public String jobName;
    public String jobNumber;
    public Long runDatetime;
    public String schedule;
    public String status;
    
	public JobStatus() {
	}
	public JobStatus(String id, String jobName, String jobNumber, Long runDatetime, String schedule, String status) {
		this.id = id;
		this.jobName = jobName;
		this.jobNumber = jobNumber;
		this.runDatetime = runDatetime;
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

	public Long getRunDatetime() {
		return runDatetime;
	}
	public void setRunDatetime(Long runDatetime) {
		this.runDatetime = runDatetime;
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
		return "JobStatus [id=" + id + ", jobName=" + jobName + ", jobNumber=" + jobNumber + ", runDatetime="
				+ runDatetime + ", schedule=" + schedule + ", status=" + status + "]";
	}

}