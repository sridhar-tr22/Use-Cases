package com.hcl.training.AccountManagementSystemApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.training.AccountManagementSystemApp.entities.Account;
import com.hcl.training.AccountManagementSystemApp.entities.utils.AccountConstants;
import com.hcl.training.AccountManagementSystemApp.services.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService; 
	
	@PostMapping("/create")
	public Account createAccount(@RequestBody Account account) {
		Account createdAccount = accountService.createAccount(account);
		//Account createdAccount = new Account(50005L, AccountConstants.ACCOUNT_IFSC, AccountConstants.ACCOUNT_TYPE_SAVING , AccountConstants.ACCOUNT_STATUS_ACTIVE);
		return createdAccount;
	}
	
	@PostMapping("/get")
	public Account fetchAccountByNumber(@RequestBody Account account) {
		String accountNumber = account.getAccountNumber();
		Account fetchedAccountByNumber = accountService.fetchAccountByNumber(accountNumber);
		return fetchedAccountByNumber;
	}
	
	@PutMapping("/update")
	public Account updateAccountStatus(@RequestBody Account account) {
		Account updatedAccountStatus = accountService.updateAccountStatus(account);
		return updatedAccountStatus;
	}
	
	@GetMapping("/IFSC/{IFSC}")
	public List<Account> fetchAccountByNumber(@PathVariable(name = "IFSC")String IFSC) {
		 List<Account> fetchedAllAccountsByIFSC = accountService.fetchAllAccountsByIFSC(IFSC);
		return fetchedAllAccountsByIFSC;
	}
}
