package com.springdatajpa.springdatajpa.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.springdatajpa.springdatajpa.entities.Course;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {
    @Size(min = 3, max = 10, message = "ad 3 ila 10 karakter arasinda olmalidir")
    @NotEmpty(message = "First name can't be empty or null!")
    private String firstName;

    @Size(min = 3, max = 20)
    private String lastName;

    private Date birthday;

    private List<Course> courseList = new ArrayList<>();
}
