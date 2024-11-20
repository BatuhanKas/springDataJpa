package com.springdatajpa.springdatajpa.repository;

import com.springdatajpa.springdatajpa.entities.Department;
import com.springdatajpa.springdatajpa.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

//    @Query(value = "from Department d LEFT JOIN FETCH d.employees WHERE d.Id=:id")
//    Department getDepartmentWithEmployees(int id);

    Department findByDepartmentName(String name);

}
