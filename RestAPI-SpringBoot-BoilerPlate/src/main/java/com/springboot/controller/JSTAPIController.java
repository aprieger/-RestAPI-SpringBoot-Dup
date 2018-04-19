package com.springboot.controller;

import java.net.URI;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.dao.EmployeeDao;
import com.springboot.dao.JSTAPIDao;
import com.springboot.dto.Employee;
import com.springboot.dto.InputData;
import com.springboot.dto.JobStatus;

@RestController
@RequestMapping( value = "/jstapi")
public class JSTAPIController {	
	
	//Service class implements the Business logic and interact with other services/DAO based on the requirement.
	@Autowired
	JSTAPIDao jstApiDao;
	
	@PostMapping(value = "/status")
    public List<JobStatus> getJobStatus(@RequestBody List<InputData> date) throws SQLException {
		return jstApiDao.getJobStatusByDatetime(date.get(0));
   }
}
