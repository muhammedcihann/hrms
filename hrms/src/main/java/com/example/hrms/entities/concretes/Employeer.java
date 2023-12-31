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
@Table (name = "employeers")
@NoArgsConstructor
@AllArgsConstructor
public class Employeer {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL) //database üzerinden aldığımız problemi ancak bu şekilde bir kod yazarak düzeltebildik.
	@JoinColumn(name="user_id",referencedColumnName = "id")
	private User user;
	
	@Column(name="company_name")
	private String companyName;
	@Column(name="website")
	private String website;
	@Column(name="phone_number")
	private String phoneNumber;
	
	
	
}
