package com.ahmete.service;

import com.ahmete.entity.ContractOffer;
import com.ahmete.repository.ContractOfferRepository;
import com.ahmete.repository.LeagueRepository;

public class ContractOfferService extends ServiceManager<ContractOffer,Long> {
	private final ContractOfferRepository contractOfferRepository;
	
	public ContractOfferService() {
		this(new ContractOfferRepository());
	}
	
	public ContractOfferService(ContractOfferRepository contractOfferRepository) {
		super(contractOfferRepository);
		this.contractOfferRepository = contractOfferRepository;
	}
}