package com.springdatajpa.springdatajpa.services;

import com.springdatajpa.springdatajpa.dto.DtoDepartment;
import com.springdatajpa.springdatajpa.dto.DtoEmployee;

import java.util.List;

public interface IEmployeeService {
    public DtoEmployee saveEmployee(DtoEmployee dtoEmployee);

    public List<DtoEmployee> getEmployeeList();

    public DtoEmployee getEmployeeById(int id);

}
