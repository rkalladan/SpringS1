package com.learn.spring.service;

import java.util.List;

import com.learn.spring.model.User;

public interface UserService {

    User findById(String id);
    
    User findBySSO(String sso);
     
    void saveUser(User user);
     
    void updateUser(User user);
     
    void deleteUserBySSO(String sso);
 
    List<User> findAllUsers(); 
     
    boolean isUserSSOUnique(String id, String sso);
}
