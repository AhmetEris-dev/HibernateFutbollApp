package com.ahmete.repository;

import com.ahmete.entity.Fixture;

public class FixtureRepository extends RepositoryManager<Fixture,Long> {
	public FixtureRepository() {
		super(Fixture.class);
	}
}