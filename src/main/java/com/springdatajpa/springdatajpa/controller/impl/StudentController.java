package com.springdatajpa.springdatajpa.controller.impl;

import com.springdatajpa.springdatajpa.controller.IStudentController;
import com.springdatajpa.springdatajpa.dto.DtoStudent;
import com.springdatajpa.springdatajpa.dto.DtoStudentIU;
import com.springdatajpa.springdatajpa.entities.Student;
import com.springdatajpa.springdatajpa.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController implements IStudentController {
    @Autowired
    private IStudentService studentService;

    // DTO kullanilir.
    @PostMapping("/save")
    @Override
    public DtoStudent saveStudent(@RequestBody DtoStudentIU dtoStudentIU) {
        return studentService.saveStudent(dtoStudentIU);
    }

    @Override
    @GetMapping("/list")
    public List<DtoStudent> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Override
    @GetMapping("/list/{id}")
    public DtoStudent getStudentWithId(@PathVariable(name = "id") Integer id) {
        return studentService.getStudentWithId(id);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable(name = "id", required = true) int id) {
        studentService.deleteStudent(id);
    }

    @Override
    @PutMapping("/update/{id}")
    public DtoStudent updateStudent(@PathVariable(name = "id") int id,
                                 @RequestBody DtoStudentIU dtoStudentIU) {
        return studentService.updateStudent(id, dtoStudentIU);
    }
}
