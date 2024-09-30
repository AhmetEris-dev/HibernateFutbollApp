package com.ahmete.repository;

import com.ahmete.entity.Fixture;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class FixtureRepository extends RepositoryManager<Fixture,Long> {
	public FixtureRepository() {
		super(Fixture.class);
	}
	
	
}