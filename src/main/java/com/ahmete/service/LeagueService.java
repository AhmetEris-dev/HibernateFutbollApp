package com.ahmete.service;

import com.ahmete.entity.League;
import com.ahmete.repository.ICrud;
import com.ahmete.repository.LeagueRepository;

public class LeagueService extends ServiceManager<League,Long> {
	private final LeagueRepository leagueRepository;
	
	public LeagueService() {
		this(new LeagueRepository());
	}
	
	public LeagueService(LeagueRepository leagueRepository) {
		super(leagueRepository);
		this.leagueRepository = leagueRepository;
	}
	
 
	
}