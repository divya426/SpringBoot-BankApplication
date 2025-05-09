package com.example.demo.service;

import com.example.demo.dto.AccountDto;


public interface IAccountService {
	
	public AccountDto createAccount(AccountDto account);
	public AccountDto getAccount(Long id);
	public AccountDto deposit(Long id, Double amount);
	

}
