package com.hcl.training.AccountManagementSystemApp.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;


public class AccountControllerTest {

	@InjectMocks
	private AccountController accountController;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
	}
	
	@Test
	public void createAccountRESTTest() throws Exception {
		String account = "{\r\n" + 
				"        \"accountNumber\": \"ING00105001\",\r\n" + 
				"        \"accountType\": \"SAVING\",\r\n" + 
				"        \"accountStatus\": \"ACTIVE\",\r\n" + 
				"        \"customerNumber\": \"CUS2001\",\r\n" + 
				"        \"ifsc\": \"ING0010\"\r\n" + 
				"    }";
		
		mockMvc.perform(post("/accounts/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(account)
				).andDo(print());
	}
}
