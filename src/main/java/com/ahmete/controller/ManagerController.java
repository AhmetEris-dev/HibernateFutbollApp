package com.ahmete.controller;

import com.ahmete.dto.request.ManagerSaveRequestDto;
import com.ahmete.dto.response.ManagerResponseDto;
import com.ahmete.entity.League;
import com.ahmete.entity.Manager;
import com.ahmete.service.ICrudService;
import com.ahmete.service.ManagerService;
import com.ahmete.service.MatchService;

import java.util.List;
import java.util.Optional;

public class ManagerController {
	private final ManagerService managerService;
	
	public ManagerController() {
		this.managerService = new ManagerService();
	}
	
	public Optional<ManagerResponseDto> save(ManagerSaveRequestDto dto) {
		try {
			System.out.println("Controller Manager başarıyla kaydedildi.");
			return managerService.save(dto);
			
		} catch (Exception e) {
			System.out.println("Controller Manager kaydedilirken hata oluştu: " + e.getMessage());
		}
		return Optional.empty();
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
	public Optional<Manager> findManagerByIdAndPassword(Long id, String password){
		return managerService.findManagerByIdAndPassword(id, password);
	}
	
	public Optional<Long> findTeamIdByManagerId(Long managerId){
		return managerService.findTeamIdByManagerId(managerId);
	}
}