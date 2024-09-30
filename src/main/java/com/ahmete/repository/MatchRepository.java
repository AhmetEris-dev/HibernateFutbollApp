package com.ahmete.repository;

import com.ahmete.entity.Match;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class MatchRepository extends RepositoryManager<Match,Long>{
	public MatchRepository() {
		super(Match.class);
	}
	
	public List<Match> findByFixtureID(Long fixtureID) {
		EntityManager em = getEntityManager();
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Match> query = cb.createQuery(Match.class);
			Root<Match> match = query.from(Match.class);
			query.select(match).where(cb.equal(match.get("fixtureID"), fixtureID));
			
			return em.createQuery(query).getResultList();
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