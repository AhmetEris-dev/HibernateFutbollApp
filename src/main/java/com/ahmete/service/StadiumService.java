package com.ahmete.service;

import com.ahmete.dto.request.StadiumSaveRequestDto;
import com.ahmete.dto.response.StadiumResponseDto;
import com.ahmete.entity.Stadium;
import com.ahmete.repository.ICrud;
import com.ahmete.repository.PlayerRepository;
import com.ahmete.repository.StadiumRepository;

import java.util.Optional;

public class StadiumService extends ServiceManager<Stadium, Long> {
	private final StadiumRepository stadiumRepository;
	
	public StadiumService() {
		this(new StadiumRepository());
	}
	
	public StadiumService(StadiumRepository stadiumRepository) {
		super(stadiumRepository);
		this.stadiumRepository = stadiumRepository;
	}
	
	public Optional<StadiumResponseDto> save(StadiumSaveRequestDto dto){
		Stadium stadium = new Stadium() ;
		Optional<Stadium> stadiumOptional;
		StadiumResponseDto stadiumResponseDto = new StadiumResponseDto();
		
		try {
			stadium.setStadiumName(dto.getStadiumName());
			stadium.setCapacity(dto.getCapacity());
			stadium.setLocation(dto.getLocation());
			stadiumOptional = Optional.of(stadiumRepository.save(stadium));
			
			stadiumResponseDto.setStadiumName(stadiumOptional.get().getStadiumName());
			stadiumResponseDto.setCapacity(stadiumOptional.get().getCapacity());
			stadiumResponseDto.setLocation(stadiumOptional.get().getLocation());
			System.out.println(stadium.getStadiumName()+ " stadyumu başarıyla kaydedildi.");
			return Optional.of(stadiumResponseDto);
		}
		catch (Exception e) {
			System.out.println("Service : stadyum kaydedilirken hata oluştu. " + e.getMessage());
		}
		return Optional.of(stadiumResponseDto);
	}
	
	public Optional<Stadium> findStadiumIdByName(String stadiumName){
		return stadiumRepository.findStadiumIdByName(stadiumName);
	}
}