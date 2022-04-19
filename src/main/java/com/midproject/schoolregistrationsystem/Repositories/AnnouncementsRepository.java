package com.midproject.schoolregistrationsystem.Repositories;


import com.midproject.schoolregistrationsystem.Enum.Department;
import com.midproject.schoolregistrationsystem.Model.Announcement;
import com.midproject.schoolregistrationsystem.Model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementsRepository extends JpaRepository<Announcement,Long> {

    Announcement findAnnouncementsByDepartment(Department department);

    @Query("SELECT anno FROM Announcement anno WHERE CONCAT(anno.department, ' ', anno.description, ' ', anno.id) LIKE %?1%")
    List<Announcement> search(String keyword);

}
