package com.aftt.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aftt.dto.MetaPlatform;
import com.aftt.dto.Sor;
import com.aftt.main.SorRepository;

@Component
public class SorDao  {

	@Autowired
	private SorRepository repository;
	
	private List<Sor> sorRepo;
	private List<Sor> sorOrderedList;
	
	//Get all the sors in the repository
	public List<Sor> getSors(){
		List<Sor> sorList= repository.findAll();
		System.out.println(sorList.toString());
		return repository.findAll();
	}
	
	//Post the new list of sors to the repo
	public void addAllSors(List<Sor> sorList) {
		repository.insert(sorList);
	}
	
	//Post the new single sor to the repo
	public void addSor(Sor sor) {
		repository.insert(sor);
	}
	
	//Delete all the data from the sors repo
	public void deleteAllSors() {
		repository.deleteAll();
	}
}