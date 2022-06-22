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

import com.lblinh.employee.model.Working;
import com.lblinh.employee.service.WorkingService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/working")
public class WorkingController {
    @Autowired
    private WorkingService workingService;

    @PostMapping()
    public ResponseEntity<Working> saveWorking(@RequestBody Working working) {
        return new ResponseEntity<Working>(workingService.saveWorking(working),
                HttpStatus.CREATED);
    }

    @GetMapping
    public List<Working> getAllWorkings() {
        return workingService.getAllWorkings();
    }

    @GetMapping("{id}")
    // public ResponseEntity<List<Working>> getWorkingById(@PathVariable("id") int
    // id) {
    // return new
    // ResponseEntity<List<Working>>(workingService.getWorkingByEmployeeId(id),
    // HttpStatus.OK);
    // }

    public List<Working> getWorkingById(@PathVariable("id") int id) {
        return workingService.getWorkingByEmployeeId(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteWorking(@PathVariable int id) {
        return new ResponseEntity<String>(workingService.deleteWorking(id), HttpStatus.OK);
    }
}
