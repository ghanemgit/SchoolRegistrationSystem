package com.midproject.schoolregistrationsystem.Service;

import com.midproject.schoolregistrationsystem.Model.ApplicationUser;

import java.util.List;

public interface ApplicationUserService {


    List<ApplicationUser> getAllApplicationUser();

    void saveNewApplicationUser(ApplicationUser applicationUser);

    ApplicationUser getApplicationUserById(Long id);

    void updateApplicationUser(ApplicationUser applicationUser);

    void deleteApplicationUserById(Long id);

    ApplicationUser findApplicationUserByUsername(String username);

    String getApplicationUserRoleByUsername(String username);

}
