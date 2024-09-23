package com.ahmete.repository;

import com.ahmete.entity.Player;
import com.ahmete.entity.Stadium;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class PlayerRepository extends RepositoryManager<Player,Long> {
	
	public PlayerRepository() {
		super(Player.class);
	}
	
	public List<Player> findPlayerByTeamID(Long teamID) {
		EntityManager em = getEntityManager();
		
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Player> cq = cb.createQuery(Player.class);
			Root<Player> root = cq.from(Player.class);
			
			cq.select(root).where(cb.equal(root.get("teamID"), teamID));
			return em.createQuery(cq).getResultList();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			em.close();
		}
	}
}