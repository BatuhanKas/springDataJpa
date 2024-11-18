package com.springdatajpa.springdatajpa.controller.impl;

import com.springdatajpa.springdatajpa.controller.IEmployeeController;
import com.springdatajpa.springdatajpa.dto.DtoEmployee;
import com.springdatajpa.springdatajpa.services.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController implements IEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Override
    @PostMapping("/save")
    public DtoEmployee saveEmployee(@RequestBody DtoEmployee dtoEmployee) {
        return employeeService.saveEmployee(dtoEmployee);
    }

    @Override
    @GetMapping("/list")
    public List<DtoEmployee> getEmployeeList() {
        return employeeService.getEmployeeList();
    }

    @Override
    @GetMapping("/list/{id}")
    public DtoEmployee getEmployeeById(@PathVariable(name = "id") int id) {
        return employeeService.getEmployeeById(id);
    }

}
