package com.learn.spring.dao;

import java.util.List;

import com.learn.spring.model.User;

public interface UserDao {
    User findById(String id);
    
    User findBySSO(String sso);
     
    void save(User user);
     
    void deleteBySSO(String sso);
     
    List<User> findAllUsers();
}
