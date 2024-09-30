package com.ahmete.repository;

import com.ahmete.entity.ContractOffer;

public class ContractOfferRepository extends RepositoryManager<ContractOffer,Long>{
	public ContractOfferRepository() {
		super(ContractOffer.class);
	}
}