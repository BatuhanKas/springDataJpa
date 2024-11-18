package com.springdatajpa.springdatajpa.controller;

import com.springdatajpa.springdatajpa.dto.DtoDepartment;
import com.springdatajpa.springdatajpa.dto.DtoEmployee;

import java.util.List;

public interface IDepartmentController {
    public DtoDepartment saveDepartment(DtoDepartment dtoDepartment);

    public DtoDepartment getDepartmentById(int id);
}
