package com.midproject.schoolregistrationsystem.Service;


import com.midproject.schoolregistrationsystem.Model.User;
import com.midproject.schoolregistrationsystem.Repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserDetailsService userDetailsService;

    public UserServiceImp(UserRepository userRepository, RoleService roleService, UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public List<User> getAllUsers() {
        System.out.println("Hello from AUSI");
        return userRepository.findAll();
    }

    @Override
    public void saveNewUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {

        userRepository.deleteById(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUserName(username);
    }

    @Override
    public String getUserRoleByUsername(String username) {
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
}


