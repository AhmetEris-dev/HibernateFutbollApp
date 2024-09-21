package com.ahmete.controller;

import com.ahmete.entity.League;
import com.ahmete.service.ICrudService;
import com.ahmete.service.LeagueService;

import java.util.List;
import java.util.Optional;

public class LeagueController {
	private final LeagueService leagueService;
	
	public LeagueController(LeagueService leagueService) {
		this.leagueService = leagueService;
	}
	
	public League save(League league) {
		try {
			System.out.println("Controller League başarıyla kaydedildi.");
			return leagueService.save(league);
			
		} catch (Exception e) {
			System.out.println("Controller League kaydedilirken hata oluştu: " + e.getMessage());
		}
		return league;
	}
	
	public Iterable<League> saveAll(List<League> leagueList) {
		try {
			System.out.println("Controller League başarıyla kaydedildi.");
			return leagueService.saveAll(leagueList);
			
		} catch (Exception e) {
			System.out.println("Controller League kaydedilirken hata oluştu: " + e.getMessage());
		}
		return leagueList;
	}
	
	public Boolean deleteByID(Long longid) {
		try {
			Boolean isDeleted = leagueService.deleteById(longid);
			if (isDeleted) {
				System.out.println("Controller: League başarıyla silindi.");
				return true;
			}else {
				System.out.println("Controller: League silinemedi.");
				return false;
			}
		}
		catch (Exception e) {
			System.out.println("Controller: League silinirken hata oldu: " + e.getMessage());
			return false;
		}
	}
	
	public Optional<League> findById(Long longid) {
		Optional<League> userOptional = leagueService.findById(longid);
		return userOptional;
	}
	
	public Boolean existById(Long longid){
		try {
			Boolean isExistById = leagueService.existById(longid);
			if (isExistById) {
				System.out.println("Controller: League başarıyla bulundu");
				return true;
			}else {
				System.out.println("Controller: League bulunamadı.");
				return false;
			}
		}
		catch (Exception e) {
			System.out.println("Controller: League bulunurken hata oldu: "+e.getMessage());
			return false;
		}
	}
	
	public List<League> findAll() {
		List<League> userList = leagueService.findAll();
		if (userList.isEmpty()) {
			System.out.println("Controller Veritabanında kayıtlı League bulunmamaktadır.");
		}
		return userList;
	}
	
}