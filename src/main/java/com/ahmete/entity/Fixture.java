package com.ahmete.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tblfixture")
public class Fixture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="league_id")
	private Long leagueID;
	@ElementCollection
	@Column(name="match_ids")
	private List<Long> matchIDs;
	@Temporal(TemporalType.DATE)
	@Column(name="startdate")
	private LocalDate startDate;
	@Temporal(TemporalType.DATE)
	@Column(name="enddate")
	private LocalDate endDate;
}