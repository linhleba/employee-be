package com.lblinh.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import com.lblinh.employee.dto.EmployeeDTO;
import com.lblinh.employee.model.Employee;
import com.lblinh.employee.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
// @RequestMapping(value = "/api/employee", method = { RequestMethod.GET,
// RequestMethod.POST })
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    // create employee
    // build create employee REST API
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        // System.out.println("employee payload is," + employee);
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),
                HttpStatus.CREATED);
    }

    // get all employees
    @GetMapping
    public Set<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{ids}")
    public ResponseEntity<String> deleteEmployee(@PathVariable List<Integer> ids) {
        return new ResponseEntity<String>(employeeService.deleteEmployees(ids), HttpStatus.OK);
    }
}
