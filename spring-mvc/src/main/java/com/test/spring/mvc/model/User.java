package com.test.spring.mvc.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Table(name="app_user")
@Data
public class User implements Serializable {
	
	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Integer id;
	
	
	@Column(name="sso_id", unique = true, nullable = false)
	private String ssoId;
	
	
	@Column(name="password", nullable=false)
	private String password;
	
	
	@Column(name="first_Name", nullable=false)
	private String firstName;
	
	
	@Column(name="last_Name", nullable=false)
	private String lastName;
	
	
	@Column(name="email", nullable=false)
	private String email;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="app_user_user_profile", joinColumns = {@JoinColumn(name="user_id")}, inverseJoinColumns = {@JoinColumn(name="user_profile_id")})
	private Set<UserProfile> userProfiles = new HashSet<UserProfile>();
	
	
}
