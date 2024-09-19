package com.ahmete.repository;

import com.ahmete.entity.Manager;

public class ManagerRepository extends RepositoryManager<Manager,Long> {
	public ManagerRepository() {
		super(Manager.class);
	}
}