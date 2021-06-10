package com.test.spring.mvc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Table(name="persistent_logins")
@Data
public class PersistentLogin implements Serializable {
	@Id
	private String series;
	
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	
	@Column(name = "token", unique = true, nullable = false)
	private String token;
	
	@Column(name = "last_used")
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_used;
	
	
}
