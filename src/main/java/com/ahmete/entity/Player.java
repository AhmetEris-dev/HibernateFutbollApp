package com.ahmete.entity;

import com.ahmete.enums.EPosition;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;



@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblplayer")
public class Player extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="team_id")
	private Long teamID;
	private String name;
	private String surname;
	@Temporal(TemporalType.DATE)
	private LocalDate birthday;
	@Column(name="contractfee")
	private Long contractFee;
	@Enumerated(EnumType.STRING)
	private EPosition position;
	
	
	
}