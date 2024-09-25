package com.ahmete.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Map;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblmatch")
public class Match extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="league_id")
	private Long leagueID;
	@Column(name="hometeam_id")
	private Long homeTeamID;
	@Column(name="awayteam_id")
	private Long awayTeamID;
	@Column(name="stadium_id")
	private Long stadiumID;
	@Column(name="hometeamscore")
	private Integer homeTeamScore;
	@Column(name="awayteamscore")
	private Integer awayTeamScore;
	@Column(name="refereename")
	private String refereeName; // hakem
	@Temporal(TemporalType.DATE)
	@Column(name="matchdate")
	private LocalDate matchDate;
	@ElementCollection
	@Column(name="teamidtoname")
	private Map<Long, String> teamIDtoName;
	
	
	public Match(Long homeTeam, Long awayTeam, Map<Long, String> teamIDtoName) {
		 this.homeTeamID = homeTeam;
		 this.awayTeamID = awayTeam;
		 this.teamIDtoName = teamIDtoName;
	}
	
	public String toStringFikstur() {
		if (homeTeamID == -1 || awayTeamID == -1) {
			return "BAY VS BAY, Tarih: " + matchDate; // Bay durumunu belirt
		}
		return teamIDtoName.get(homeTeamID) + " VS " + teamIDtoName.get(awayTeamID) + ", Tarih: " + matchDate;
	}
}