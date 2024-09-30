package com.ahmete;

import com.ahmete.controller.*;
import com.ahmete.dto.request.*;
import com.ahmete.dto.response.*;
import com.ahmete.entity.*;
import com.ahmete.enums.ECluster;
import com.ahmete.enums.EColours;
import com.ahmete.enums.EPosition;
import com.ahmete.enums.ERegion;
import com.ahmete.gui.MainGUI;
import com.ahmete.gui.MatchGUI;
import com.ahmete.gui.TransferGUI;
import com.ahmete.model.ControllerModel;
import com.ahmete.model.TeamModel;
import com.ahmete.repository.*;
import com.ahmete.service.LeagueService;
import com.ahmete.service.PlayerService;
import com.ahmete.utility.DataGenerator;
import com.ahmete.utility.FixtureFunction.FixtureGenerator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class Runner {
	public static void main(String[] args) {
		ControllerModel controllerModel = ControllerModel.getInstance();
		TeamRepository teamRepository = new TeamRepository();
		DataGenerator dataGenerator = new DataGenerator();
//		dataGenerator.createGenerateData();

		MainGUI.startApplication();
//		MatchGUI.createFixture();

//		MatchGUI.fiksturuYazdir();
		
		List<Long> takimIDleri = teamRepository.findAllTeamIds();
		FixtureGenerator fixtureGenerator =new FixtureGenerator(takimIDleri, LocalDate.of(2024, 10, 8));
		
//		fixtureGenerator.makeMatch();
//		fixtureGenerator.printLeagueTable();
//		for (EPosition position:EPosition.values()){
//			System.out.println(position.ordinal()+1+" - "+position.name());
//		}
		
//		TransferGUI.oyuncuSec();
//		TransferGUI.oyuncuAra();
//		TransferGUI.teklifYap();
	
	}
	
}