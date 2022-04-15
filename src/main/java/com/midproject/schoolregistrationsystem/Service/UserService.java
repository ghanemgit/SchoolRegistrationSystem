package com.midproject.schoolregistrationsystem.Service;

import com.midproject.schoolregistrationsystem.Model.User;

import java.util.List;

public interface UserService {


    List<User> getAllUsers();

    void saveNewUser(User user);

    User getUserById(Long id);

    void updateUser(User user);

    void deleteUserById(Long id);

    User findUserByUsername(String username);

    String getUserRoleByUsername(String username);

}
