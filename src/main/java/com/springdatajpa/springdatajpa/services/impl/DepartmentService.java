package com.springdatajpa.springdatajpa.services.impl;

import com.springdatajpa.springdatajpa.dto.DtoDepartment;
import com.springdatajpa.springdatajpa.dto.DtoEmployee;
import com.springdatajpa.springdatajpa.entities.Department;
import com.springdatajpa.springdatajpa.entities.Employee;
import com.springdatajpa.springdatajpa.repository.DepartmentRepository;
import com.springdatajpa.springdatajpa.services.IDepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DtoDepartment saveDepartment(DtoDepartment dtoDepartment) {
        Department department = new Department();
        BeanUtils.copyProperties(dtoDepartment, department);
        Department db = departmentRepository.save(department);
        BeanUtils.copyProperties(db, dtoDepartment);
        return dtoDepartment;
    }

    @Override
    public DtoDepartment getDepartmentById(int id) {
        DtoDepartment dtoDepartment = new DtoDepartment();
        Optional<Department> optional = departmentRepository.findById(id);
        if (optional.isPresent()) {
            BeanUtils.copyProperties(optional.get(), dtoDepartment);
            Department dbDepartment = departmentRepository.getDepartmentWithEmployees(id);
            for (Employee employee : dbDepartment.getEmployees()) {
                DtoEmployee dtoEmployee = new DtoEmployee();
                BeanUtils.copyProperties(employee, dtoEmployee);
                dtoDepartment.getDtoEmployees().add(dtoEmployee);
            }
        }
        return dtoDepartment;
    }
}
