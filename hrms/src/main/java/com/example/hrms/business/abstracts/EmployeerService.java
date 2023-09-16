package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employeer;

public interface EmployeerService {
	
	DataResult<List<Employeer>> getAll();
	
	Result register(Employeer employeer);
	
	
}
