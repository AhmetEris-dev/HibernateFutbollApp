package com.ahmete.utility;

import com.ahmete.entity.*;
import com.ahmete.enums.ECluster;
import com.ahmete.enums.EColours;
import com.ahmete.enums.EPosition;
import com.ahmete.enums.ERegion;
import com.ahmete.repository.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class DataGenerator {
	PlayerRepository playerRepository;
	TeamRepository teamRepository;
	LeagueRepository leagueRepository;
	ManagerRepository managerRepository;
	StadiumRepository stadiumRepository;
	Random random = new Random();
	

	
	public DataGenerator() {
		this.playerRepository =new PlayerRepository();
		this.teamRepository =new TeamRepository();
		this.leagueRepository =new LeagueRepository();
		this.managerRepository =new ManagerRepository();
		this.stadiumRepository =new StadiumRepository();
	}
	
	public void createGenerateData() {
		createTeams();
		createPlayers();
		createManagers();
		createStadium();
		createLeague();
		
		
	}
	
	private void createPlayers() {
		// Galatasaray kadrosu için oyuncuları ekleyelim
		List<Player> players = new ArrayList<>();
		
		// Kaleciler
		players.add(Player.builder()
		                  .name("Fernando")
		                  .surname("Muslera")
		                  .birthday(LocalDate.of(1986, 6, 16))
		                  .position(EPosition.GOALKEEPER)
		                  .contractFee(1400000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Günay")
		                  .surname("Güvenç")
		                  .birthday(LocalDate.of(1991, 6, 25))
		                  .position(EPosition.GOALKEEPER)
		                  .contractFee(600000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Batuhan")
		                  .surname("Şen")
		                  .birthday(LocalDate.of(1999, 2, 3))
		                  .position(EPosition.GOALKEEPER)
		                  .contractFee(425000L)
		                  .teamID(1L)
		                  .build());
		
		// Defans oyuncuları
		players.add(Player.builder()
		                  .name("Davinson")
		                  .surname("Sánchez")
		                  .birthday(LocalDate.of(1996, 6, 12))
		                  .position(EPosition.DEFENCE)
		                  .contractFee(18000000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Victor")
		                  .surname("Nelsson")
		                  .birthday(LocalDate.of(1998, 10, 14))
		                  .position(EPosition.DEFENCE)
		                  .contractFee(17000000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Abdülkerim")
		                  .surname("Bardakcı")
		                  .birthday(LocalDate.of(1994, 9, 7))
		                  .position(EPosition.DEFENCE)
		                  .contractFee(9000000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Kaan")
		                  .surname("Ayhan")
		                  .birthday(LocalDate.of(1994, 11, 10))
		                  .position(EPosition.DEFENCE)
		                  .contractFee(4700000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Metehan")
		                  .surname("Baltacı")
		                  .birthday(LocalDate.of(2002, 11, 3))
		                  .position(EPosition.DEFENCE)
		                  .contractFee(1000000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Ali")
		                  .surname("Yeşilyurt")
		                  .birthday(LocalDate.of(2005, 7, 30))
		                  .position(EPosition.DEFENCE)
		                  .contractFee(75000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Ismail")
		                  .surname("Jakobs")
		                  .birthday(LocalDate.of(1999, 8, 17))
		                  .position(EPosition.DEFENCE)
		                  .contractFee(8000000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Elias")
		                  .surname("Jelert")
		                  .birthday(LocalDate.of(2003, 6, 12))
		                  .position(EPosition.DEFENCE)
		                  .contractFee(5500000L)
		                  .teamID(1L)
		                  .build());
		
		// Orta saha oyuncuları
		players.add(Player.builder()
		                  .name("Lucas")
		                  .surname("Torreira")
		                  .birthday(LocalDate.of(1996, 2, 11))
		                  .position(EPosition.MIDFIELD)
		                  .contractFee(15000000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Efe")
		                  .surname("Akman")
		                  .birthday(LocalDate.of(2006, 3, 20))
		                  .position(EPosition.MIDFIELD)
		                  .contractFee(500000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Gabriel")
		                  .surname("Sara")
		                  .birthday(LocalDate.of(1999, 6, 26))
		                  .position(EPosition.MIDFIELD)
		                  .contractFee(18000000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Kerem")
		                  .surname("Demirbay")
		                  .birthday(LocalDate.of(1993, 7, 3))
		                  .position(EPosition.MIDFIELD)
		                  .contractFee(4800000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Berkan")
		                  .surname("Kutlu")
		                  .birthday(LocalDate.of(1998, 1, 25))
		                  .position(EPosition.MIDFIELD)
		                  .contractFee(3800000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Eyüp")
		                  .surname("Aydın")
		                  .birthday(LocalDate.of(2004, 8, 2))
		                  .position(EPosition.MIDFIELD)
		                  .contractFee(1300000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Gökdeniz")
		                  .surname("Gürpüz")
		                  .birthday(LocalDate.of(2006, 2, 25))
		                  .position(EPosition.MIDFIELD)
		                  .contractFee(300000L)
		                  .teamID(1L)
		                  .build());
		
		// Forvet oyuncuları
		players.add(Player.builder()
		                  .name("Barış Alper")
		                  .surname("Yılmaz")
		                  .birthday(LocalDate.of(2000, 5, 23))
		                  .position(EPosition.OFFENCE)
		                  .contractFee(20000000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Roland")
		                  .surname("Sallai")
		                  .birthday(LocalDate.of(1997, 5, 22))
		                  .position(EPosition.OFFENCE)
		                  .contractFee(15000000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Hakim")
		                  .surname("Ziyech")
		                  .birthday(LocalDate.of(1993, 3, 19))
		                  .position(EPosition.OFFENCE)
		                  .contractFee(9000000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Yunus")
		                  .surname("Akgün")
		                  .birthday(LocalDate.of(2000, 7, 10))
		                  .position(EPosition.OFFENCE)
		                  .contractFee(5000000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Yusuf")
		                  .surname("Demir")
		                  .birthday(LocalDate.of(2003, 6, 2))
		                  .position(EPosition.OFFENCE)
		                  .contractFee(2700000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Dries")
		                  .surname("Mertens")
		                  .birthday(LocalDate.of(1987, 5, 6))
		                  .position(EPosition.OFFENCE)
		                  .contractFee(1800000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Mauro")
		                  .surname("Icardi")
		                  .birthday(LocalDate.of(1993, 2, 19))
		                  .position(EPosition.OFFENCE)
		                  .contractFee(17000000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Victor")
		                  .surname("Osimhen")
		                  .birthday(LocalDate.of(1998, 12, 29))
		                  .position(EPosition.OFFENCE)
		                  .contractFee(100000000L)
		                  .teamID(1L)
		                  .build());
		
		players.add(Player.builder()
		                  .name("Michy")
		                  .surname("Batshuayi")
		                  .birthday(LocalDate.of(1993, 10, 2))
		                  .position(EPosition.OFFENCE)
		                  .contractFee(8500000L)
		                  .teamID(1L)
		                  .build());
		
		// Tüm oyuncuları veritabanına kaydedelim
		for (Player player : players) {
			playerRepository.save(player);
		}
	}
	
	
	private void createManagers(){
		final String sifre = "12345678";
		
		managerRepository.save(Manager.builder()
		                              .teamID(1L)  // Takım ID'sini ayarlayın
		                              .managerName("Okan")
		                              .managerSurname("Buruk")
		                              .managerPassword(sifre)
		                              .dateOfBirth(LocalDate.of(1976, 6, 10))
		                              .build());
		
		managerRepository.save(Manager.builder()
		                              .teamID(2L)
		                              .managerName("Jorge")
		                              .managerSurname("Jesus")
		                              .managerPassword(sifre)
		                              .dateOfBirth(LocalDate.of(1955, 12, 24))
		                              .build());
		
		managerRepository.save(Manager.builder()
		                              .teamID(3L)
		                              .managerName("Şenol")
		                              .managerSurname("Güneş")
		                              .managerPassword(sifre)
		                              .dateOfBirth(LocalDate.of(1967, 3, 24))
		                              .build());
		
		managerRepository.save(Manager.builder()
		                              .teamID(4L)
		                              .managerName("Abdullah")
		                              .managerSurname("Avcı")
		                              .managerPassword(sifre)
		                              .dateOfBirth(LocalDate.of(1962, 10, 20))
		                              .build());
		
		managerRepository.save(Manager.builder()
		                              .teamID(5L)
		                              .managerName("Emre")
		                              .managerSurname("Belözoğlu")
		                              .managerPassword(sifre)
		                              .dateOfBirth(LocalDate.of(1981, 1, 4))
		                              .build());
		
		managerRepository.save(Manager.builder()
		                              .teamID(6L)
		                              .managerName("Bülent")
		                              .managerSurname("Korkmaz")
		                              .managerPassword(sifre)
		                              .dateOfBirth(LocalDate.of(1973, 3, 15))
		                              .build());
		
		managerRepository.save(Manager.builder()
		                              .teamID(7L)
		                              .managerName("Ersun")
		                              .managerSurname("Yanal")
		                              .managerPassword(sifre)
		                              .dateOfBirth(LocalDate.of(1964, 3, 23))
		                              .build());
		
		managerRepository.save(Manager.builder()
		                              .teamID(8L)
		                              .managerName("İlhan")
		                              .managerSurname("Palut")
		                              .managerPassword(sifre)
		                              .dateOfBirth(LocalDate.of(1974, 8, 16))
		                              .build());
		
		managerRepository.save(Manager.builder()
		                              .teamID(9L)
		                              .managerName("Rıza")
		                              .managerSurname("Çalımbay")
		                              .managerPassword(sifre)
		                              .dateOfBirth(LocalDate.of(1970, 11, 27))
		                              .build());
		
		managerRepository.save(Manager.builder()
		                              .teamID(10L)
		                              .managerName("Bülent")
		                              .managerSurname("Uygun")
		                              .managerPassword(sifre)
		                              .dateOfBirth(LocalDate.of(1968, 2, 28))
		                              .build());
		
		managerRepository.save(Manager.builder()
		                              .teamID(11L)
		                              .managerName("Erol")
		                              .managerSurname("Bulut")
		                              .managerPassword(sifre)
		                              .dateOfBirth(LocalDate.of(1978, 8, 15))
		                              .build());
		
		managerRepository.save(Manager.builder()
		                              .teamID(12L)
		                              .managerName("Emre")
		                              .managerSurname("Belözoğlu")
		                              .managerPassword(sifre)
		                              .dateOfBirth(LocalDate.of(1981, 1, 4))
		                              .build());
		
		managerRepository.save(Manager.builder()
		                              .teamID(13L)
		                              .managerName("Çağlar")
		                              .managerSurname("Karabıyık")
		                              .managerPassword(sifre)
		                              .dateOfBirth(LocalDate.of(1970, 4, 5))
		                              .build());
		
		managerRepository.save(Manager.builder()
		                              .teamID(14L)
		                              .managerName("Yılmaz")
		                              .managerSurname("Vural")
		                              .managerPassword(sifre)
		                              .dateOfBirth(LocalDate.of(1965, 8, 20))
		                              .build());
		
		managerRepository.save(Manager.builder()
		                              .teamID(15L)
		                              .managerName("Çağdaş")
		                              .managerSurname("Atan")
		                              .managerPassword(sifre)
		                              .dateOfBirth(LocalDate.of(1980, 10, 27))
		                              .build());
		
		managerRepository.save(Manager.builder()
		                              .teamID(16L)
		                              .managerName("İbrahim")
		                              .managerSurname("Üzülmez")
		                              .managerPassword(sifre)
		                              .dateOfBirth(LocalDate.of(1969, 6, 12))
		                              .build());
		
		managerRepository.save(Manager.builder()
		                              .teamID(17L)
		                              .managerName("Tamer")
		                              .managerSurname("Tuna")
		                              .managerPassword(sifre)
		                              .dateOfBirth(LocalDate.of(1970, 6, 1))
		                              .build());
		
		managerRepository.save(Manager.builder()
		                              .teamID(18L)
		                              .managerName("Yücel")
		                              .managerSurname("İldiz")
		                              .managerPassword(sifre)
		                              .dateOfBirth(LocalDate.of(1977, 2, 18))
		                              .build());
		
		managerRepository.save(Manager.builder()
		                              .teamID(19L)
		                              .managerName("İsmet")
		                              .managerSurname("Taşdemir")
		                              .managerPassword(sifre)
		                              .dateOfBirth(LocalDate.of(1974, 1, 21))
		                              .build());
	}
	
	private void createTeams() {
		teamRepository.save(Team.builder().teamName("Galatasaray").presidentName("Dursun Özbek")
		                        .colour(EColours.RED_YELLOW).stadiumID(1L).foundationDate("1905").build());
		teamRepository.save(Team.builder().teamName("Fenerbahçe").presidentName("Ali Koç")
		                        .colour(EColours.YELLOW_BLUE).stadiumID(2L).foundationDate("1907").build());
		teamRepository.save(Team.builder().teamName("Beşiktaş").presidentName("Hasan Arat")
		                        .colour(EColours.BLACK_WHITE).stadiumID(3L).foundationDate("1903").build());
		teamRepository.save(Team.builder().teamName("Trabzonspor").presidentName("Ahmet Ağaoğlu")
		                        .colour(EColours.BURGUNDY_BLUE).stadiumID(4L).foundationDate("1967")
		                        .build());
		teamRepository.save(Team.builder().teamName("Başakşehir").presidentName("Göksel Gümüşdağ")
		                        .colour(EColours.DOUBLE_RED).stadiumID(5L).foundationDate("2014").build());
		teamRepository.save(Team.builder().teamName("Alanyaspor").presidentName("Hasan Çavuşoğlı")
		                        .colour(EColours.ORANGE_BLUE).stadiumID(6L).foundationDate("1948").build());
		teamRepository.save(Team.builder().teamName("Antalyaspor").presidentName("Aziz Çetin")
		                        .colour(EColours.STRIPED_RED).stadiumID(7L).foundationDate("1966").build());
		teamRepository.save(Team.builder().teamName("Konyaspor").presidentName("Hilmi Kullukçu")
		                        .colour(EColours.GREEN_WHITE).stadiumID(8L).foundationDate("1922").build());
		teamRepository.save(Team.builder().teamName("Sivasspor").presidentName("Mecnun Otyakmaz")
		                        .colour(EColours.RED_WHITE).stadiumID(9L).foundationDate("1967").build());
		teamRepository.save(Team.builder().teamName("Çaykur Rizespor").presidentName("İbrahim Turgut")
		                        .colour(EColours.GREEN_BLUE).stadiumID(10L).foundationDate("1953").build());
		teamRepository.save(Team.builder().teamName("Gaziantep FK").presidentName("Adil Kürükçü")
		                        .colour(EColours.DOUBLE_RED).stadiumID(11L).foundationDate("1969").build());
		teamRepository.save(Team.builder().teamName("Adana Demirspor").presidentName("Murat Sancak")
		                        .colour(EColours.BURGUNDY_BLUE).stadiumID(12L).foundationDate("1940")
		                        .build());
		teamRepository.save(Team.builder().teamName("MKE Ankaragücü").presidentName("Fatih Mert")
		                        .colour(EColours.YELLOW_BLUE).stadiumID(13L).foundationDate("1910")
		                        .build());
		teamRepository.save(Team.builder().teamName("Gençlerbirliği").presidentName("Murat İlhancavcav")
		                        .colour(EColours.RED_BLACK).stadiumID(14L).foundationDate("1923").build());
		teamRepository.save(Team.builder().teamName("Kayserispor").presidentName("Berna Gözbaşı")
		                        .colour(EColours.RED_YELLOW).stadiumID(15L).foundationDate("1966").build());
		teamRepository.save(Team.builder().teamName("Yeni Malatyaspor").presidentName("Adil Gevrek")
		                        .colour(EColours.GREEN_BLACK).stadiumID(16L).foundationDate("1986")
		                        .build());
		teamRepository.save(Team.builder().teamName("Göztepe").presidentName("Mehmet Sepil")
		                        .colour(EColours.RED_YELLOW).stadiumID(17L).foundationDate("1925").build());
		teamRepository.save(Team.builder().teamName("Denizlispor").presidentName("Ali İpek")
		                        .colour(EColours.DOUBLE_RED).stadiumID(18L).foundationDate("1966").build());
		teamRepository.save(Team.builder().teamName("Bodrum FK").presidentName("Fikret Öztürk")
		                        .colour(EColours.GREEN_WHITE).stadiumID(19L).foundationDate("1931")
		                        .build());
		
		
	}
	

	
	private void createStadium() {
		
		Stadium galatasarayStadium = Stadium.builder().stadiumName("Türk Telekom Stadyumu").location("İstanbul").capacity(52500).build();
		stadiumRepository.save(galatasarayStadium);
		
		Stadium fenerbahceStadium = Stadium.builder().stadiumName("Ülker Stadyumu").location("İstanbul").capacity(50000).build();
		stadiumRepository.save(fenerbahceStadium);
		
		Stadium besiktasStadium = Stadium.builder().stadiumName("Vodafone Park").location("İstanbul").capacity(42000).build();
		stadiumRepository.save(besiktasStadium);
		
		Stadium trabzonsporStadium = Stadium.builder().stadiumName("Medical Park Stadyumu").location("Trabzon").capacity(41000).build();
		stadiumRepository.save(trabzonsporStadium);
		
		Stadium basaksehirStadium = Stadium.builder().stadiumName("Başakşehir Fatih Terim Stadyumu").location("İstanbul").capacity(17000).build();
		stadiumRepository.save(basaksehirStadium);
		
		Stadium alanyasporStadium = Stadium.builder().stadiumName("Alanya Oba Stadyumu").location("Alanya").capacity(10000).build();
		stadiumRepository.save(alanyasporStadium);
		
		Stadium antalyasporStadium = Stadium.builder().stadiumName("Antalya Stadyumu").location("Antalya").capacity(32000).build();
		stadiumRepository.save(antalyasporStadium);
		
		Stadium konyasporStadium = Stadium.builder().stadiumName("Konya Büyükşehir Stadyumu").location("Konya").capacity(42000).build();
		stadiumRepository.save(konyasporStadium);
		
		Stadium sivassporStadium = Stadium.builder().stadiumName("Sivas 4 Eylül Stadyumu").location("Sivas").capacity(27000).build();
		stadiumRepository.save(sivassporStadium);
		
		Stadium caykurRizesporStadium = Stadium.builder().stadiumName("Çaykur Didi Stadyumu").location("Rize").capacity(15000).build();
		stadiumRepository.save(caykurRizesporStadium);
		
		Stadium gaziantepFKStadium = Stadium.builder().stadiumName("Gaziantep Stadyumu").location("Gaziantep").capacity(35000).build();
		stadiumRepository.save(gaziantepFKStadium);
		
		Stadium adanaDemirsporStadium = Stadium.builder().stadiumName("Yeni Adana Stadyumu").location("Adana").capacity(33000).build();
		stadiumRepository.save(adanaDemirsporStadium);
		
		Stadium ankaragucuStadium = Stadium.builder().stadiumName("Eryaman Stadyumu").location("Ankara").capacity(20000).build();
		stadiumRepository.save(ankaragucuStadium);
		
		Stadium genclerbirligiStadium = Stadium.builder().stadiumName("On Dokuz Mayıs Stadyumu").location("Ankara").capacity(20000).build();
		stadiumRepository.save(genclerbirligiStadium);
		
		Stadium kayserisporStadium = Stadium.builder().stadiumName("Kadir Has Stadyumu").location("Kayseri").capacity(30000).build();
		stadiumRepository.save(kayserisporStadium);
		
		Stadium yeniMalatyasporStadium = Stadium.builder().stadiumName("Yeni Malatya Stadyumu").location("Malatya").capacity(25000).build();
		stadiumRepository.save(yeniMalatyasporStadium);
		
		Stadium goztepeStadium = Stadium.builder().stadiumName("Göztepe Gürsel Aksel Stadyumu").location("İzmir").capacity(20000).build();
		stadiumRepository.save(goztepeStadium);
		
		Stadium denizlisporStadium = Stadium.builder().stadiumName("Denizli Atatürk Stadyumu").location("Denizli").capacity(19000).build();
		stadiumRepository.save(denizlisporStadium);
		
		Stadium bodrumFKStadium = Stadium.builder().stadiumName("Bodrum İlçe Stadyumu").location("Bodrum").capacity(10000).build();
		stadiumRepository.save(bodrumFKStadium);
		
	}
	
	private void createLeague() {
		List<Team> teams = teamRepository.findAll();
		List<Long> teamIDList = teams.stream()
		                             .map(Team::getId)  // Takım ID'lerini al
		                             .collect(Collectors.toList());
		
	
		League league = League.builder()
		                      .leagueName("Trendyol Super Lig")
		                      .leagueSeason("2023/2024")
		                      .startDate(LocalDate.now())
		                      .region(ERegion.TURKEY) // Örnek olarak bir bölge
		                      .cluster(ECluster.TRENDYOL_SUPER_LIG) // Örnek olarak bir cluster
		                      .teamIDList(teamIDList)
		                      .build();
		
		leagueRepository.save(league);
	}
}