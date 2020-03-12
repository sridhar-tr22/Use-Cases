package com.hcl.training.AccountManagementSystemApp;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.hcl.training.AccountManagementSystemApp.services.AccountService;
import com.hcl.training.AccountManagementSystemApp.services.AccountServiceImpl;

@TestConfiguration
public class AccountTestConfiguration {

	@Bean
	public AccountService getAccountServiceInstance() {
		return new AccountServiceImpl();
	}
}
