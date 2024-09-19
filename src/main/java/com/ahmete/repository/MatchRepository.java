package com.ahmete.repository;

import com.ahmete.entity.Match;

public class MatchRepository extends RepositoryManager<Match,Long>{
	public MatchRepository() {
		super(Match.class);
	}
}