package com.midproject.schoolregistrationsystem.Service;

import java.util.List;

import com.midproject.schoolregistrationsystem.Model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public interface CourseService
{

    public List<Course> findAll();

    public Course findById(int id)  ;

    @Transactional
    public Course save(Course course);
}