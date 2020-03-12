package com.hcl.training.AccountManagementSystemApp.repository.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.training.AccountManagementSystemApp.entities.Account;
import com.hcl.training.AccountManagementSystemApp.repository.AccountRepository;
import com.hcl.training.AccountManagementSystemApp.repository.AccountRepositoryCustom;

public class AccountRepositoryCustomImpl implements AccountRepositoryCustom {
	
	@Autowired
	private AccountRepository accountRepository; 
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void fetchAllByIFSC(String IFSC) {
		
	}

}
