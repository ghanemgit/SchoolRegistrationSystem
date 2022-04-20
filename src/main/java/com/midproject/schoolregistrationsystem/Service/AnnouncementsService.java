package com.midproject.schoolregistrationsystem.Service;

import com.midproject.schoolregistrationsystem.Enum.Department;
import com.midproject.schoolregistrationsystem.Model.Announcement;

import java.util.List;

public interface AnnouncementsService {

    Announcement getAnnouncementsByDepartment(Department department);

    Announcement getAnnouncementsById(Long id);


    List<Announcement> getAllAnnouncements();

    void deleteAnnouncementsById(Long id);

    void updateAnnouncements(Announcement announcement, Long id);

    void addNewAnnouncements(Announcement announcement);

    List<Announcement> listAllBySearch(String keyword);
}
