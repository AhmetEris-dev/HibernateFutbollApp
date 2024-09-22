package com.ahmete;

import com.ahmete.controller.*;
import com.ahmete.dto.request.*;
import com.ahmete.dto.response.*;
import com.ahmete.entity.BaseEntity;
import com.ahmete.entity.League;
import com.ahmete.entity.Player;
import com.ahmete.entity.Team;
import com.ahmete.enums.ECluster;
import com.ahmete.enums.EColours;
import com.ahmete.enums.EPosition;
import com.ahmete.enums.ERegion;
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
		
		PlayerController playerController = new PlayerController();
		ManagerController managerController = new ManagerController();
		StadiumController stadiumController = new StadiumController();
		TeamController teamController = new TeamController();
		LeagueController leagueController = new LeagueController();
		DataGenerator dataGenerator = new DataGenerator();
		
		dataGenerator.createGenerateData();


//
//      PlayerSaveRequestDto dto = new PlayerSaveRequestDto("Fenerbahçe", "Ahmet", "Güler", LocalDate.of(1995,5,15), EPosition.MIDFIELD);
//		Optional<PlayerResponseDto> responseDto = playerController.save(dto);
//
//		ManagerSaveRequestDto dto1 = new ManagerSaveRequestDto("Galatasaray","Kemal","Özogli","12345",LocalDate.of(1997,5,18));
//		Optional<ManagerResponseDto> managerResponseDto = managerController.save(dto1);
//		System.out.println(managerResponseDto);
//
//
//		StadiumSaveRequestDto dto2 = new StadiumSaveRequestDto("Ali Samiyen","İstanbul",50000);
//		Optional<StadiumResponseDto> stadiumResponseDto = stadiumController.save(dto2);
//		System.out.println(stadiumResponseDto);
//
//		TeamSaveRequestDto dto3 = new TeamSaveRequestDto("Ali Samiyen", "Alper Spor", "Alper Güler", "2005", EColours.BLACK_RED);
//		Optional<TeamResponseDto> teamResponseDto = teamController.save(dto3);
//		System.out.println(teamResponseDto);
//
//		LeagueSaveRequestDto
//				dto4 = new LeagueSaveRequestDto("Mehtor League", "Season 25", ECluster.TRENDYOL_SUPER_LIG, ERegion.TURKEY, LocalDate.of(2025, 3, 10));
//		Optional<LeagueResponseDto> leagueResponseDto = leagueController.save(dto4);
//		System.out.println(leagueResponseDto);

	}
	
}