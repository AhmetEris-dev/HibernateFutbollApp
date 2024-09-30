package com.ahmete.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblcontractoffer")
public class ContractOffer extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="offeredamount")
	private Long offeredAmount;
	@Column(name="player_id")
	private Long playerID;
	@Column(name="offeringteam_id")
	private Long offeringTeamID;
}