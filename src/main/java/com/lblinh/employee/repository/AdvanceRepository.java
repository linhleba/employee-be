package com.lblinh.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lblinh.employee.model.Advance;

public interface AdvanceRepository extends JpaRepository<Advance, Integer> {
    @Query(value = "SELECT * FROM working where employee_id=?1", nativeQuery = true)
    public List<Advance> getAdvance(int employeeId);
}