package com.ahmete.service;

import com.ahmete.entity.Manager;
import com.ahmete.repository.ICrud;
import com.ahmete.repository.ManagerRepository;

public class ManagerService extends ServiceManager<Manager,Long> {
	private final ManagerRepository managerRepository;
	
	public ManagerService() {
		this(new ManagerRepository());
	}
	
	public ManagerService( ManagerRepository managerRepository) {
		super(managerRepository);
		this.managerRepository = managerRepository;
	}
}