package com.ahmete;

import com.ahmete.entity.BaseEntity;
import com.ahmete.entity.League;
import com.ahmete.entity.Player;
import com.ahmete.repository.LeagueRepository;
import com.ahmete.repository.PlayerRepository;
import com.ahmete.service.LeagueService;
import com.ahmete.service.PlayerService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Runner {
	public static void main(String[] args) {
		LeagueService leagueService = new LeagueService();
		PlayerService playerService = new PlayerService();
//		leagueService.save(League.builder().leagueName("youtube").build());
		playerService.save(Player.builder().name("Alper").birthday(LocalDate.of(1996,12,7)).build());
		
	}
}