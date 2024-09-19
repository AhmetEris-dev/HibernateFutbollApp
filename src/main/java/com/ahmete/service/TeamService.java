package com.ahmete.service;

import com.ahmete.entity.Team;
import com.ahmete.repository.ICrud;
import com.ahmete.repository.TeamRepository;

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