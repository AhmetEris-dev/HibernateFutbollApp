package com.ahmete.repository;

import com.ahmete.entity.ContractOffer;
import com.ahmete.entity.TransferOffer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class ContractOfferRepository extends RepositoryManager<ContractOffer,Long>{
	public ContractOfferRepository() {
		super(ContractOffer.class);
	}
//
//	public List<ContractOffer> findByReceiverTeamID(Long transferOfferID){
//		EntityManager em = getEntityManager();
//		try {
//			CriteriaBuilder cb = em.getCriteriaBuilder();
//			CriteriaQuery<ContractOffer> cq = cb.createQuery(ContractOffer.class);
//			Root<ContractOffer> root = cq.from(ContractOffer.class);
//			cq.select(root).where(cb.equal(root.get("transferOfferID"), transferOfferID));
//			cq.select(root)
//			return em.createQuery(cq).getResultList();
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//		finally {
//			em.close();
//		}
//	}
}