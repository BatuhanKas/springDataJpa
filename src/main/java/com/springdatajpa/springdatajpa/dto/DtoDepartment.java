package com.springdatajpa.springdatajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoDepartment {
    private int Id;
    private String departmentName;
    private List<DtoEmployee> dtoEmployees = new ArrayList<>();
}
