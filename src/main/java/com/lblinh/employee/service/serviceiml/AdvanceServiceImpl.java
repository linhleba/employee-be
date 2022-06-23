package com.lblinh.employee.service.serviceiml;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lblinh.employee.exception.ResourceNotFoundException;
import com.lblinh.employee.model.Advance;
import com.lblinh.employee.repository.AdvanceRepository;
import com.lblinh.employee.service.AdvanceService;

@Service
public class AdvanceServiceImpl implements AdvanceService {

    private AdvanceRepository advanceRepository;

    public AdvanceServiceImpl(AdvanceRepository advanceRepository) {
        super();
        this.advanceRepository = advanceRepository;
    }

    @Override
    public Advance saveAdvance(Advance advance) {
        return advanceRepository.save(advance);
    }

    @Override
    public List<Advance> getAllAdvances() {
        return advanceRepository.findAll();
    }

    @Override
    public List<Advance> getAdvanceByEmployeeId(int id) {
        List<Advance> advance = advanceRepository.getAdvance(id);
        if (advance != null) {
            return advance;
        } else {
            throw new ResourceNotFoundException("Advance", "Id", id);
        }
    }

    @Override
    public String deleteAdvance(int id) {
        try {
            advanceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Advance", "Id", id));
            advanceRepository.deleteById(id);
            return "Deleted successfully";
        } catch (Exception e) {
            return "Deleted failed";
        }
    }

    @Override
    public String getTotalAdvances(int id) {
        return advanceRepository.getTotalAdvances(id);
    }

}
