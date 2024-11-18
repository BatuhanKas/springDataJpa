package com.springdatajpa.springdatajpa.repository;

import com.springdatajpa.springdatajpa.entities.Department;
import com.springdatajpa.springdatajpa.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//    @Query(value = "SELECT * FROM student.department WHERE department_name= :departmentName", nativeQuery = true)
//    Department findByDepartmentName(String departmentName);

//    @Query("SELECT d FROM Department d WHERE d.departmentName = :departmentName")
//    Department findByDepartmentName(String departmentName);

    @Query("from Department d WHERE d.departmentName=:departmentName")
    Department findByDepartmentName(String departmentName);
}
