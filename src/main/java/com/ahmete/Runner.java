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
import com.ahmete.gui.MainGUI;
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
import java.util.List;
import java.util.Optional;


public class Runner {
	public static void main(String[] args) {
		
		PlayerController playerController = new PlayerController();
		ManagerController managerController = new ManagerController();
		StadiumController stadiumController = new StadiumController();
		TeamController teamController = new TeamController();
		LeagueController leagueController = new LeagueController();
		DataGenerator dataGenerator = new DataGenerator();
		
//		dataGenerator.createGenerateData();
		
//		MainGUI.startApplication();
		
		PlayerRepository playerRepository = new PlayerRepository();
		TeamRepository teamRepository = new TeamRepository();
		
//		List<Player> playerByTeamID = playerController.findPlayerByTeamID(3L);
//		playerByTeamID.forEach(System.out::println);
		
		List<Team> teamList = teamRepository.ListAllByNameContainsValue("galaTasaRay");
		teamList.forEach(System.out::println);
		
		
	}
	
}