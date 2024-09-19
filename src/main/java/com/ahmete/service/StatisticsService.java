package com.ahmete.service;

import com.ahmete.entity.Statistics;
import com.ahmete.repository.ICrud;
import com.ahmete.repository.StatisticsRepository;

public class StatisticsService extends ServiceManager<Statistics,Long> {
	private final StatisticsRepository statisticsRepository;
	
	public StatisticsService() {
		this(new StatisticsRepository());
	}
	
	public StatisticsService( StatisticsRepository statisticsRepository) {
		super(statisticsRepository);
		this.statisticsRepository = statisticsRepository;
	}
}