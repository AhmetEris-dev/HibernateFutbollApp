package com.ahmete.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblfixture")
public class Fixture extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="league_id")
	private Long leagueID;
	@Temporal(TemporalType.DATE)
	@Column(name="startdate")
	private LocalDate startDate;
	@Temporal(TemporalType.DATE)
	@Column(name="enddate")
	private LocalDate endDate;
	
	
}