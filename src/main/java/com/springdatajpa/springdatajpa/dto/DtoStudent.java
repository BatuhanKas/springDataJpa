package com.springdatajpa.springdatajpa.dto;

import com.springdatajpa.springdatajpa.entities.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudent {
    private String firstName;

    private String lastName;

    private List<Course> courseList = new ArrayList<>();
}
