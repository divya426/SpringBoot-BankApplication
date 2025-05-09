package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountDto;
import com.example.demo.service.IAccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountControler {
	
	private IAccountService accountService;
	
	@Autowired
	public AccountControler(IAccountService accountService) {
		this.accountService=accountService;
	}
	
	@PostMapping("/createAccount")
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		
		return new ResponseEntity<AccountDto>(accountService.createAccount(accountDto), HttpStatus.CREATED);
	}

}
