package com.ahmete.controller;

import com.ahmete.entity.League;
import com.ahmete.entity.Stadium;
import com.ahmete.service.StadiumService;

import java.util.List;
import java.util.Optional;

public class StadiumController {
	private final StadiumService stadiumService;
	
	public StadiumController(StadiumService stadiumService) {
		this.stadiumService = stadiumService;
	}
	
	public Stadium save(Stadium stadium) {
		try {
			System.out.println("Controller Stadium başarıyla kaydedildi.");
			return stadiumService.save(stadium);
			
		} catch (Exception e) {
			System.out.println("Controller Stadium kaydedilirken hata oluştu: " + e.getMessage());
		}
		return stadium;
	}
	
	public Iterable<Stadium> saveAll(List<Stadium> stadiumList) {
		try {
			System.out.println("Controller Stadium başarıyla kaydedildi.");
			return stadiumService.saveAll(stadiumList);
			
		} catch (Exception e) {
			System.out.println("Controller Stadium kaydedilirken hata oluştu: " + e.getMessage());
		}
		return stadiumList;
	}
	
	public Boolean deleteByID(Long longid) {
		try {
			Boolean isDeleted = stadiumService.deleteById(longid);
			if (isDeleted) {
				System.out.println("Controller: Stadium başarıyla silindi.");
				return true;
			}else {
				System.out.println("Controller: Stadium silinemedi.");
				return false;
			}
		}
		catch (Exception e) {
			System.out.println("Controller: Stadium silinirken hata oldu: " + e.getMessage());
			return false;
		}
	}
	
	public Optional<Stadium> findById(Long longid) {
		Optional<Stadium> stadiumOptional = stadiumService.findById(longid);
		return stadiumOptional;
	}
	
	public Boolean existById(Long longid){
		try {
			Boolean isExistById = stadiumService.existById(longid);
			if (isExistById) {
				System.out.println("Controller: Stadium başarıyla bulundu");
				return true;
			}else {
				System.out.println("Controller: Stadium bulunamadı.");
				return false;
			}
		}
		catch (Exception e) {
			System.out.println("Controller: Stadium bulunurken hata oldu: "+e.getMessage());
			return false;
		}
	}
	
	public List<Stadium> findAll() {
		List<Stadium> stadiumList = stadiumService.findAll();
		if (stadiumList.isEmpty()) {
			System.out.println("Controller Veritabanında kayıtlı Stadium bulunmamaktadır.");
		}
		return stadiumList;
	}
}