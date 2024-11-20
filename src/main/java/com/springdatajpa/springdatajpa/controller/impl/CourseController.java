package com.springdatajpa.springdatajpa.controller.impl;

import com.springdatajpa.springdatajpa.controller.ICourseController;
import com.springdatajpa.springdatajpa.entities.Course;
import com.springdatajpa.springdatajpa.services.impl.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController implements ICourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/save")
    @Override
    public ResponseEntity<String> saveCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
        return ResponseEntity.ok("Course saved");
    }

    @GetMapping("/list")
    @Override
    public List<Course> getAllCourses() {
        return null;
    }
}
