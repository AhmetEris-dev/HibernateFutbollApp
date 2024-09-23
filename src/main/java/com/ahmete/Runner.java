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
import com.ahmete.model.ControllerModel;
import com.ahmete.model.TeamModel;
import com.ahmete.repository.LeagueRepository;
import com.ahmete.repository.ManagerRepository;
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
	ControllerModel controllerModel =  ControllerModel.getInstance();
		DataGenerator dataGenerator = new DataGenerator();
//		dataGenerator.createGenerateData();


//		MainGUI.startApplication();
		
	}
	
}