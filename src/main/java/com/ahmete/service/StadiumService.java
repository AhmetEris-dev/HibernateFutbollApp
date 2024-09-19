package com.ahmete.service;

import com.ahmete.entity.Stadium;
import com.ahmete.repository.ICrud;
import com.ahmete.repository.PlayerRepository;
import com.ahmete.repository.StadiumRepository;

public class StadiumService extends ServiceManager<Stadium, Long> {
	private final StadiumRepository stadiumRepository;
	
	public StadiumService() {
		this(new StadiumRepository());
	}
	
	public StadiumService(StadiumRepository stadiumRepository) {
		super(stadiumRepository);
		this.stadiumRepository = stadiumRepository;
	}
}