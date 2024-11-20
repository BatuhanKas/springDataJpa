package com.springdatajpa.springdatajpa.services.impl;

import com.springdatajpa.springdatajpa.entities.Course;
import com.springdatajpa.springdatajpa.repository.CourseRepository;
import com.springdatajpa.springdatajpa.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public boolean saveCourse(Course course) {
        courseRepository.save(course);
        return true;
    }
}
