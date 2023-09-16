package com.example.hrms.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


@Entity
@Data

@Table(name="job_seeker")
@NoArgsConstructor
@AllArgsConstructor
public class JobSeeker {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL) //database üzerinden aldığımız problemi ancak bu şekilde bir kod yazarak düzeltebildik.
	@JoinColumn(name="user_id",referencedColumnName = "id")
	private User user;
	
	@Column(name="first_name")
	private String name;
	@Column(name="last_name")
	private String surname;
	@Column(name="nid")
	private String nationallyId;
	@Column(name="birth_year")
	private String birthYear;
	
	
}
