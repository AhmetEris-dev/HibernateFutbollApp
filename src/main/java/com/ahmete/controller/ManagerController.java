package com.ahmete.controller;

import com.ahmete.entity.League;
import com.ahmete.entity.Manager;
import com.ahmete.service.ICrudService;
import com.ahmete.service.ManagerService;
import com.ahmete.service.MatchService;

import java.util.List;
import java.util.Optional;

public class ManagerController {
	private final ManagerService managerService;
	
	public ManagerController(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	public Manager save(Manager manager) {
		try {
			System.out.println("Controller Manager başarıyla kaydedildi.");
			return managerService.save(manager);
			
		} catch (Exception e) {
			System.out.println("Controller Manager kaydedilirken hata oluştu: " + e.getMessage());
		}
		return manager;
	}
	
	public Iterable<Manager> saveAll(List<Manager> managerList) {
		try {
			System.out.println("Controller Manager başarıyla kaydedildi.");
			return managerService.saveAll(managerList);
			
		} catch (Exception e) {
			System.out.println("Controller Manager kaydedilirken hata oluştu: " + e.getMessage());
		}
		return managerList;
	}
	
	public Boolean deleteByID(Long longid) {
		try {
			Boolean isDeleted = managerService.deleteById(longid);
			if (isDeleted) {
				System.out.println("Controller: Manager başarıyla silindi.");
				return true;
			}else {
				System.out.println("Controller: Manager silinemedi.");
				return false;
			}
		}
		catch (Exception e) {
			System.out.println("Controller: Manager silinirken hata oldu: " + e.getMessage());
			return false;
		}
	}
	
	public Optional<Manager> findById(Long longid) {
		Optional<Manager> managerOptional = managerService.findById(longid);
		return managerOptional;
	}
	
	public Boolean existById(Long longid){
		try {
			Boolean isExistById = managerService.existById(longid);
			if (isExistById) {
				System.out.println("Controller: Manager başarıyla bulundu");
				return true;
			}else {
				System.out.println("Controller: Manager bulunamadı.");
				return false;
			}
		}
		catch (Exception e) {
			System.out.println("Controller: Manager bulunurken hata oldu: "+e.getMessage());
			return false;
		}
	}
	
	public List<Manager> findAll() {
		List<Manager> managerList = managerService.findAll();
		if (managerList.isEmpty()) {
			System.out.println("Controller Veritabanında kayıtlı Manager bulunmamaktadır.");
		}
		return managerList;
	}
}