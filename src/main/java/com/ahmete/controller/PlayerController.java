package com.ahmete.controller;

import com.ahmete.dto.request.PlayerSaveRequestDto;
import com.ahmete.dto.response.PlayerResponseDto;
import com.ahmete.entity.League;
import com.ahmete.entity.Player;
import com.ahmete.service.PlayerService;

import java.util.List;
import java.util.Optional;

public class PlayerController {
	
	private final PlayerService playerService;
	
	public PlayerController() {
		this.playerService = new PlayerService();
	}
	
	public Optional<PlayerResponseDto> save(PlayerSaveRequestDto dto) {
		try {
			System.out.println("Controller Player başarıyla kaydedildi.");
			return playerService.save(dto);
			
		} catch (Exception e) {
			System.out.println("Controller Player kaydedilirken hata oluştu: " + e.getMessage());
		}
		return Optional.empty();
	}
	
	public Iterable<Player> saveAll(List<Player> playerList) {
		try {
			System.out.println("Controller Player başarıyla kaydedildi.");
			return playerService.saveAll(playerList);
			
		} catch (Exception e) {
			System.out.println("Controller Player kaydedilirken hata oluştu: " + e.getMessage());
		}
		return playerList;
	}
	
	public Boolean deleteByID(Long longid) {
		try {
			Boolean isDeleted = playerService.deleteById(longid);
			if (isDeleted) {
				System.out.println("Controller: Player başarıyla silindi.");
				return true;
			}else {
				System.out.println("Controller: Player silinemedi.");
				return false;
			}
		}
		catch (Exception e) {
			System.out.println("Controller: Player silinirken hata oldu: " + e.getMessage());
			return false;
		}
	}
	
	public Optional<Player> findById(Long longid) {
		Optional<Player> playerOptional = playerService.findById(longid);
		return playerOptional;
	}
	
	public Boolean existById(Long longid){
		try {
			Boolean isExistById = playerService.existById(longid);
			if (isExistById) {
				System.out.println("Controller: Player başarıyla bulundu");
				return true;
			}else {
				System.out.println("Controller: Player bulunamadı.");
				return false;
			}
		}
		catch (Exception e) {
			System.out.println("Controller: Player bulunurken hata oldu: "+e.getMessage());
			return false;
		}
	}
	
	public List<Player> findAll() {
		List<Player> playerList = playerService.findAll();
		if (playerList.isEmpty()) {
			System.out.println("Controller Veritabanında kayıtlı Player bulunmamaktadır.");
		}
		return playerList;
	}
	
	public List<Player> findPlayerByTeamID(Long teamID){
		return playerService.findPlayerByTeamID(teamID);
	}
}