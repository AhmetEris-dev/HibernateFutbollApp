package com.ahmete.gui;

import com.ahmete.entity.Manager;
import com.ahmete.entity.Player;
import com.ahmete.entity.TransferOffer;
import com.ahmete.enums.EOfferResponse;
import com.ahmete.enums.EPosition;
import com.ahmete.model.ControllerModel;
import com.ahmete.repository.PlayerRepository;
import com.ahmete.repository.TransferOfferRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TransferOfferGUI {
	private static ControllerModel controllerModel = ControllerModel.getInstance();
	private static Optional<Manager> activeManager = Optional.empty();
	private static final PlayerRepository playerRepository = new PlayerRepository();
	private static final Scanner scanner = new Scanner(System.in);
	private static final TransferOfferRepository transferOfferRepository = new TransferOfferRepository();
	
	public static void transferGui(ControllerModel cModel, Optional<Manager> aManager) {
		controllerModel = cModel;
		activeManager=aManager;
		
		int opt;
		do {
			opt = oyuncuIslemleriMenusu();
			oyuncuIslemleriMenuSecenekleri(opt);
		} while (opt != 0);
	}
	
	//TODO CASE 4 YAPILACAK VE GELEN TEKLİFLER UZERİNDE İŞLEM GERCEKLEŞECEK
	private static int oyuncuIslemleriMenusu() {
		System.out.println("---Oyuncu İşlemleri Menusu---");
		System.out.println("1-Mevkiye göre oyuncu Ara");
		System.out.println("2-Oyuncu için teklif yap");
		System.out.println("3-Oyuncu Sec");
		System.out.println("4-Takımıma gelen teklifleri goruntule");
		System.out.println("5-Takımıma gelen tekliflere dönüş yap");
		System.out.println("0-Ana menuye dön");
		int opt = scanner.nextInt();
		scanner.nextLine();
		return opt;
		
	}
	
	private static int oyuncuIslemleriMenuSecenekleri(int opt) {
		
		if (activeManager.isEmpty()) {
			System.out.println("Aktif bir menajer yok. Lütfen önce menajer olarak giriş yapın.");
			return 0;
		}
		List<TransferOffer> transferOfferList =
				controllerModel.transferOfferController.futbolcuIcinYapilanTeklifler(activeManager.get());
		switch (opt) {
			case 1: {
				oyuncuAra();
				break;
			}
			case 2: {
				teklifYap();
				break;
			}
			case 3: {
				oyuncuSec();
				break;
			}
			case 4: {
				gelenOyuncuTeklifleriGoruntule();
				break;
			}
			case 5: {
				teklifeGeriDonusYap();
				break;
			}
			case 0: {
				System.out.println("Bir üst menuye donuluyor");
				return 0;
			}
			default: {
				System.out.println("Geçersiz bir seçim yaptınız.");
			}
		}
		return transferOfferList.size();
	}
	
	private static void gelenOyuncuTeklifleriGoruntule() {
		if (activeManager.isEmpty()) {
			System.out.println("Aktif bir menajer bulunmamaktadır");
			return;
		}
		Long teamID = activeManager.get().getTeamID();
		List<TransferOffer> offerList = transferOfferRepository.findAll().stream()
		                                                  .filter(transferOffer -> transferOffer.getReceiverTeamID()
		                                                                                        .equals(teamID))
		                                                  .toList();
		if (offerList.isEmpty()) {
			System.out.println("Takımınıza yapılmış teklif bulunmamaktadır");
			return;
		}
		
		System.out.println("Takımınıza gelen teklifler: ");
		for (TransferOffer offer: offerList) {
			Player player = playerRepository.findById(offer.getPlayerID()).orElse(null);
			String playerName = player != null ? player.getName() + " " + player.getSurname() : "Bilinmeyen Oyuncu";
			
			System.out.println("Oyuncu: " + playerName);
			System.out.println("Teklif veren Takım ID: " + offer.getOfferingTeamID());
			System.out.println("Teklif Miktar: "+ offer.getOfferMoney()+" €");
			System.out.println("Teklif Durumu: "+ offer.getResponse());
			System.out.println("------------------------------------------------");
		}
	}
	
	public static void teklifYap() {
		Optional<Player> playerOptional = oyuncuSec();
		if (playerOptional.isPresent()) {
			Player player = playerOptional.get();
			System.out.print("Teklif miktarini giriniz: ");
			Long offerMoney=scanner.nextLong();scanner.nextLine();
			
			TransferOffer transferOffer=TransferOffer.builder()
			                                         .message("Oyuncu için teklif")
					.offerMoney(offerMoney)
					.managerID(activeManager.get().getId())
					.offeringTeamID(activeManager.get().getTeamID())
					.receiverTeamID(player.getTeamID())
					.playerID(player.getId())
					.response(EOfferResponse.ON_HOLD)
					.build();
			controllerModel.transferOfferController.save(transferOffer);
			System.out.println("Teklifiniz başarıyla gercekleştirildi: "+player.getName()+" için "+offerMoney+" € ");
		}
	}
	
	public static void teklifeGeriDonusYap(){
		if (activeManager.isEmpty()) {
			System.out.println("Aktif bir menajer bulunmamaktadır ");
			return;
		}
		Long teamID = activeManager.get().getTeamID();
		List<TransferOffer> offerList = transferOfferRepository.findAll().stream()
		                                                       .filter(transferOffer -> transferOffer.getReceiverTeamID()
		                                                                                             .equals(teamID))
		                                                       .toList();
		if (offerList.isEmpty()) {
			System.out.println("Takımınıza yapılmış teklif bulunmamaktadır.");
			return;
		}
		
		System.out.println("Gelen teklifler: ");
		for (int i = 0; i < offerList.size(); i++) {
			Player player = playerRepository.findById(offerList.get(i).getPlayerID()).orElse(null);
			String playerName = player != null ? player.getName() + " " + player.getSurname() : "Bilinmeyen Oyuncu";
			System.out.println((i+1) +" - "+ playerName + " için "+ offerList.get(i).getOfferMoney()+" € teklif");
		}
		System.out.print("Cevap vermek istediğiniz teklifi numarasına göre seciniz: ");
		int secim= scanner.nextInt();scanner.nextLine();
		if (secim<0||secim>=offerList.size()) {
			System.out.println("Gecersiz secim yaptınız...");
			return;
		}
		TransferOffer transferOffer = offerList.get(secim - 1);
		System.out.println("1-Teklifi kabul et");
		System.out.println("2-Teklifi reddet");
		int geriDonusSecimi=scanner.nextInt();scanner.nextLine();
		
		switch (geriDonusSecimi){
			case 1:{
				transferOffer.setResponse(EOfferResponse.ACCEPT);
				System.out.println("Teklif kabul edildi.");
				break;
			}
			case 2:{
				transferOffer.setResponse(EOfferResponse.REFUSE);
				System.out.println("Teklif reddedildi.");
				break;
			}
			default:{
				System.out.println("Gecersiz secim");
				return;
			}
		}
		transferOfferRepository.update(transferOffer);
		System.out.println("İşleminiz başarıyla gercekleştirildi");
	}
	
	public static Optional<Player> oyuncuSec() {
		System.out.println("Oyuncuları goruntulemek için mevki seciniz");
		oyuncuAra();
		
		System.out.print("Bir oyuncu secmek için numara giriniz: ");
		int secim = scanner.nextInt();
		scanner.nextLine();
		
		if (secim < 0 || secim >= playerRepository.findAll().size()) {
			System.out.println("Gecersiz bir secim yaptınız lutfen gecerli bir oyuncu numarası giriniz!!!");
		}
		Player secilenPlayer = playerRepository.findAll().get(secim-1);
		System.out.println("Secilen oyuncu: " + secilenPlayer.getName()+" "+secilenPlayer.getSurname());
		return Optional.of(secilenPlayer);
	}
	
	public static void oyuncuAra() {
		System.out.println("Aramak istediğiniz oyuncu mevkisini giriniz: ");
		for (EPosition position : EPosition.values()) {
			System.out.println(position.ordinal() + 1 + " - " + position.name());
		}
		System.out.print("Seçiminiz: ");
		int secim = scanner.nextInt();
		scanner.nextLine();
		
		List<Player> filteredPlayers;
		
		switch (secim) {
			case 1: {
				filteredPlayers = playerRepository.findAll().stream()
				                                  .filter(player -> player.getPosition().equals(EPosition.GOALKEEPER))
				                                  .toList();
				
				break;
			}
			case 2: {
				filteredPlayers = playerRepository.findAll().stream()
				                                  .filter(player -> player.getPosition().equals(EPosition.DEFENCE))
				                                  .toList();
				break;
			}
			case 3: {
				filteredPlayers = playerRepository.findAll().stream()
				                                  .filter(player -> player.getPosition().equals(EPosition.MIDFIELD))
				                                  .toList();
				break;
			}
			case 4: {
				filteredPlayers = playerRepository.findAll().stream()
				                                  .filter(player -> player.getPosition().equals(EPosition.OFFENCE))
				                                  .toList();
				break;
			}
			default: {
				System.out.println("Geçersiz seçim.");
				return;
			}
		}
		
		for (Player player:filteredPlayers) {
			System.out.println(player.getId()+ " - " + player.getName() + " - "+player.getSurname()+" - " +player.getContractFee()+ " - " + player.getPosition());
		}
		
		
	}
}