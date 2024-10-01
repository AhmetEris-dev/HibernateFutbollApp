//package com.ahmete.gui;
//
//import com.ahmete.entity.Manager;
//import com.ahmete.entity.TransferOffer;
//import com.ahmete.model.ControllerModel;
//import com.ahmete.repository.ContractOfferRepository;
//import com.ahmete.repository.PlayerRepository;
//import com.ahmete.repository.TransferOfferRepository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Scanner;
//
//public class ContractOfferGUI {
//	private static ControllerModel controllerModel=ControllerModel.getInstance();
//	private static Optional<Manager> activeManager=Optional.empty();
//	private static final PlayerRepository playerRepository=new PlayerRepository();
//	private static final ContractOfferRepository contractOfferRepository=new ContractOfferRepository();
//	private static final TransferOfferRepository transferOfferRepository=new TransferOfferRepository();
//	private static final Scanner scanner=new Scanner(System.in);
//
//	public static void contractGui(ControllerModel cModel,Optional<Manager> manager){
//		controllerModel=cModel;
//		activeManager=manager;
//
//		int opt;
//		do {
//			opt=contractIslemleriMenusu();
//		}while(opt !=0);
//	}
//
//	private static int contractIslemleriMenusu() {
//		System.out.println("---Sözleşme İşlemleri Menusu---");
//		System.out.println("1-Gelen teklifleri görüntüle");
//		System.out.println("2-Oyuncunun kararını öğren");
//		System.out.println("3-Takımın kararını öğren");
//		int secim= scanner.nextInt();scanner.nextLine();
//
//		switch (secim){
//			case 1:{
//				gelenTeklifleriGoruntule();
//			}
//		}
//
//	}
//
//	private static void gelenTeklifleriGoruntule() {
//		contractOfferRepository.findByReceiverTeamID()
//
//
//	}
//}