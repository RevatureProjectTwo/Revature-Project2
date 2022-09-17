package com.Revature.ecommerce.project2WesPSamvelA.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


@Entity
@Table(name="user_details")
public class UserEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_username")
	private String userUserName;
	
	@Column(name="user_password")
	private String userPassword;
	
	@Column(name="user_first_name")
	private String userFirstName;
	
	@Column(name="user_last_name")
	private String userLastName;
	
	@Column(name="user_address")
	private String userAddress;
	
	@Column(name="user_email")
	private String userEmail;
	
	@Column(name="user_contact_number")
	private String userContact;
	
	@Column(name="user_is_employee")
	private boolean userEmployee;
}
