package com.springdatajpa.springdatajpa.services;

import com.springdatajpa.springdatajpa.dto.DtoStudent;
import com.springdatajpa.springdatajpa.dto.DtoStudentIU;
import com.springdatajpa.springdatajpa.entities.Student;

import java.util.List;

public interface IStudentService {
    public DtoStudent saveStudent(DtoStudentIU s1);

    public List<DtoStudent> getAllStudents();

    public DtoStudent getStudentWithId(Integer id);

    public void deleteStudent(int id);

    public DtoStudent updateStudent(int id, DtoStudentIU dtoStudentIU);
}
