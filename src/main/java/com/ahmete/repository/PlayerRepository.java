package com.ahmete.repository;

import com.ahmete.entity.Player;

public class PlayerRepository extends RepositoryManager<Player,Long> {
	
	public PlayerRepository() {
		super(Player.class);
	}
	
}