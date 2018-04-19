package com.aftt.dto;

import java.util.List;

public class MetaPlatform {

    public String platformName;
    public List<MetaJob> jobs;
    
	public MetaPlatform() {}
	public MetaPlatform(String id, String platformName, List<MetaJob> jobs) {
		this.platformName = platformName;
		this.jobs = jobs;
	}
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public List<MetaJob> getJobs() {
		return jobs;
	}
	public void setJobs(List<MetaJob> jobs) {
		this.jobs = jobs;
	}
	@Override
	public String toString() {
		return "platformName=" + platformName + ", jobs=" + jobs;
	}
}