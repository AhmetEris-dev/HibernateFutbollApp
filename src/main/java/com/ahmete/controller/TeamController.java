package com.ahmete.controller;

import com.ahmete.entity.League;
import com.ahmete.entity.Team;
import com.ahmete.service.TeamService;

import java.util.List;
import java.util.Optional;

public class TeamController {
	private final TeamService teamService;
	
	public TeamController(TeamService teamService) {
		this.teamService = teamService;
	}
	
	public Team save(Team team) {
		try {
			System.out.println("Controller Team başarıyla kaydedildi.");
			return teamService.save(team);
			
		} catch (Exception e) {
			System.out.println("Controller Team kaydedilirken hata oluştu: " + e.getMessage());
		}
		return team;
	}
	
	public Iterable<Team> saveAll(List<Team> teamList) {
		try {
			System.out.println("Controller Team başarıyla kaydedildi.");
			return teamService.saveAll(teamList);
			
		} catch (Exception e) {
			System.out.println("Controller Team kaydedilirken hata oluştu: " + e.getMessage());
		}
		return teamList;
	}
	
	public Boolean deleteByID(Long longid) {
		try {
			Boolean isDeleted = teamService.deleteById(longid);
			if (isDeleted) {
				System.out.println("Controller: Team başarıyla silindi.");
				return true;
			}else {
				System.out.println("Controller: Team silinemedi.");
				return false;
			}
		}
		catch (Exception e) {
			System.out.println("Controller: Team silinirken hata oldu: " + e.getMessage());
			return false;
		}
	}
	
	public Optional<Team> findById(Long longid) {
		Optional<Team> teamOptional = teamService.findById(longid);
		return teamOptional;
	}
	
	public Boolean existById(Long longid){
		try {
			Boolean isExistById = teamService.existById(longid);
			if (isExistById) {
				System.out.println("Controller: Team başarıyla bulundu");
				return true;
			}else {
				System.out.println("Controller: Team bulunamadı.");
				return false;
			}
		}
		catch (Exception e) {
			System.out.println("Controller: Team bulunurken hata oldu: "+e.getMessage());
			return false;
		}
	}
	
	public List<Team> findAll() {
		List<Team> teamList = teamService.findAll();
		if (teamList.isEmpty()) {
			System.out.println("Controller Veritabanında kayıtlı Team bulunmamaktadır.");
		}
		return teamList;
	}
}