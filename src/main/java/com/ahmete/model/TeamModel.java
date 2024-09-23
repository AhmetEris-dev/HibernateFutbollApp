package com.ahmete.model;

import com.ahmete.entity.Team;
import com.ahmete.enums.EColours;


import java.util.List;

public class TeamModel {
	private final ControllerModel controllerModel=ControllerModel.getInstance();
	
	private Long id;
	private Long stadiumID;
	private String teamName;
	private String presidentName;
	private String foundationDate;
	private EColours colour;
	
	public TeamModel() {
	}
	
	//! Alperen hocaya sor , bu metotun yeri doğrumu
	
	public void takimlerinOzetBilgileriniGoruntule() {
		List<Team> teamList = controllerModel.teamController.findAll();
		
		if (teamList.isEmpty()) {
			System.out.println("Veritabanında takım bulunamadı.");
		} else {
			System.out.println("----- Takımların Özet Bilgileri -----");
			teamList.forEach(team -> {
				System.out.println("Takım ID: " + team.getId());
				System.out.println("Takım Adı: " + team.getTeamName());
				System.out.println("Kuruluş Yılı: " + team.getFoundationDate());
				System.out.println("----------------------------");
			});
		}
	}
}