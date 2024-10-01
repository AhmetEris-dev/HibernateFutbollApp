//package com.ahmete.gui;
//
//import com.ahmete.entity.ContractOffer;
//import com.ahmete.entity.Manager;
//import com.ahmete.entity.Player;
//import com.ahmete.entity.TransferOffer;
//import com.ahmete.enums.EOfferResponse;
//import com.ahmete.model.ControllerModel;
//import com.ahmete.repository.ContractOfferRepository;
//import com.ahmete.repository.ManagerRepository;
//import com.ahmete.repository.PlayerRepository;
//import com.ahmete.repository.TransferOfferRepository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Random;
//import java.util.Scanner;
//
//public class ContractOfferGUI {
//	private static ControllerModel controllerModel=ControllerModel.getInstance();
//	private static Optional<Manager> activeManager=Optional.empty();
//	private static final ManagerRepository managerRepository=new ManagerRepository();
//	private static final PlayerRepository playerRepository=new PlayerRepository();
//	private static final ContractOfferRepository contractOfferRepository=new ContractOfferRepository();
//	private static final TransferOfferRepository transferOfferRepository=new TransferOfferRepository();
//	private static final Scanner scanner=new Scanner(System.in);
//	private static final Random random=new Random();
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
//				break;
//			}
//			case 2:
//				oyuncuKarari();
//				break;
//		}
//return secim;
//	}
//
//	private static void oyuncuKarari() {
//
////		List<ContractOffer> offers = contractOfferRepository.findByTransferOfferID(activeManager.get().getTeamID());
//
//
//		if (offers.isEmpty()) {
//			System.out.println("Henüz bir teklif bulunmamaktadır.");
//			return;
//		}
//		System.out.println("Oyuncu kararını öğrenmek istediğiniz teklifi secin: ");
//		for (int i = 0; i < offers.size(); i++) {
//			Player player = playerRepository.findById(offers.get(i).getPlayerID()).orElse(null);
//			String playerName = player != null ? player.getName() + " " + player.getSurname() : "Bilinmeyen Oyuncu";
//			System.out.println((i + 1) + " - " + playerName + " için " + offers.get(i).getOfferMoney() + " € teklif");
//		}
//		int secim = scanner.nextInt(); scanner.nextLine();
//
//		if (secim < 1 || secim > offers.size()) {
//			System.out.println("Geçersiz seçim.");
//			return;
//		}
//		ContractOffer contractOffer = offers.get(secim - 1);
//		Player player = playerRepository.findById(contractOffer.getPlayerID()).orElse(null);
//		int karar=random.nextInt(3)+1;
//		if (karar==1){
//			System.out.println(player.getName()+" sözleşmeyi kabul etti");
//			contractOffer.setOfferResponse(EOfferResponse.ACCEPT);
//			contractOffer.setContractDecision(true);
//			player.setTeamID(contractOffer.getTransferOfferID());
//			contractOfferRepository.update(contractOffer);
//			playerRepository.update(player);
//			System.out.println("Sözleşme başarıyla gercekleşti,Oyuncunun yeni takımı: "+contractOffer.getTransferOfferID());
//		}else if(karar==2){
//			System.out.println(player.getName()+" sözleşmeyi reddetti.");
//			contractOffer.setOfferResponse(EOfferResponse.REFUSE);
//			contractOffer.setContractDecision(false);
//			contractOfferRepository.update(contractOffer);
//		}else {
//			System.out.println(player.getName()+" Oyuncu kararsız olduğunu belirtti");
//		}
//	}
//
//	private static void gelenTeklifleriGoruntule() {
//
//		if (!activeManager.isPresent()){
//			System.out.println("aktif menajer bulunmamaktadır");
//			return;
//		}
//
//		List<TransferOffer> offers =
//				transferOfferRepository.findByReceiverTeamID(activeManager.get().getTeamID());
//
//		if (offers.isEmpty()){
//			System.out.println("Henüz bir teklif bulunmamaktadır.");
//			return;
//		}
//		for (int i = 0; i < offers.size(); i++) {
//			Player player = controllerModel.playerController.findById(offers.get(i).getPlayerID()).orElse(null);
//			String playerName = (player != null) ? player.getName() + " " + player.getSurname() : "Bilinmeyen Oyuncu";
//			System.out.println((i + 1) + " - " + playerName + " için " + offers.get(i).getOfferMoney() + " € teklif");
//		}
//	}
//}