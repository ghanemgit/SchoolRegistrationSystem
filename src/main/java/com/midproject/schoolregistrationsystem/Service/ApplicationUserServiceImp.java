package com.midproject.schoolregistrationsystem.Service;


import com.midproject.schoolregistrationsystem.Model.ApplicationUser;
import com.midproject.schoolregistrationsystem.Repositories.ApplicationUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationUserServiceImp implements ApplicationUserService {

    private final ApplicationUserRepository applicationUserRepository;
    private final RoleService roleService;
    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    public ApplicationUserServiceImp(ApplicationUserRepository applicationUserRepository, RoleService roleService, UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.roleService = roleService;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<ApplicationUser> getAllApplicationUser() {
        System.out.println("Hello from AUSI");
        return applicationUserRepository.findAll();
    }

    @Override
    public void saveNewApplicationUser(ApplicationUser applicationUser) {

        Long uRole=0L;
        ApplicationUser newApplicationUser = new ApplicationUser(
                applicationUser.getUsername()
                ,applicationUser.getPassword()
                ,applicationUser.getFirstName()
                ,applicationUser.getLastName()
                ,applicationUser.getGender()
                ,applicationUser.getAge()
                ,applicationUser.getEmail()
                , applicationUser.getMaritalState()
                ,applicationUser.getDegree()
                ,applicationUser.getUserRole());

        /*
        I created this method to take the role as string from the form and replace it by number of type long
        this is done to store the role of user into user_id-user_role table(1 represent the admin,
        2 represent the teacher and 3 represent the student
         */
        uRole = stringRoleToLong(applicationUser.getUserRole());


        newApplicationUser.setRole(roleService.findRoleById(uRole));


        newApplicationUser.setPassword(passwordEncoder.encode(newApplicationUser.getPassword()));
        applicationUserRepository.save(newApplicationUser);
    }

    @Override
    public ApplicationUser getApplicationUserById(Long id) {
        return applicationUserRepository.findById(id).get();
    }

    @Override
    public void updateApplicationUser(ApplicationUser applicationUser,Long id) {

        Long uRole;


        ApplicationUser existingApplicationUser = getApplicationUserById(id);
        existingApplicationUser.setFirstName(applicationUser.getFirstName());
        existingApplicationUser.setLastName(applicationUser.getLastName());
        existingApplicationUser.setEmail(applicationUser.getEmail());
        existingApplicationUser.setAge(applicationUser.getAge());
        existingApplicationUser.setUserRole(applicationUser.getUserRole());
        existingApplicationUser.setDegree(applicationUser.getDegree());
        existingApplicationUser.setGender(applicationUser.getGender());
        existingApplicationUser.setMaritalState(applicationUser.getMaritalState());
        existingApplicationUser.setPassword(passwordEncoder.encode(applicationUser.getPassword()));

        /*
        I created this method to take the role as string from the form and replace it by number of type long
        this is done to store the role of user into user_id-user_role table(1 represent the admin,
        2 represent the teacher and 3 represent the student
         */
        uRole = stringRoleToLong(existingApplicationUser.getUserRole());


        existingApplicationUser.setRole(roleService.findRoleById(uRole));

        applicationUserRepository.save(existingApplicationUser);
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

    @Override
    public Long stringRoleToLong(String roleToLong) {
        Long uRole = 0L;

        switch (roleToLong){
            case "Admin":
                uRole=1L;
                break;
            case "Teacher":
                uRole=2L;
                break;
            case "Student":
                uRole=3L;
                break;
        }


        return uRole;
    }
}


