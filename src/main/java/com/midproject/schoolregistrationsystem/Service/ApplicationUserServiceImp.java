package com.midproject.schoolregistrationsystem.Service;


import com.midproject.schoolregistrationsystem.Model.ApplicationUser;
import com.midproject.schoolregistrationsystem.Repositories.ApplicationUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationUserServiceImp implements ApplicationUserService {

    private final ApplicationUserRepository applicationUserRepository;
    private final RoleService roleService;
    private final UserDetailsService userDetailsService;

    public ApplicationUserServiceImp(ApplicationUserRepository applicationUserRepository, RoleService roleService, UserDetailsService userDetailsService) {
        this.applicationUserRepository = applicationUserRepository;
        this.roleService = roleService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public List<ApplicationUser> getAllApplicationUser() {
        System.out.println("Hello from AUSI");
        return applicationUserRepository.findAll();
    }

    @Override
    public void saveNewApplicationUser(ApplicationUser applicationUser) {
        applicationUserRepository.save(applicationUser);
    }

    @Override
    public ApplicationUser getApplicationUserById(Long id) {
        return applicationUserRepository.findById(id).get();
    }

    @Override
    public void updateApplicationUser(ApplicationUser applicationUser) {
        applicationUserRepository.save(applicationUser);
    }

    @Override
    public void deleteApplicationUserById(Long id) {

        applicationUserRepository.deleteById(id);
    }

    @Override
    public ApplicationUser findApplicationUserByUsername(String username) {
        return applicationUserRepository.findApplicationUserByUsername(username);
    }

    @Override
    public List<ApplicationUser> findAllByRole(String role){
        return applicationUserRepository.findAllByUserRole(role);

    }

    @Override
    public String getApplicationUserRoleByUsername(String username) {
        String role="No Role";

        UserDetails user = userDetailsService.loadUserByUsername(username);

        if (user != null && user.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN")))
            role = "ADMIN";

        else if (user != null && user.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("TEACHER")))
            role =  "TEACHER";

        else if (user != null && user.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("STUDENT")))
            role =  "STUDENT";

        return role;
    }

    @Override
    public List<ApplicationUser> listAllBySearch(String keyword) {
        if (keyword != null) {
            return applicationUserRepository.search(keyword);
        }
        return applicationUserRepository.findAll();
    }
}


