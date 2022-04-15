package com.midproject.schoolregistrationsystem.Repositories;


import com.midproject.schoolregistrationsystem.Model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findApplicationUserByUserName(String username);
    ApplicationUser findApplicationUserById(Long id);
}

