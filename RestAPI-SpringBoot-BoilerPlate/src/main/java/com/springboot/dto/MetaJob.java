package com.springboot.dto;

import java.util.List;

public class MetaJob {
	
	public String jobName;
	public List<MetaOutputFile> outputFiles;
	public List<MetaJob> predecessors;
	
	public MetaJob() {}
	public MetaJob(String jobName, List<MetaOutputFile> outputFiles, List<MetaJob> predecessors) {
		this.jobName = jobName;
		this.outputFiles = outputFiles;
		this.predecessors = predecessors;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public List<MetaOutputFile> getOutputFiles() {
		return outputFiles;
	}
	public void setOutputFiles(List<MetaOutputFile> outputFiles) {
		this.outputFiles = outputFiles;
	}
	public List<MetaJob> getPredecessors() {
		return predecessors;
	}
	public void setPredecessors(List<MetaJob> predecessors) {
		this.predecessors = predecessors;
	}
	@Override
	public String toString() {
		return "jobName=" + jobName + ", outputFiles=" + outputFiles + ", predecessors=" + predecessors;
	}
}