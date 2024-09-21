package com.ahmete.controller;

import com.ahmete.entity.League;
import com.ahmete.entity.Match;
import com.ahmete.service.MatchService;

import java.util.List;
import java.util.Optional;

public class MatchController {
	private final MatchService matchService;
	
	public MatchController(MatchService matchService) {
		this.matchService = matchService;
	}
	
	public Match save(Match match) {
		try {
			System.out.println("Controller Match başarıyla kaydedildi.");
			return matchService.save(match);
			
		} catch (Exception e) {
			System.out.println("Controller Match kaydedilirken hata oluştu: " + e.getMessage());
		}
		return match;
	}
	
	public Iterable<Match> saveAll(List<Match> matchList) {
		try {
			System.out.println("Controller Match başarıyla kaydedildi.");
			return matchService.saveAll(matchList);
			
		} catch (Exception e) {
			System.out.println("Controller Match kaydedilirken hata oluştu: " + e.getMessage());
		}
		return matchList;
	}
	
	public Boolean deleteByID(Long longid) {
		try {
			Boolean isDeleted = matchService.deleteById(longid);
			if (isDeleted) {
				System.out.println("Controller: Match başarıyla silindi.");
				return true;
			}else {
				System.out.println("Controller: Match silinemedi.");
				return false;
			}
		}
		catch (Exception e) {
			System.out.println("Controller: Match silinirken hata oldu: " + e.getMessage());
			return false;
		}
	}
	
	public Optional<Match> findById(Long longid) {
		Optional<Match> matchOptional = matchService.findById(longid);
		return matchOptional;
	}
	
	public Boolean existById(Long longid){
		try {
			Boolean isExistById = matchService.existById(longid);
			if (isExistById) {
				System.out.println("Controller: Match başarıyla bulundu");
				return true;
			}else {
				System.out.println("Controller: Match bulunamadı.");
				return false;
			}
		}
		catch (Exception e) {
			System.out.println("Controller: Match bulunurken hata oldu: "+e.getMessage());
			return false;
		}
	}
	
	public List<Match> findAll() {
		List<Match> matchList = matchService.findAll();
		if (matchList.isEmpty()) {
			System.out.println("Controller Veritabanında kayıtlı Match bulunmamaktadır.");
		}
		return matchList;
	}
}