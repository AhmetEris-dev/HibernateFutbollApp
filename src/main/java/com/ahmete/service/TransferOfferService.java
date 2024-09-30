package com.ahmete.service;

import com.ahmete.entity.Manager;
import com.ahmete.entity.TransferOffer;
import com.ahmete.repository.TransferOfferRepository;

import java.util.List;

public class TransferOfferService extends ServiceManager<TransferOffer,Long> {
	private final TransferOfferRepository transferOfferRepository;
	
	public TransferOfferService() {
		this(new TransferOfferRepository());
	}
	
	public TransferOfferService(TransferOfferRepository transferOfferRepository) {
		super(transferOfferRepository);
		this.transferOfferRepository = transferOfferRepository;
	}
	
	public List<TransferOffer> futbolcuIcinYapilanTeklifler(Manager manager){
		return transferOfferRepository.futbolcuIcinYapilanTeklifler(manager);
	}
	
}