package com.lblinh.employee.service;

import java.util.List;

import com.lblinh.employee.model.Advance;

public interface AdvanceService {
    Advance saveAdvance(Advance team);

    List<Advance> getAllAdvances();

    List<Advance> getAdvanceByEmployeeId(int id);

    String deleteAdvance(int id);

    String getTotalAdvances(int id);
}
