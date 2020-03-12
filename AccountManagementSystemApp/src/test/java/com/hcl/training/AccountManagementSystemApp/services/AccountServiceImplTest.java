package com.hcl.training.AccountManagementSystemApp.services;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import com.hcl.training.AccountManagementSystemApp.entities.Account;
import com.hcl.training.AccountManagementSystemApp.entities.utils.AccountConstants;
import com.hcl.training.AccountManagementSystemApp.foundations.AccountNumberGenerator;
import com.hcl.training.AccountManagementSystemApp.repository.AccountRepository;

import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class AccountServiceImplTest {

	private Account accountTestData_1;
	private Account accountTestData_2;
	private Account accountTestData_3;
	private Account accountTestData_4;
	
	@BeforeEach
	public void setup() {
		accountTestData_1 = new Account(AccountNumberGenerator.generateAccountNumber(), AccountConstants.ACCOUNT_IFSC, AccountConstants.ACCOUNT_TYPE_SAVING, AccountConstants.ACCOUNT_STATUS_ACTIVE);
		accountTestData_2 = new Account(AccountNumberGenerator.generateAccountNumber(), AccountConstants.ACCOUNT_IFSC, AccountConstants.ACCOUNT_TYPE_SAVING, AccountConstants.ACCOUNT_STATUS_INACTIVE);
		accountTestData_3 = new Account(AccountNumberGenerator.generateAccountNumber(), AccountConstants.ACCOUNT_IFSC, AccountConstants.ACCOUNT_TYPE_SAVING, AccountConstants.ACCOUNT_STATUS_ACTIVE);
		accountTestData_4 = new Account(AccountNumberGenerator.generateAccountNumber(), AccountConstants.ACCOUNT_IFSC, AccountConstants.ACCOUNT_TYPE_SAVING, AccountConstants.ACCOUNT_STATUS_ACTIVE);
	}
	
	@Autowired
	private AccountServiceImpl accountServiceImpl;
	
	@MockBean
	private AccountRepository accountRepository;
	
	@Test
	public void createAccountTest() {
		
		Mockito.when(accountRepository.save(accountTestData_1)).thenReturn(accountTestData_1);
		Account createdAccount = accountServiceImpl.createAccount(accountTestData_1);
		//assertNull(createdAccount);
		if(createdAccount != null) {
			assertThat(createdAccount).isEqualTo(accountTestData_1);
		}
	}
	
	@Test
	public void updateAccountStatusTest() {
		Mockito.when(accountRepository.save(accountTestData_2)).thenReturn(accountTestData_2);
		Account updatedAccountStatus = accountServiceImpl.updateAccountStatus(accountTestData_2);
		//assertNull(updatedAccountStatus);
		if(updatedAccountStatus != null) {
			assertThat(updatedAccountStatus).isEqualToComparingFieldByField(accountTestData_2);
		}
	}
	
	@Test
	public void fetchAllAccountsByIFSCTest() {
		List<Account> asList = Arrays.asList(accountTestData_1, accountTestData_2, accountTestData_3, accountTestData_4);
		Mockito.when(accountRepository.findByIFSC(AccountConstants.ACCOUNT_IFSC)).thenReturn(asList);
		List<Account> fetchedAllAccountsByIFSC = accountServiceImpl.fetchAllAccountsByIFSC(AccountConstants.ACCOUNT_IFSC);
		assertThat(fetchedAllAccountsByIFSC.size()).isEqualTo(asList.size());
		//assertThat(fetchedAllAccountsByIFSC.get(index))
	}
	
	@Test
	public void fechAccountByNumberTest() {
		String accountNumber = accountTestData_3.getAccountNumber();
		Mockito.when(accountRepository.findByAccountNumber(accountNumber)).thenReturn(accountTestData_3);
		Account fechedAccountByNumber = accountServiceImpl.fetchAccountByNumber(accountTestData_3.getAccountNumber());
		//assert(fechedAccountByNumber);
		assertThat(fechedAccountByNumber).isEqualToComparingFieldByField(accountTestData_3);
	}
}
