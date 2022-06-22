package com.lblinh.employee.service.serviceiml;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.hibernate.boot.registry.classloading.spi.ClassLoaderService.Work;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lblinh.employee.exception.ResourceNotFoundException;
import com.lblinh.employee.model.Employee;
import com.lblinh.employee.repository.AdvanceRepository;
import com.lblinh.employee.repository.EmployeeRepository;
import com.lblinh.employee.repository.WorkingRepository;
import com.lblinh.employee.service.EmployeeService;
import com.lblinh.employee.dto.EmployeeDTO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private ModelMapper mapper;

    private EmployeeRepository employeeRepository;
    private WorkingRepository workingRepository;
    private AdvanceRepository advanceRepository;
    // EmployeeDTO employeeDTO = mapper.map(employeeRepository, EmployeeDTO.class);

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
    public Set<EmployeeDTO> getAllEmployees() {
        // return employeeRepository.findAll();
        Set<EmployeeDTO> employeeDTOSet = new HashSet<>();
        // employeeRepository.findAll().forEach(employee -> {
        // employeeDTOSet.add(mapper.map(employeeRepository, EmployeeDTO.class));
        // });

        List<Employee> employee = employeeRepository.findAll();

        employee.forEach(obj -> employeeDTOSet.add(mapper.map(obj, EmployeeDTO.class)));

        return employeeDTOSet;
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
            // for (int id : ids) {
            // employeeRepository.findById(id).orElseThrow(() -> new
            // ResourceNotFoundException("Employee", "Id", id));
            // employeeRepository.deleteById(id);
            // }
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
