package com.ahmete.repository;

import com.ahmete.entity.Team;

public class TeamRepository extends RepositoryManager<Team, Long> {
	public TeamRepository() {
		super(Team.class);
	}
}