package com.test.spring.mvc.dao;

import java.util.List;

import com.test.spring.mvc.model.UserProfile;


public interface UserProfileDao {
	List<UserProfile> findAll();
    
    UserProfile findByType(String type);
     
    UserProfile findById(int id);
}
