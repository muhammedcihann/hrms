package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	boolean existsByEmail(String email); //exist ile bir durumun daha önce kullanılıp kullanılmadığı durumunu kontrol ediyoruz

}
