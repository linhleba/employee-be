package com.lblinh.employee.service.serviceiml;

import org.springframework.stereotype.Service;

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

}
