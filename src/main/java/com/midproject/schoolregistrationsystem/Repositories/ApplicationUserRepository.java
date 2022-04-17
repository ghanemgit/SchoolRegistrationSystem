package com.midproject.schoolregistrationsystem.Repositories;


import com.midproject.schoolregistrationsystem.Model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findApplicationUserByUsername(String username);
    ApplicationUser findApplicationUserById(Long id);
    List<ApplicationUser> findAllByUserRole(String role);


    @Query("SELECT user FROM ApplicationUser user WHERE CONCAT(user.firstName, ' ', user.lastName, ' ', user.userRole, ' ', user.username, ' ', user.degree, ' ', user.email) LIKE %?1%")
    List<ApplicationUser> search(String keyword);
}

