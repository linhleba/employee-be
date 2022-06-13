package com.lblinh.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lblinh.employee.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

}
