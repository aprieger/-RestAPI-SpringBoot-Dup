package com.aftt.controller;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aftt.dao.SorDao;
import com.aftt.dto.Sor;

@RestController
@RequestMapping( value = "/sors")
public class SorController {	
	
	@Autowired
	private SorDao sorDao;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Sor> getSors(){
		return sorDao.getSors();
	}
	
	@PostMapping(value = "/add/all")
    public List<Sor> addAllSors(@RequestBody List<Sor> sorList) throws SQLException {
		sorDao.addAllSors(sorList);
		return this.getSors();
    }
	
	@PostMapping(value = "/add/sor")
	public List<Sor> addSor(@RequestBody Sor sor) throws SQLException {
		sorDao.addSor(sor);
		return this.getSors();
	}
	
	@PostMapping(value = "/delete/all")
    public List<Sor> deleteAllSors() throws SQLException {
		sorDao.deleteAllSors();
		return this.getSors();
    }
}
