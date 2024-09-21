package com.ahmete;

import com.ahmete.controller.LeagueController;
import com.ahmete.controller.PlayerController;
import com.ahmete.dto.request.PlayerSaveRequestDto;
import com.ahmete.dto.response.PlayerResponseDto;
import com.ahmete.entity.BaseEntity;
import com.ahmete.entity.League;
import com.ahmete.entity.Player;
import com.ahmete.entity.Team;
import com.ahmete.enums.EPosition;
import com.ahmete.repository.LeagueRepository;
import com.ahmete.repository.PlayerRepository;
import com.ahmete.repository.TeamRepository;
import com.ahmete.service.LeagueService;
import com.ahmete.service.PlayerService;
import com.ahmete.utility.DataGenerator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Optional;

public class Runner {
	public static void main(String[] args) {
		LeagueService leagueService = new LeagueService();
		PlayerService playerService = new PlayerService();
		TeamRepository teamRepository = new TeamRepository();
		PlayerController playerController = new PlayerController();
//		leagueService.save(League.builder().leagueName("youtube").build());
//		playerService.save(Player.builder().name("Alper").birthday(LocalDate.of(1996,12,7)).build());
//
//		LeagueController leagueController = new LeagueController(leagueService);
//		leagueController.save(League.builder().leagueName("trendingsportalşsjdlaksjd").build());
		
		DataGenerator dataGenerator = new DataGenerator();
//		dataGenerator.createGenerateData();
		PlayerSaveRequestDto dto =
				new PlayerSaveRequestDto("Galatasaray", "Anıl", "Özogli", LocalDate.of(1995, 5, 15),
				                         EPosition.GOALKEEPER);
		Optional<PlayerResponseDto> responseDto = playerController.save(dto);
		
	}
	
}