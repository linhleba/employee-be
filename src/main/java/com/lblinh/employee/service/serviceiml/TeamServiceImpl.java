package com.lblinh.employee.service.serviceiml;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lblinh.employee.exception.ResourceNotFoundException;
import com.lblinh.employee.model.Team;
import com.lblinh.employee.repository.TeamRepository;
import com.lblinh.employee.service.TeamService;

@Service

public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        super();
        this.teamRepository = teamRepository;
    }

    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team getTeamById(int id) {
        Optional<Team> team = teamRepository.findById(id);

        if (team.isPresent()) {
            return team.get();
        } else {
            throw new ResourceNotFoundException("Team", "Id", id);
        }
    }

}
