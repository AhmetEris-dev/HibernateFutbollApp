package com.ahmete.service;

import com.ahmete.dto.request.ManagerLoginRequestDTO;
import com.ahmete.dto.request.ManagerSaveRequestDto;
import com.ahmete.dto.response.ManagerResponseDto;
import com.ahmete.entity.Manager;
import com.ahmete.entity.Team;
import com.ahmete.repository.ICrud;
import com.ahmete.repository.ManagerRepository;
import com.ahmete.repository.TeamRepository;

import java.util.Optional;

public class ManagerService extends ServiceManager<Manager,Long> {
	private final ManagerRepository managerRepository;
	private final TeamService teamService;
	public ManagerService() {
		this(new ManagerRepository());
	}
	
	public ManagerService( ManagerRepository managerRepository) {
		super(managerRepository);
		this.managerRepository = managerRepository;
		this.teamService = new TeamService();
	}
	
	public Optional<ManagerResponseDto> save(ManagerSaveRequestDto dto){
		Manager manager;
		Optional<Manager> managerOptional;
		ManagerResponseDto managerResponseDto = new ManagerResponseDto();
		
		try {
			Optional<Team> teamOptional = teamService.findTeamIdByName(dto.getTeamName());
			if(teamOptional.isPresent()) {
				manager = new Manager();
				manager.setManagerName(dto.getManagerName());
				manager.setManagerSurname(dto.getManagerSurname());
				manager.setManagerPassword(dto.getManagerPassword());
				manager.setDateOfBirth(dto.getDateOfBirth());
				manager.setTeamID(teamOptional.get().getId());
				managerOptional = Optional.of(managerRepository.save(manager));
				
				managerResponseDto.setManagerName(managerOptional.get().getManagerName());
				managerResponseDto.setManagerSurname(managerOptional.get().getManagerSurname());
				managerResponseDto.setDateOfBirth(managerOptional.get().getDateOfBirth());
				managerResponseDto.setTeamName(teamOptional.get().getTeamName());
				System.out.println(managerOptional.get().getManagerName() + " " +managerOptional.get().getManagerSurname() + " başarıyla kaydedildi");
				return Optional.of(managerResponseDto);
			}
		}
		catch (Exception e) {
			System.out.println("Service : Manager kaydedilirken hata oluştu "+ e.getMessage());
		}
		return Optional.of(managerResponseDto);
	}
	public Optional<Manager> findManagerUserNameAndPassword(ManagerLoginRequestDTO dto){
		return managerRepository.findManagerUserNameAndPassword(dto);
	}
	
	public Optional<Long> findTeamIdByManagerId(Long managerId){
		return managerRepository.findTeamIdByManagerId(managerId);
	}
	
	public Optional<Manager> findByTeamId(Long secilenTakimID) {
		return managerRepository.findByTeamId(secilenTakimID);
	}
}