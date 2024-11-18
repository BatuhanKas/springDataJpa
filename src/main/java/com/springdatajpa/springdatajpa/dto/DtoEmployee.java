package com.springdatajpa.springdatajpa.dto;

import com.springdatajpa.springdatajpa.entities.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoEmployee {
    private int Id;
    private String name;
    private DtoDepartment department;
}
