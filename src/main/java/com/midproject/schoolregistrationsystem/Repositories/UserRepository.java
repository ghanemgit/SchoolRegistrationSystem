package com.midproject.schoolregistrationsystem.Repositories;


import com.midproject.schoolregistrationsystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserName (String username);
    User findUserById (Long id);
}

