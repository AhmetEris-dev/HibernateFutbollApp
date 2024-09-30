package com.ahmete.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblmanager")
public class Manager extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="team_id")
	private Long teamID;
	@Column(name="managername")
	private String managerName;
	@Column(name="managersurname")
	private String managerSurname;
	@Column(name="managerpassword")
	private String managerPassword;
	@Column(name="dateofbirth")
	private LocalDate dateOfBirth;
	@Column(name="username")
	private String userName;
	
}