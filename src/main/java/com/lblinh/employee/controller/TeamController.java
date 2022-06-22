package com.lblinh.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lblinh.employee.model.Team;
import com.lblinh.employee.service.TeamService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @PostMapping()
    public ResponseEntity<Team> saveTeam(@RequestBody Team team) {
        return new ResponseEntity<Team>(teamService.saveTeam(team),
                HttpStatus.CREATED);
    }

    // get all employees
    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    // get team by id
    @GetMapping("{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable("id") int id) {
        return new ResponseEntity<Team>(teamService.getTeamById(id), HttpStatus.OK);
    }
}
