package com.ahmete.repository;

import com.ahmete.entity.League;

public class LeagueRepository extends RepositoryManager<League,Long> {
	public LeagueRepository() {
		super(League.class);
	}
}