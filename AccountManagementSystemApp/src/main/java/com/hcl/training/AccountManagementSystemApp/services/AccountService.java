package com.hcl.training.AccountManagementSystemApp.services;

import java.util.List;

import com.hcl.training.AccountManagementSystemApp.entities.Account;

public interface AccountService {

	/**
	 * @param account
	 * @return
	 */
	public Account createAccount(Account account);

	/**
	 * @param account
	 * @return
	 */
	public Account updateAccountStatus(Account account);

	/**
	 * @param IFSC
	 * @return
	 */
	public List<Account> fetchAllAccountsByIFSC(String IFSC);

	/**
	 * @param accountNumber
	 * @return
	 *//*
		 * public Account fetchAccountByNumber(Long accountNumber);
		 */

	Account fetchAccountByNumber(String accountNumber);

}
