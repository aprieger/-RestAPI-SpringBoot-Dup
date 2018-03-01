/**
 * 
 */
package com.pel2.controller;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pel2.dao.EmployeeDao;
import com.pel2.dto.Employee;
import com.pel2.service.TestService;

/**
 * @author mbaransln
 * Below is the test Controller to create other controller classes based on your requirements.
 *
 */
@RestController
@RequestMapping( value = "/job")
public class JobController {	
	
	//Service class implements the Business logic and interact with other services/DAO based on the requirement.
	@Autowired
	EmployeeDao empDao;	
	
//	@RequestMapping(value = "/all", method = RequestMethod.GET)
//	public List<Employee> getEmployees(){
//		return testService.getEmployees();
//	}
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Employee> getEmployees(){
		return empDao.getEmployees();
	}
	
//	@RequestMapping(value = "/details" , method = RequestMethod.POST)
//	public Employee getEmployee(@RequestBody String id){
//		Employee responseObj = testService.getEmployee(id);
//		System.out.println("TestController.getEmployee()"+responseObj.toString());
//		return responseObj;
//	}
	
//	@PostMapping(value = "/emp")
//    public ResponseEntity<Void> addEmployee(@RequestBody Employee emp) throws SQLException {
//				 
//		if (emp == null)
//			return ResponseEntity.noContent().build();
//		
//		testService.saveEmployee(emp);
//		
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
//				"/{empId}").buildAndExpand(emp.getEmpId()).toUri();
//
//		return ResponseEntity.created(location).build();
//		
//   }


}
