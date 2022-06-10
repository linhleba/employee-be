package com.lblinh.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lblinh.employee.model.Employee;;

// @Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
