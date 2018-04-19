package com.springboot.dto;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jobs")
public class Job {

    public String jobName;
    public String jobNumber;
    public String runDate;
    public String runTime;
    public String schedule;
    public String status;
    public String sorName;
    public String platformName;
    public List<Job> predecessors;
    public List<MetaOutputFile> outputFiles;
    
	public Job() {
	}
	public Job(String jobName, String jobNumber, String runDate, String runTime, String schedule, String status,
			String sorName, String platformName, List<Job> predecessors, List<MetaOutputFile> outputFiles) {
		this.jobName = jobName;
		this.jobNumber = jobNumber;
		this.runDate = runDate;
		this.runTime = runTime;
		this.schedule = schedule;
		this.status = status;
		this.sorName = sorName;
		this.platformName = platformName;
		this.predecessors = predecessors;
		this.outputFiles = outputFiles;
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
	public String getSorName() {
		return sorName;
	}
	public void setSorName(String sorName) {
		this.sorName = sorName;
	}
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public List<Job> getPredecessors() {
		return predecessors;
	}
	public void setPredecessors(List<Job> predecessors) {
		this.predecessors = predecessors;
	}
	public List<MetaOutputFile> getOutputFiles() {
		return outputFiles;
	}
	public void setOutputFiles(List<MetaOutputFile> outputFiles) {
		this.outputFiles = outputFiles;
	}
	@Override
	public String toString() {
		return "Job [jobName=" + jobName + ", jobNumber=" + jobNumber + ", runDate=" + runDate + ", runTime=" + runTime
				+ ", schedule=" + schedule + ", status=" + status + ", sorName=" + sorName + ", platformName="
				+ platformName + ", predecessors=" + predecessors + ", outputFiles=" + outputFiles + "]";
	}
}