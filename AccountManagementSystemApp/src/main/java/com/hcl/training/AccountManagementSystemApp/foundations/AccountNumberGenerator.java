package com.hcl.training.AccountManagementSystemApp.foundations;

import java.util.concurrent.atomic.AtomicLong;

import com.hcl.training.AccountManagementSystemApp.entities.utils.AccountConstants;

public class AccountNumberGenerator {	
	
	//private static AtomicLong accountNumberSequence;
	
	//public static AccountNumberGenerator generator = new AccountNumberGenerator();
	
	public static AtomicLong accountNumberSequence = new AtomicLong(5000);
	
	private AccountNumberGenerator() {
		 this.accountNumberSequence = new AtomicLong(5000);		
	}
	
	private static Long generateAccountNumberSequence() {
		return accountNumberSequence.incrementAndGet();
	}
	
	public static String generateAccountNumber() {
		
		long incrementAndGet = accountNumberSequence.incrementAndGet();
		//Long generatedSequence = generateAccountNumberSequence();
		StringBuilder value = new StringBuilder(AccountConstants.ACCOUNT_IFSC);
		value.append(incrementAndGet);
		return value.toString();
	}

}
