package com.midproject.schoolregistrationsystem.Service;

import com.midproject.schoolregistrationsystem.Model.ApplicationUser;

import java.util.List;

public interface ApplicationUserService {


    List<ApplicationUser> getAllApplicationUser();

    void saveNewApplicationUser(ApplicationUser applicationUser);

    ApplicationUser getApplicationUserById(Long id);

    void updateApplicationUser(ApplicationUser applicationUser, Long id);

    void deleteApplicationUserById(Long id);

    ApplicationUser findApplicationUserByUsername(String username);

    String getApplicationUserRoleByUsername(String username);

    List<ApplicationUser> listAllBySearch(String keyword);

    List<ApplicationUser> findAllByRole(String role);

    Long stringRoleToLong(String roleToLong);

}
