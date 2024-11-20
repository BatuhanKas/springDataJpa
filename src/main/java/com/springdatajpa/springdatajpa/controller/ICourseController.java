package com.springdatajpa.springdatajpa.controller;

import com.springdatajpa.springdatajpa.entities.Course;
import com.springdatajpa.springdatajpa.services.impl.CourseService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICourseController {
    public List<Course> getAllCourses();

    public ResponseEntity<String> saveCourse(Course course);
}
