package com.learn.spring.service;

import java.util.List;

import com.learn.spring.model.UserProfile;

public interface UserProfileService {
	   	UserProfile findById(String id);
	   
	    UserProfile findByType(String type);
	     
	    List<UserProfile> findAll();
}
