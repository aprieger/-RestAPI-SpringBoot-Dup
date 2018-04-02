package com.aftt.dto;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jobs")
public class JobStatus {

    @Id
    public String id;

    public String jobName;
    public String jobNumber;
    public String runDate;
    public String runTime;
    public String status;
    
    
}