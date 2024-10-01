package com.ahmete.repository;

import com.ahmete.entity.Manager;
import com.ahmete.entity.Player;
import com.ahmete.entity.TransferOffer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class TransferOfferRepository extends RepositoryManager<TransferOffer,Long> {
	
	public TransferOfferRepository() {
		super(TransferOffer.class);
	}
	
	public List<TransferOffer> futbolcuIcinYapilanTeklifler(Manager manager) {
		EntityManager em = getEntityManager();
		
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<TransferOffer> cq = cb.createQuery(TransferOffer.class);
			Root<TransferOffer> root = cq.from(TransferOffer.class);
			cq.select(root).where(cb.equal(root.get("managerID"), manager.getTeamID()));
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
	
	public List<TransferOffer> findByReceiverTeamID(Long receiverTeamID) {
		EntityManager em = getEntityManager();
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<TransferOffer> cq = cb.createQuery(TransferOffer.class);
			Root<TransferOffer> root = cq.from(TransferOffer.class);
			
			cq.select(root).where(cb.equal(root.get("receiverTeamID"), receiverTeamID));
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