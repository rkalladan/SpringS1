package com.learn.spring.dao;

import java.util.List;

import com.learn.spring.model.UserProfile;

public interface UserProfileDao {

    List<UserProfile> findAll();
    
    UserProfile findByType(String type);
     
    UserProfile findById(String id);
}
