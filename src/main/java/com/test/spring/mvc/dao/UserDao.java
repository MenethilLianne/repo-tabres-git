package com.test.spring.mvc.dao;

import java.util.List;

import com.test.spring.mvc.model.User;


public interface UserDao {
	User findById(int id);
    
    User findBySSO(String sso);
     
    void save(User user);
     
    void deleteBySSO(String sso);
     
    List<User> findAllUsers();
}
