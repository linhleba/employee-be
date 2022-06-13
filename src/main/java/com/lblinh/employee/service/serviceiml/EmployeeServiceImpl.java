package com.lblinh.employee.service.serviceiml;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lblinh.employee.exception.ResourceNotFoundException;
import com.lblinh.employee.model.Employee;
import com.lblinh.employee.repository.EmployeeRepository;
import com.lblinh.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        // TODO Auto-generated method stub
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new ResourceNotFoundException("Employee", "Id", id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, int id) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        existingEmployee.setEmployee(employee);

        employeeRepository.save(existingEmployee);
        return existingEmployee;

    }

    @Override
    public String deleteEmployees(List<Integer> ids) {
        try {
            for (int id : ids) {
                employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
                employeeRepository.deleteById(id);
            }
            return "Deleted successfully";
        } catch (Exception e) {
            return "Deleted failed";
        }

    }

}
