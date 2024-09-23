package com.ahmete.gui;

import com.ahmete.entity.Manager;
import com.ahmete.entity.Player;
import com.ahmete.model.ControllerModel;
import com.ahmete.model.TeamModel;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ManagerGUI {
	private static ControllerModel controllerModel;
	private static Optional<Manager> activeManager = Optional.empty();  // aktif menajer bilgisini burada tutuyoruz
	private static final Scanner scanner = new Scanner(System.in);

	public static void menajerModule(ControllerModel cModel) {
		controllerModel = cModel;

		int opt;
		do {


			opt =menajerGirisMenuOpsiyonlari(menajerGirisMenu());
		} while (opt != 0);
	}

	private static Optional<Manager> girisYap() {

		while (true) {
			System.out.println("lütfen menajer ID giriniz");
			Long id = scanner.nextLong();
			scanner.nextLine();
			System.out.println("lütfen menajer sifrenizi giriniz");
			String sifre = scanner.nextLine();
			Optional<Manager> menager = controllerModel.managerController.findManagerByIdAndPassword(id, sifre);

			if (menager.isPresent()) {
				activeManager = menager;
				System.out.println("başarılı bir şekilde giriş yaptınız");
				return menager;
			}
			else {
				System.out.println("giriş yapılamadı.Lütfen tekrar deneyiniz");
			}

		}
	}

	private static int menajerGirisMenu() {
		System.out.println("-----Menajer Giris Menu-----");
		System.out.println("1-Giris Yap");
		System.out.println("0-Geri dön");
		System.out.print("seciminiz: ");
		int opt = scanner.nextInt();
		scanner.nextLine();
		return opt;
	}

	private static int menajerGirisMenuOpsiyonlari(int opt) {
		switch (opt) {
			case 1: {
				girisYap();
				menajerMenuOpsiyonlari(menajerMenu());
				break;
			}
			case 2: {
				System.out.println("Ana menuye donuluyor");
				break;
			}
			case 0: {
				System.out.println("0--Ust menuye donuluyor ");
				break;
			}
		}
		return opt;

	}

	private static int menajerMenu() {

		System.out.println("-----Menajer Menu-----");
		System.out.println("1-Takimimin detaylarını goruntuleyin");
		System.out.println("2-Takimimin futbolcularımı goruntuleyin");
		System.out.println("3-Diğer takimlarin özet bilgilerini goruntuleyin");
		System.out.println("0-Cıkıs yap");
		System.out.print("seciminiz: ");
		int opt = scanner.nextInt();
		scanner.nextLine();
		return opt;
	}

	private static int menajerMenuOpsiyonlari(int opt) {
		switch (opt) {
			case 1: {
				kulubumunDetaylariniGoruntule();
				menajerMenuOpsiyonlari( menajerMenu());
				break;
			}
			case 2: {
				kulubumunFutbolculariniGoruntule();
				menajerMenuOpsiyonlari( menajerMenu());
				break;
			}
			case 3: {
				takimlerinOzetBilgileriniGoruntule();
				takimIdyeGoreFutbolcularOzetBilgi();
				menajerMenuOpsiyonlari( menajerMenu());
				break;
			}
			case 0: {
				System.out.println("Ust menuye donuluyor");
			}
			default:
				System.out.println("Geçerli bir seçim yapınız!!");
		}
		return opt;
	}

	private static void takimIdyeGoreFutbolcularOzetBilgi() {

		System.out.println("Futbolcularini goruntulemek istediginiz takimi seciniz:");
		Long teamID = scanner.nextLong();
		scanner.nextLine();
		List<Player> playerList = controllerModel.playerController.findPlayerByTeamID(teamID);
		playerList.forEach(player -> System.out.println(player.toStringOzet()));
	}

	private static void takimlerinOzetBilgileriniGoruntule() {
		TeamModel teamModel=new TeamModel();
		teamModel.takimlerinOzetBilgileriniGoruntule();
	}

	private static void kulubumunDetaylariniGoruntule() {

		if (activeManager.isEmpty()) {
			System.out.println("lütfen giriş yapınız");
		}
		controllerModel.managerController.findTeamIdByManagerId(activeManager.get().getTeamID());
	}

	private static void kulubumunFutbolculariniGoruntule() {


		if (activeManager.isEmpty()) {
			System.out.println("lütfen giriş yapınız");
		}
		List<Player> takiminFutbolculari = controllerModel.playerController.findPlayerByTeamID(activeManager.get().getTeamID());
		takiminFutbolculari.forEach(System.out::println);
	}
}