package com.springdatajpa.springdatajpa.services.impl;

import com.springdatajpa.springdatajpa.dto.DtoDepartment;
import com.springdatajpa.springdatajpa.dto.DtoEmployee;
import com.springdatajpa.springdatajpa.entities.Department;
import com.springdatajpa.springdatajpa.entities.Employee;
import com.springdatajpa.springdatajpa.repository.EmployeeRepository;
import com.springdatajpa.springdatajpa.services.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public DtoEmployee saveEmployee(DtoEmployee dtoEmployee) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(dtoEmployee, employee);

        Department departmentDb = employeeRepository.findByDepartmentName(dtoEmployee.getDepartment().getDepartmentName());

        employee.setDepartment(departmentDb);
//        employee.getDepartment().getEmployees().add(employee);

        Employee employeeDb = employeeRepository.save(employee);

        DtoEmployee dtoEmployee1 = new DtoEmployee();
        DtoDepartment dtoDepartment = new DtoDepartment();

        BeanUtils.copyProperties(employeeDb, dtoEmployee1);
        dtoDepartment.setId(employeeDb.getDepartment().getId());
        dtoDepartment.setDepartmentName(employeeDb.getDepartment().getDepartmentName());
        dtoEmployee1.setDepartment(dtoDepartment);
//        dtoEmployee1.getDepartment().getDtoEmployees().add(dtoEmployee1);

        return dtoEmployee1;
    }

    @Override
    public List<DtoEmployee> getEmployeeList() {
        List<DtoEmployee> dtoEmployees = new ArrayList<>();

        for (Employee employee : employeeRepository.findAll()) {
            DtoEmployee dtoEmployee = new DtoEmployee();
            DtoDepartment copyDepartment = new DtoDepartment();

            BeanUtils.copyProperties(employee, dtoEmployee);
            BeanUtils.copyProperties(employee.getDepartment(), copyDepartment);

            dtoEmployee.setDepartment(copyDepartment);

            dtoEmployees.add(dtoEmployee);
        }
        return dtoEmployees;
    }

    @Override
    public DtoEmployee getEmployeeById(int id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent()) {
            DtoEmployee dtoEmployee = new DtoEmployee();
            BeanUtils.copyProperties(optional.get(), dtoEmployee);

            DtoDepartment dtoDepartment = new DtoDepartment();
            BeanUtils.copyProperties(optional.get().getDepartment(), dtoDepartment);

            dtoEmployee.setDepartment(dtoDepartment);
            return dtoEmployee;
        }
        return null;
    }


}
