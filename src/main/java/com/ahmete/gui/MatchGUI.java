package com.ahmete.gui;

import com.ahmete.model.ControllerModel;
import com.ahmete.repository.TeamRepository;
import com.ahmete.utility.FixtureFunction.FixtureGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MatchGUI {
	private static ControllerModel controllerModel=ControllerModel.getInstance();
	private static final Scanner scanner = new Scanner(System.in);
	private static TeamRepository teamRepository = new TeamRepository();

	
	
	public static void matchGui(ControllerModel cModel) {
		
		controllerModel = cModel;
		
		int opt;
		do {
			opt = musabakaMenu();
			musabakaMenuOpsiyonlari(opt);
		} while (opt != 0);
	}
	
	
	private static int musabakaMenu() {
		System.out.println("-----Match Menu-------");
		System.out.println("1-Fiksturu Goruntule");
		System.out.println("2-Puan tablosunu Goruntule");
		System.out.println("0-Cıkıs Yap");
		System.out.print("Seciminiz");
		int opt = scanner.nextInt();
		scanner.nextLine();
		return opt;
		
	}
	
	private static int musabakaMenuOpsiyonlari(int opt) {
		switch (opt) {
			case 1: {
				 createFixture();
				break;
			}
			case 2: {
				createPointTable();
				break;
			}
			case 0: {
				System.out.println("Ana menuye dönülüyor...");
			}
			default:
				System.out.println("lütfen gecerli bir secim yapınız");
		}
		
		return opt;
	}
	
	public static void createFixture(){
		FixtureGenerator fixtureGenerator = fixtureData();
		fixtureGenerator.generateFikstur();
		fixtureGenerator.fiksturuYazdir();
	}
	
	
	public static void createPointTable(){
		FixtureGenerator fixtureGenerator = fixtureData();
		fixtureGenerator.generateFikstur();
		fixtureGenerator.puanTablosunuGuncelle();
		fixtureGenerator.puanTablosunuYazdir();
		
	}
	
	private static FixtureGenerator fixtureData() {
		List<Long> takimIDleri = teamRepository.findAllTeamIds();
		Map<Long, String> takimIDtoName = teamRepository.findAllTeamIdToName();
		FixtureGenerator fixtureGenerator =new FixtureGenerator(takimIDleri, LocalDate.of(2024, 10, 8),
		                                                        takimIDtoName);
		return fixtureGenerator;
	}
	
}