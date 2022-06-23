package com.lblinh.employee.service.serviceiml;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lblinh.employee.exception.ResourceNotFoundException;
import com.lblinh.employee.model.Working;
import com.lblinh.employee.repository.WorkingRepository;
import com.lblinh.employee.service.WorkingService;

@Service
public class WorkingServiceImpl implements WorkingService {
    private WorkingRepository workingRepository;

    public WorkingServiceImpl(WorkingRepository workingRepository) {
        super();
        this.workingRepository = workingRepository;
    }

    @Override
    public Working saveWorking(Working working) {
        return workingRepository.save(working);
    }

    @Override
    public List<Working> getAllWorkings() {
        return workingRepository.findAll();
    }

    @Override
    public List<Working> getWorkingByEmployeeId(int id) {
        List<Working> working = workingRepository.getWorking(id);
        if (working != null) {
            return working;
        } else {
            throw new ResourceNotFoundException("Working", "Id", id);
        }
    }

    @Override
    public String deleteWorking(int id) {
        try {

            workingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Working", "Id", id));
            workingRepository.deleteById(id);

            return "Deleted successfully";
        } catch (Exception e) {
            return "Deleted failed";
        }
    }

    @Override
    public String getNumberWokring(int id) {
        // TODO Auto-generated method stub

        return workingRepository.getWorkingDays(id);

    }

    @Override
    public String getTotalMoney(int id) {
        // TODO Auto-generated method stub
        return workingRepository.getTotalMoney(id);
    }
}
