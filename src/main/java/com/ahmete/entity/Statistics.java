package com.ahmete.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblstatistics")
public class Statistics extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="goalsscored")
	private Integer goalsScored = 0;
	@Column(name="goalsconceded")
	private Integer goalsConceded = 0;
	private Integer wins = 0; // Başlangıç değeri
	private Integer losses = 0; // Başlangıç değeri
	private Integer draws = 0; // Başlangıç değeri
	
	public void addWin() {
		wins++;
	}
	
	
	public int getGoalDifference() {
		return goalsScored - goalsConceded;
	}
	
	
	public void addDraw() {
		this.draws++;
	}
	
	public void addLoss() {
		this.losses++;
	}
	
	public void addGoals(int scored, int conceded) {
		this.goalsScored += scored;
		this.goalsConceded += conceded;
	}
	
	public int getPoints() {
		return (wins * 3) + (draws * 1);
	}
}