package com.hcl.training.AccountManagementSystemApp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	
	@Id
	private String accountNumber;
	private String IFSC;
	private String accountType;
	private String accountStatus;
	private String customerNumber;
	
	/**
	 * default constructor
	 */
	public Account() {}
	
	/**
	 * @param accountNumber
	 * @param iFSC
	 * @param accountType
	 * @param accountStatus
	 */
	public Account(String accountNumber, String iFSC, String accountType, String accountStatus) {
		super();
		this.accountNumber = accountNumber;
		IFSC = iFSC;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getIFSC() {
		return IFSC;
	}


	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public String getAccountStatus() {
		return accountStatus;
	}


	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}


	public String getCustomerNumber() {
		return customerNumber;
	}


	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	
}
