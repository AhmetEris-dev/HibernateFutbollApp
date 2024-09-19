package com.ahmete.service;

import com.ahmete.entity.Match;
import com.ahmete.repository.ManagerRepository;
import com.ahmete.repository.MatchRepository;

public class MatchService extends ServiceManager<Match,Long> {
	private  final MatchRepository matchRepository;
	
	public MatchService() {
		this(new MatchRepository());
	}
	
	public MatchService(MatchRepository matchRepository) {
		super(matchRepository);
		this.matchRepository = matchRepository;
	}
}