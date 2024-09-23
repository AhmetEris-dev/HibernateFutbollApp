package com.ahmete.gui;

import com.ahmete.controller.PlayerController;
import com.ahmete.controller.TeamController;
import com.ahmete.entity.Player;
import com.ahmete.entity.Team;
import com.ahmete.model.ControllerModel;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TeamGUI {
	private static ControllerModel controllerModel;
	private static final Scanner scanner = new Scanner(System.in);

	public static void teamGui(ControllerModel cModel) {
       controllerModel = cModel;
		int opt;
		do {
			opt = takimModelMenu();
			takimModelMenuOpsiyonlari(opt);
		} while (opt != 0);
	}

	private static int takimModelMenu() {
		System.out.println("-----Takim Menu-----");
		System.out.println("1-Isme göre takım ara");
		System.out.println("2-Takimlari listele");
		System.out.println("0-Çıkış");
		System.out.print("Seçiminiz: ");
		int opt = scanner.nextInt();
		scanner.nextLine();
		return opt;
	}

	private static void takimModelMenuOpsiyonlari(int opt) {

		switch (opt) {
			case 1: {
				System.out.println("Lütfen bir takım ismi giriniz: ");
				String arananTakim = scanner.nextLine();
				List<Team> teamList = controllerModel.teamController.ListAllByNameContainsValue(arananTakim);

				if (teamList.isEmpty()) {
					System.out.println("Takım Bulunamadı!");
					return;
				}
				else {
					System.out.println("Bulunan Takımlar:");
					for (Team team : teamList) {
						System.out.println("ID: " + team.getId() + ", İsim: " + team.getTeamName());
					}

					int detaySecim = takimDetayMenu();
					takimDetayMenuSecenekleri(detaySecim, teamList);
				}
				break;
			}

			case 2: {
				System.out.println("#### Takımlar Listesi ####");
				List<Team> teamList = controllerModel.teamController.findAll();
				teamList.forEach(team -> System.out.println("ID: " + team.getId() + ", İsim: " + team.getTeamName()));

				int detaySecim = takimDetayMenu();
				takimDetayMenuSecenekleri(detaySecim, teamList);
				break;
			}
			case 0: {
				System.out.println("Ana menüye dönülüyor :)");
				break;
			}
			default:
				System.out.println("Lütfen geçerli bir seçim yapınız!!");
		}
	}

	private static int takimDetayMenu() {
		System.out.println("-----Takım Detay Menu-----");
		System.out.println("1- Takım Detaylarını Görüntüle");
		System.out.println("2- Takım Kadrosunu Görüntüle");
		System.out.println("0- Takım Menü'ye dön");
		System.out.print("Seçiminiz: ");
		int opt = scanner.nextInt();
		scanner.nextLine();
		return opt;
	}

	private static void takimDetayMenuSecenekleri(int opt, List<Team> teamList) {

		switch (opt) {
			case 1: {
				if (teamList.size() == 1) {
					Team team = teamList.getFirst();
					System.out.println(team);
				}
				else {
					Long teamID = idAl();
					Optional<Team> team = controllerModel.teamController.findById(teamID);
					if (team.isPresent()) {
						System.out.println(team.get());
					}
					else {
						System.out.println("Geçersiz ID. Tekrar deneyin.");

					}
				}
				break;
			}
			case 2: {
				if (teamList.size() == 1) {
					Long teamID = teamList.get(0).getId();
					List<Player> playerList = controllerModel.playerController.findPlayerByTeamID(teamID);
					if (playerList.isEmpty()) {
						System.out.println("Bu takımın kadrosu bulunamadı!");
					}
					else {
						playerList.forEach(System.out::println);
					}
				}
				else {
					Long teamID = idAl();
					List<Player> playerList = controllerModel.playerController.findPlayerByTeamID(teamID);
					if (playerList.isEmpty()) {
						System.out.println("Bu takımın kadrosu bulunamadı!");
					}
					else {
						playerList.forEach(System.out::println);
					}
				}
				break;
			}
			case 0: {
				break;
			}
			default:
				System.out.println("Geçerli bir seçim yapınız.");
		}

	}


	private static Long idAl() {
		System.out.println("Bir takim seciniz(id no ile): ");
		Long teamID = scanner.nextLong();
		return teamID;
	}


}