package com.midproject.schoolregistrationsystem.Service;

import java.util.List;

import com.midproject.schoolregistrationsystem.Model.Course;
import org.springframework.transaction.annotation.Transactional;


public interface CourseService {

    public List<Course> findAll();

    public Course findById(Long id);

    @Transactional
    public Course save(Course course);
}