package com.midproject.schoolregistrationsystem.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private String name;
    @Column(unique = false, columnDefinition = "TEXT")
    private String description;


    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<ApplicationUser> students = new ArrayList<>();


    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public Long getId() { return id; }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ApplicationUser> getStudents() {
        return students;
    }

    public void addStudent(ApplicationUser student) {
        this.students.add(student);
    }

    public void removeStudent(ApplicationUser student) {
        this.students.remove(student);
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + "]";
    }

}