package com.ahmete.utility.FixtureFunction;

import com.ahmete.entity.Fixture;
import com.ahmete.entity.League;
import com.ahmete.entity.Match;
import com.ahmete.entity.Statistics;
import com.ahmete.repository.FixtureRepository;
import com.ahmete.repository.LeagueRepository;
import com.ahmete.repository.MatchRepository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class FixtureGenerator {
	
	private List<Long> takimIDleri;
	private List<DayOfWeek> gunler;
	private static Map<Integer, List<Match>> fikstur = new HashMap<>();
	private LocalDate sezonBaslangic;
	private Map<Long, String> takimIDtoName;
	private Map<Long, Statistics> takimIstatistikleri = new HashMap<>();
	private static   FixtureRepository fixtureRepository;
	private static   MatchRepository matchRepository;
	
	
	public  FixtureGenerator(List<Long> takimIDleri, LocalDate sezonBaslangic, Map<Long, String> takimIDtoName) {
		this.takimIDleri = takimIDleri;
		this.sezonBaslangic = sezonBaslangic;
		this.takimIDtoName = takimIDtoName;
		this.gunler = Arrays.asList(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY, DayOfWeek.MONDAY);
		initializeIstatistikler();
		this.fixtureRepository = new FixtureRepository();
		this.matchRepository = new MatchRepository();

	}
	
	private void initializeIstatistikler() {
		for (Long takimID : takimIDleri) {
			takimIstatistikleri.put(takimID, new Statistics());
		}
	}
	
	public void generateFikstur() {
		int takimSayisi = takimIDleri.size();
		boolean tekMi = takimSayisi % 2 != 0;
		
		if (tekMi) {
			takimIDleri.add(-1L); // BAY haftası için takım ekleniyor
			takimSayisi++;
		}
		
		LocalDate seasonStartDate = LocalDate.now();  // Sezon başlangıç tarihi
		int totalWeeks = (takimSayisi - 1) * 2;  // Toplam hafta sayısı (ilk yarı + ikinci yarı)
		LocalDate seasonEndDate = seasonStartDate.plusWeeks(totalWeeks);  // Sezon bitiş tarihi
		
		// Fixture entity'si oluşturuluyor ve kaydediliyor
		Fixture fixture = Fixture.builder()
		                         .leagueID(1L)  // İlgili ligin ID'sini gir
		                         .startDate(seasonStartDate)
		                         .endDate(seasonEndDate)
		                         .matchIDs(new ArrayList<>()) // Boş bir liste başlat
		                         .build();
		fixtureRepository.save(fixture); // İlk kaydetme
		
		// İlk yarı
		for (int hafta = 0; hafta < takimSayisi - 1; hafta++) {
			List<Match> matchList = new ArrayList<>();
			
			for (int i = 0; i < takimSayisi / 2; i++) {
				Long homeTeam, awayTeam;
				
				if (hafta % 2 == 0) {
					homeTeam = takimIDleri.get(i);
					awayTeam = takimIDleri.get(takimSayisi - 1 - i);
				} else {
					homeTeam = takimIDleri.get(takimSayisi - 1 - i);
					awayTeam = takimIDleri.get(i);
				}
				
				if (homeTeam != -1 && awayTeam != -1) { // BAY hafta kontrolü
					Match match = new Match(homeTeam, awayTeam, takimIDtoName);
					match.setMatchDate(calculateMatchDate(hafta)); // Maç tarihi atanıyor
					match.setLeagueID(fixture.getLeagueID()); // Lig ID'si set ediliyor
					match.setStadiumID(1L); // Stadyum ID'si eklenebilir (örnek olarak 1L verdim)
					
					matchRepository.save(match); // Her maçı kaydet
					matchList.add(match);
					
					// Fixture'daki matchIDs listesine match ID'sini ekle
					fixture.getMatchIDs().add(match.getId());
				}
			}
			
			// Fikstüre haftalık maçlar ekleniyor
			fikstur.put(hafta + 1, matchList);
			// Takımların sırası değiştirilerek rotasyon sağlanıyor
			takimIDleri.add(1, takimIDleri.remove(takimIDleri.size() - 1));
		}
		
		// İkinci yarı (takımlar tersine çevrilmiş şekilde oynar)
		for (int hafta = 0; hafta < takimSayisi - 1; hafta++) {
			List<Match> matchList = new ArrayList<>();
			
			for (int i = 0; i < takimSayisi / 2; i++) {
				Long homeTeam, awayTeam;
				
				if (hafta % 2 == 0) {
					homeTeam = takimIDleri.get(takimSayisi - 1 - i);
					awayTeam = takimIDleri.get(i);
				} else {
					homeTeam = takimIDleri.get(i);
					awayTeam = takimIDleri.get(takimSayisi - 1 - i);
				}
				
				if (homeTeam != -1 && awayTeam != -1) { // BAY hafta kontrolü
					Match match = new Match(homeTeam, awayTeam, takimIDtoName);
					match.setMatchDate(calculateMatchDate(hafta + takimSayisi)); // Maç tarihi atanıyor
					match.setLeagueID(fixture.getLeagueID()); // Lig ID'si set ediliyor
					match.setStadiumID(1L); // Stadyum ID'si eklenebilir
					
					matchRepository.save(match); // Her maçı kaydet
					matchList.add(match);
					
					// Fixture'daki matchIDs listesine match ID'sini ekle
					fixture.getMatchIDs().add(match.getId());
				}
			}
			
			// Fikstüre haftalık maçlar ekleniyor
			fikstur.put(hafta + takimSayisi, matchList);
			// Takımların sırası değiştirilerek rotasyon sağlanıyor
			takimIDleri.add(1, takimIDleri.remove(takimIDleri.size() - 1));
		}
		
		// Maç tarihlerini güncelleme fonksiyonu
		gunleriAta();
	}
	
	// Haftaya göre maç tarihi hesaplama fonksiyonu
	private LocalDate calculateMatchDate(int hafta) {
		LocalDate startDate = LocalDate.now(); // Başlangıç tarihini belirleyebilirsiniz
		return startDate.plusWeeks(hafta); // Her hafta bir hafta ekleniyor
	}
	
	
	private void gunleriAta() {
		Random random = new Random();
		for (int hafta = 1; hafta <= fikstur.size(); hafta++) {
			List<Match> matches = fikstur.get(hafta);
			Collections.shuffle(matches);
			for (Match match : matches) {
				DayOfWeek gun = gunler.get(random.nextInt(gunler.size()));
				LocalDate matchDate = sezonBaslangic.plusWeeks(hafta - 1).with(gun);
				match.setMatchDate(matchDate);
			}
			matches.sort(Comparator.comparing(Match::getMatchDate));
		}
	}
	
	public void puanTablosunuGuncelle() {
		Random random = new Random();
		for (List<Match> matchList : fikstur.values()) {
			for (Match match : matchList) {
				int homeGoal = random.nextInt(5);
				int awayGoal = random.nextInt(5);
				
				Long homeTeam = match.getHomeTeamID();
				Long awayTeam = match.getAwayTeamID();
				
				if (homeGoal > awayGoal) {
					takimIstatistikleri.get(homeTeam).addWin();
					takimIstatistikleri.get(awayTeam).addLoss();
				}
				else if (awayGoal > homeGoal) {
					takimIstatistikleri.get(awayTeam).addWin();
					takimIstatistikleri.get(homeTeam).addLoss();
				}
				else {
					takimIstatistikleri.get(homeTeam).addDraw();
					takimIstatistikleri.get(awayTeam).addDraw();
				}
				
				takimIstatistikleri.get(homeTeam).addGoals(homeGoal, awayGoal);
				takimIstatistikleri.get(awayTeam).addGoals(awayGoal, homeGoal);
			}
		}
	}
	
	public void puanTablosunuYazdir() {
		System.out.println("Puan Tablosu:");
		System.out.printf("%-20s %-3s %-3s %-3s %-3s %-3s %-3s %-3s%n", "Takım İsmi", "G", "B", "M", "AG", "YG", "AV",
		                  "Puan");
		
		takimIstatistikleri.entrySet().stream().sorted((e1, e2) -> {
			int puanKarsilastirma = Integer.compare(e2.getValue().getPoints(), e1.getValue().getPoints());
			if (puanKarsilastirma != 0) {
				return puanKarsilastirma;
			}
			
			return Integer.compare(e2.getValue().getGoalDifference(), e1.getValue().getGoalDifference());
		}).forEach(entry -> {
			String takimIsmi = takimIDtoName.get(entry.getKey());
			Statistics statistics = entry.getValue();
			System.out.printf("%-20s %-3d %-3d %-3d %-3d %-3d %-3d %-3d%n", takimIsmi, statistics.getWins(),
			                  statistics.getDraws(), statistics.getLosses(), statistics.getGoalsScored(),
			                  statistics.getGoalsConceded(), statistics.getGoalDifference(), statistics.getPoints());
		});
	}
	
	public void fiksturuYazdir() {
		for (Map.Entry<Integer, List<Match>> entry : fikstur.entrySet()) {
			Integer hafta = entry.getKey();
			List<Match> matchList = entry.getValue();
			System.out.println("Hafta: " + hafta);
			for (Match match : matchList) {
				System.out.println(match.toStringFikstur());
			}
			System.out.println();
		}
		
	}
	
	
}