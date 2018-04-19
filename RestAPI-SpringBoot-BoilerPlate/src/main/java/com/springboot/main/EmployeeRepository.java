package com.springboot.main;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.dto.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

	public List<Employee> findAll();
}