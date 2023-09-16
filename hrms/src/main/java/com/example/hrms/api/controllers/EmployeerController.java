package com.example.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.EmployeerService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employeer;


@RestController
@RequestMapping("/api/employeer")
public class EmployeerController {
	
	@Autowired
	EmployeerService employeerService;
	
	@GetMapping("/getAll")
	public DataResult<List<Employeer>> getEmployeers() {
		return this.employeerService.getAll();
	}
	
	
	@PostMapping("/register")
	public Result register(@RequestBody Employeer employeer) {
		
		return this.employeerService.register(employeer);
		
	}
	
}
