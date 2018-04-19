package com.springboot.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jobs")
public class InputData {

    public String date;
    
	public InputData() {
	}
	public InputData(String date) {
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "InputData [date=" + date + "]";
	}
}