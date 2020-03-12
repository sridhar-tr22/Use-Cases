package com.hcl.training.AccountManagementSystemApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.training.AccountManagementSystemApp.entities.Account;
import com.hcl.training.AccountManagementSystemApp.foundations.AccountNumberGenerator;
import com.hcl.training.AccountManagementSystemApp.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) {
		account.setAccountNumber(AccountNumberGenerator.generateAccountNumber());
		Account saved = accountRepository.save(account);
		return saved;
	}

	@Override
	public Account updateAccountStatus(Account account) {
		Account updated = accountRepository.save(account);
		return updated;
	}

	@Override
	public List<Account> fetchAllAccountsByIFSC(String IFSC) {
		List<Account> foundByIFSC = accountRepository.findByIFSC(IFSC);
		return foundByIFSC;
	}

	@Override
	public Account fetchAccountByNumber(String accountNumber) {
		Account foundByAccountNumber = accountRepository.findByAccountNumber(accountNumber);
		return foundByAccountNumber;
	}

	
	/*@Override
	public Account fetchAccountByNumber(Long accountNumber) {
		// TODO Auto-generated method stub
		return null;*/

}