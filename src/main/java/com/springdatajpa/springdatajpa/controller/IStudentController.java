package com.springdatajpa.springdatajpa.controller;

import com.springdatajpa.springdatajpa.dto.DtoStudent;
import com.springdatajpa.springdatajpa.dto.DtoStudentIU;
import com.springdatajpa.springdatajpa.entities.Student;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface IStudentController {
    public DtoStudent saveStudent(DtoStudentIU s1);

    public List<DtoStudent> getAllStudents();

    public DtoStudent getStudentWithId(Integer id);

    public void deleteStudent(int id);

    public DtoStudent updateStudent(int id, DtoStudentIU dtoStudentIU);
}
