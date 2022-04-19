package com.midproject.schoolregistrationsystem.Service;


import com.midproject.schoolregistrationsystem.Enum.Department;
import com.midproject.schoolregistrationsystem.Model.Announcement;
import com.midproject.schoolregistrationsystem.Repositories.AnnouncementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementsServiceImp implements AnnouncementsService{

    @Autowired
    private AnnouncementsRepository announcementsRepository;

    @Override
    public Announcement getAnnouncementsByDepartment(Department department) {
        return announcementsRepository.findAnnouncementsByDepartment(department);
    }



    @Override
    public List<Announcement> getAllAnnouncements() {
        return announcementsRepository.findAll();
    }



    @Override
    public void updateAnnouncements(Announcement announcement,Long id) {

        Announcement newAnnouncement = getAnnouncementsById(id);

        newAnnouncement.setDepartment(announcement.getDepartment());
        newAnnouncement.setDescription(announcement.getDescription());

        announcementsRepository.save(newAnnouncement);
    }

    @Override
    public void addNewAnnouncements(Announcement announcement) {

        announcementsRepository.save(announcement);
    }

    @Override
    public void deleteAnnouncementsById(Long id) {
        announcementsRepository.deleteById(id);
    }

    @Override
    public Announcement getAnnouncementsById(Long id) {
        return announcementsRepository.getById(id);
    }


    @Override
    public List<Announcement> listAllBySearch(String keyword) {
        if (keyword != null) {
            return announcementsRepository.search(keyword);
        }
        return announcementsRepository.findAll();
    }
}
