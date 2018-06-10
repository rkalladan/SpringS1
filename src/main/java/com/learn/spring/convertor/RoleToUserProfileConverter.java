package com.learn.spring.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.learn.spring.model.UserProfile;
import com.learn.spring.service.UserProfileService;

@Component
public class RoleToUserProfileConverter implements Converter<Object, UserProfile>{
    @Autowired
    UserProfileService userProfileService;
 
    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public UserProfile convert(Object element) {
        UserProfile profile= userProfileService.findById((String) element);
        System.out.println("Profile : "+profile);
        return profile;
    }
}
