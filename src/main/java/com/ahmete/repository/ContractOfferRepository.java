package com.ahmete.repository;

import com.ahmete.entity.ContractOffer;
import com.ahmete.entity.TransferOffer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.Collections;
import java.util.List;

import static com.ahmete.gui.ManagerGUI.activeManager;

public class ContractOfferRepository extends RepositoryManager<ContractOffer,Long>{
	public ContractOfferRepository() {
		super(ContractOffer.class);
	}
	
	
	
	
}