package com.lblinh.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lblinh.employee.model.Working;

public interface WorkingRepository extends JpaRepository<Working, Integer> {
    @Query(value = "SELECT * FROM working where employee_id=?1", nativeQuery = true)
    public List<Working> getWorking(int employeeId);
}
