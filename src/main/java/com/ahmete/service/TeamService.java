package com.ahmete.service;

import com.ahmete.entity.Team;
import com.ahmete.repository.ICrud;
import com.ahmete.repository.TeamRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.Optional;

public class TeamService extends ServiceManager<Team,Long>{
	private final TeamRepository teamRepository;
	
	public TeamService() {
		this(new TeamRepository());
	}
	
	public TeamService(TeamRepository teamRepository) {
		super(teamRepository);
		this.teamRepository = teamRepository;
	}
	

}