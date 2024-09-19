package com.ahmete.repository;

import com.ahmete.entity.Manager;
import com.ahmete.entity.Stadium;

public class StadiumRepository extends RepositoryManager<Stadium, Long> {
	public StadiumRepository() {
		super(Stadium.class);
	}
}