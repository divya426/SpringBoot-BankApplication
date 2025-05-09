package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AccountDto;


public interface IAccountService {
	
	public AccountDto createAccount(AccountDto account);
	public AccountDto getAccount(Long id);
	public AccountDto deposit(Long id, Double amount);
	public AccountDto withdraw(Long id, Double amount );
	public List<AccountDto> getAllAccount();
	public void deleteAccount(Long id);

}
