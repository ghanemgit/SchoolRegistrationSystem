package com.midproject.schoolregistrationsystem.Repositories;


import com.midproject.schoolregistrationsystem.Model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findApplicationUserByUserName(String username);
    ApplicationUser findApplicationUserById(Long id);

    @Query("SELECT user FROM ApplicationUser user WHERE CONCAT(user.firstName, ' ', user.lastName, ' ', user.role, ' ', user.userName, ' ', user.degree, ' ', user.email) LIKE %?1%")
    List<ApplicationUser> search(String keyword);
}

