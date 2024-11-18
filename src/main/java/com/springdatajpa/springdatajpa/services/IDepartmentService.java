package com.springdatajpa.springdatajpa.services;

import com.springdatajpa.springdatajpa.dto.DtoDepartment;
import com.springdatajpa.springdatajpa.dto.DtoEmployee;

public interface IDepartmentService {
    public DtoDepartment saveDepartment(DtoDepartment dtoDepartment);

    public DtoDepartment getDepartmentById(int id);

}
