package com.springdatajpa.springdatajpa.controller;

import com.springdatajpa.springdatajpa.dto.DtoEmployee;

import java.util.List;

public interface IEmployeeController {
    public DtoEmployee saveEmployee(DtoEmployee dtoEmployee);

    public List<DtoEmployee> getEmployeeList();

    public DtoEmployee getEmployeeById(int id);
}
