package com.ahmete.service;

import com.ahmete.entity.Fixture;
import com.ahmete.entity.Team;
import com.ahmete.repository.FixtureRepository;
import com.ahmete.repository.ICrud;
import com.ahmete.repository.MatchRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FixtureService extends ServiceManager<Fixture,Long> {
	private  final FixtureRepository fixtureRepository;
	
	public FixtureService() {
		this(new FixtureRepository());
		
	}
	
	public FixtureService(FixtureRepository fixtureRepository) {
		super(fixtureRepository);
		this.fixtureRepository = fixtureRepository;
		
	}
	
}