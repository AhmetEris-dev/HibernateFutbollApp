package com.ahmete.service;

import com.ahmete.entity.Player;
import com.ahmete.repository.ICrud;
import com.ahmete.repository.PlayerRepository;

public class PlayerService extends ServiceManager<Player,Long> {
	private final PlayerRepository playerRepository;
	
	public PlayerService() {
		this(new PlayerRepository());
	}
	
	public PlayerService(PlayerRepository playerRepository) {
		super(playerRepository);
		this.playerRepository = playerRepository;
	}
}