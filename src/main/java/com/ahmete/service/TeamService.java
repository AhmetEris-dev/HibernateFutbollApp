package com.ahmete.service;

import com.ahmete.dto.request.TeamSaveRequestDto;
import com.ahmete.dto.response.TeamResponseDto;
import com.ahmete.entity.Stadium;
import com.ahmete.entity.Team;
import com.ahmete.repository.ICrud;
import com.ahmete.repository.StadiumRepository;
import com.ahmete.repository.TeamRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;

public class TeamService extends ServiceManager<Team,Long>{
	private final TeamRepository teamRepository;
	private final StadiumService stadiumService;
	
	public TeamService() {
		this(new TeamRepository());
	}
	
	public TeamService(TeamRepository teamRepository) {
		super(teamRepository);
		this.teamRepository = teamRepository;
		this.stadiumService = new StadiumService();
	}
	
	public Optional<Team> findTeamIdByName(String teamName){
		return teamRepository.findTeamIdByName(teamName);
	}
	
	public Optional<TeamResponseDto> save(TeamSaveRequestDto dto){
		Team team;
		Optional<Team> teamOptional;
		TeamResponseDto teamResponseDto = new TeamResponseDto();
		
		try {
			Optional<Stadium> stadiumOptional =stadiumService.findStadiumIdByName(dto.getStadiumName());
			if (stadiumOptional.isPresent()) {
				team = new Team();
				team.setTeamName(dto.getTeamName());
				team.setPresidentName(dto.getPresidentName());
				team.setFoundationDate(dto.getFoundationDate());
				team.setColour(dto.getColour());
				team.setStadiumID(stadiumOptional.get().getId());
				teamOptional = Optional.of(teamRepository.save(team));
				
				teamResponseDto.setStadiumName(stadiumOptional.get().getStadiumName());
				teamResponseDto.setTeamName(teamOptional.get().getTeamName());
				teamResponseDto.setPresidentName(teamOptional.get().getPresidentName());
				teamResponseDto.setFoundationDate(teamOptional.get().getFoundationDate());
				teamResponseDto.setColour(teamOptional.get().getColour());
				System.out.println(teamOptional.get().getTeamName()+" takımı başarıyla kaydedildi.");
				return Optional.of(teamResponseDto);
			}
		}
		catch (Exception e) {
			System.out.println("Service: Team kaydedilirken hata oluştu."+ e.getMessage());
		}
		return Optional.of(teamResponseDto);
	}
	
	public List<Team> ListAllByNameContainsValue(String value){
		return teamRepository.ListAllByNameContainsValue(value);
	}
	
	public List<Team> getAllTeams(){
		return teamRepository.findAll();
	}

}