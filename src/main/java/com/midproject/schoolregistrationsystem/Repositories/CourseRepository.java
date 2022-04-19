package com.midproject.schoolregistrationsystem.Repositories;

import com.midproject.schoolregistrationsystem.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{


}