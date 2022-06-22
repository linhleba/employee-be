package com.lblinh.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lblinh.employee.model.Advance;
import com.lblinh.employee.service.AdvanceService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/advance")
public class AdvanceController {
    @Autowired
    private AdvanceService advanceService;

    @PostMapping()
    public ResponseEntity<Advance> saveAdvance(@RequestBody Advance advance) {
        return new ResponseEntity<Advance>(advanceService.saveAdvance(advance),
                HttpStatus.CREATED);
    }

    @GetMapping
    public List<Advance> getAllAdvances() {
        return advanceService.getAllAdvances();
    }

    @GetMapping("{id}")

    public List<Advance> getAdvanceById(@PathVariable("id") int id) {
        return advanceService.getAdvanceByEmployeeId(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAdvance(@PathVariable int id) {
        return new ResponseEntity<String>(advanceService.deleteAdvance(id), HttpStatus.OK);
    }
}
