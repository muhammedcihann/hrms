package com.example.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor

public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
private int id;
	@Column(name="password")
private String password;
	@Column(name="email")
private String email;
	@Transient //Db üzerinde parola tekrarını tutmak istemediğinizden bu anotasyonu kullandık 
private String confirm_password;

	@Column(name = "is_verify_email")
private boolean isVerifyEmail;
	
	@Column(name = "email_verification_code")
private String emailVerificationCode;

	
}
