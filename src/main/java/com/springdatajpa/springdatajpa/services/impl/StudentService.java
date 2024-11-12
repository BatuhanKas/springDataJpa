package com.springdatajpa.springdatajpa.services.impl;

import com.springdatajpa.springdatajpa.dto.DtoStudent;
import com.springdatajpa.springdatajpa.dto.DtoStudentIU;
import com.springdatajpa.springdatajpa.entities.Student;
import com.springdatajpa.springdatajpa.repository.StudentRepository;
import com.springdatajpa.springdatajpa.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        Student student = new Student();
        DtoStudent dtoStudent = new DtoStudent();

        BeanUtils.copyProperties(dtoStudentIU, student);
        Student dbStudent = studentRepository.save(student);

        BeanUtils.copyProperties(dbStudent, dtoStudent);
        return dtoStudent;
    }

    @Override
    public List<DtoStudent> getAllStudents() {
        List<DtoStudent> dtoStudents = new ArrayList<>();
        for (Student student : studentRepository.findAllStudentsSQL()) {
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(student, dtoStudent);
            dtoStudents.add(dtoStudent);
        }
        return dtoStudents;
    }

    @Override
    public DtoStudent getStudentWithId(Integer id) {
        try {
            Optional<Student> optional = studentRepository.findStudentByIdSQL(id);
            Student student = optional.get();
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(student, dtoStudent);
            return dtoStudent;
//        return studentRepository.findById(id).get();
        } catch (Exception e) {
            System.out.println("false index: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public DtoStudent updateStudent(int id, DtoStudentIU dtoStudentIU) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(dtoStudentIU, student.get());
            Student s1 = studentRepository.save(student.get());
            BeanUtils.copyProperties(s1, dtoStudent);
            return dtoStudent;
        }
        return null;
    }
}
