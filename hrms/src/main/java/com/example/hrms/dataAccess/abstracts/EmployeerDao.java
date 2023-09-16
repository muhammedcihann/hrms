package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hrms.entities.concretes.Employeer;

@Repository
public interface EmployeerDao extends JpaRepository<Employeer, Integer>{
	
}
