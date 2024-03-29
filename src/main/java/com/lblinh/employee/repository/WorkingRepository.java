package com.lblinh.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lblinh.employee.model.Working;

public interface WorkingRepository extends JpaRepository<Working, Integer> {
    @Query(value = "SELECT * FROM working where employee_id=?1", nativeQuery = true)
    public List<Working> getWorking(int employeeId);

    @Query(value = "SELECT COUNT(distinct date) AS workingdays FROM working where employee_id=?1", nativeQuery = true)
    public String getWorkingDays(int employeeId);

    @Query(value = "select sum(hour) * employee.money FROM working join employee on employee.id=working.employee_id and employee.id=?1", nativeQuery = true)

    public String getTotalMoney(int employeeId);

    @Query(value = "SELECT * FROM working where employee_id=?1", nativeQuery = true)
    List<Working> findAllByEmployee(Integer id);

}
