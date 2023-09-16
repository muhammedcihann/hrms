package com.example.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.JobSeekerService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekerController {
	
	@Autowired
	private JobSeekerService jobSeekerService;
	
	@GetMapping("/getAll")
    public DataResult<List<JobSeeker>> getJobSeekers(){
        return this.jobSeekerService.getAll();
    }
	
	@PostMapping("/register")
	public Result register(@RequestBody JobSeeker jobSeeker) {
	return this.jobSeekerService.register(jobSeeker);
		
	}

	
		
	
	
	
	
		
	

}
