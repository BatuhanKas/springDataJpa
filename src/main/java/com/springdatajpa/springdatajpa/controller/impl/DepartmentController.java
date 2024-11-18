package com.springdatajpa.springdatajpa.controller.impl;

import com.springdatajpa.springdatajpa.controller.IDepartmentController;
import com.springdatajpa.springdatajpa.dto.DtoDepartment;
import com.springdatajpa.springdatajpa.dto.DtoEmployee;
import com.springdatajpa.springdatajpa.services.impl.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController implements IDepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Override
    @PostMapping("/save")
    public DtoDepartment saveDepartment(@RequestBody DtoDepartment dtoDepartment) {
        return departmentService.saveDepartment(dtoDepartment);
    }

    @Override
    @GetMapping("/list/{id}")
    public DtoDepartment getDepartmentById(@PathVariable(name = "id") int id) {
        return departmentService.getDepartmentById(id);
    }
}
