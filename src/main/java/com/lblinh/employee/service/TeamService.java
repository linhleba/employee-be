package com.lblinh.employee.service;

import com.lblinh.employee.model.Team;

import java.util.*;

public interface TeamService {
    Team saveTeam(Team team);

    List<Team> getAllTeams();

    Team getTeamById(int id);
}
