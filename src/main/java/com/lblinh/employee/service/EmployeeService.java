package com.lblinh.employee.service;

import com.lblinh.employee.model.Employee;

import java.util.*;;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    Employee updateEmployee(Employee employee, int id);

    String deleteEmployees(List<Integer> id);
}
