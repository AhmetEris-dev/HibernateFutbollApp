package com.ahmete;

import com.ahmete.gui.MainGUI;
import com.ahmete.model.ControllerModel;
import com.ahmete.repository.*;
import com.ahmete.utility.DataGenerator;
import com.ahmete.utility.FixtureFunction.FixtureGenerator;

import java.time.LocalDate;
import java.util.*;


public class Runner {
	public static void main(String[] args) {
		ControllerModel controllerModel = ControllerModel.getInstance();
		TeamRepository teamRepository = new TeamRepository();
		DataGenerator dataGenerator = new DataGenerator();
//		dataGenerator.createGenerateData();

//		MainGUI.startApplication();
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
		
		new ContractOfferRepository().findByReceiverTeamID(takimIDleri.get(0));
	
	}
	
}