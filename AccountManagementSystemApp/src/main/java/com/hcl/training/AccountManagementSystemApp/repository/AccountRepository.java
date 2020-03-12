package com.hcl.training.AccountManagementSystemApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.training.AccountManagementSystemApp.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

	public List<Account> findByIFSC(String IFSC);
	
	public Account findByAccountNumber(String accountNumber);
	
	 
}
