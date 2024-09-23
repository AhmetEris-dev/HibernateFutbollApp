package com.ahmete.repository;

import com.ahmete.entity.Manager;
import com.ahmete.entity.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.Optional;

public class ManagerRepository extends RepositoryManager<Manager,Long> {
	public ManagerRepository() {
		super(Manager.class);
	}
	
	public Optional<Manager> findManagerByIdAndPassword(Long id, String password) {
		EntityManager em = getEntityManager();
		
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Manager> cq = cb.createQuery(Manager.class);
			Root<Manager> root = cq.from(Manager.class);
			Predicate idPredicate = cb.equal(root.get("id"), id);
			Predicate passwordPredicate = cb.equal(root.get("managerPassword"), password);
			
			cq.where(cb.and(idPredicate, passwordPredicate));
			Manager result = em.createQuery(cq).getSingleResult();
			
			return Optional.ofNullable(result);
		}
		catch (Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
		finally {
			em.close();
		}
	}
	
	public Optional<Long> findTeamIdByManagerId(Long managerId) {
		EntityManager em = getEntityManager();
		
		try {
			Long teamId = em.createQuery("SELECT m.teamID FROM Manager m WHERE m.id = :managerId", Long.class)
			                .setParameter("managerId", managerId)
			                .getSingleResult();
			return Optional.ofNullable(teamId);
		} catch (Exception e) {
			e.printStackTrace();
			return Optional.empty();
		} finally {
			em.close();
		}
	}
}