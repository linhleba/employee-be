package com.lblinh.employee.service;

import java.util.List;

import com.lblinh.employee.model.Working;

public interface WorkingService {
    Working saveWorking(Working team);

    List<Working> getAllWorkings();

    List<Working> getWorkingByEmployeeId(int id);

    String deleteWorking(int id);
}
