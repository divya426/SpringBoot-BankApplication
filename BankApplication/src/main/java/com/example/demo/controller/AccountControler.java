package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/getAccount/{id}")
	public ResponseEntity<AccountDto> getAccount(@PathVariable Long id){
		return new ResponseEntity<AccountDto>(accountService.getAccount(id), HttpStatus.OK);
	}
	
	@PatchMapping("/deposit/{id}")
	public ResponseEntity<AccountDto> depositAmount(@PathVariable Long id, @RequestBody Map<String, Double> request ){
		return new ResponseEntity<AccountDto>(accountService.deposit(id, request.get("amount")), HttpStatus.OK);
	}

	@PatchMapping("/withdraw/{id}")
	public ResponseEntity<AccountDto> withdrawAmount(@PathVariable Long id, @RequestBody Map<String, Double> request){
		return new ResponseEntity<AccountDto>(accountService.withdraw(id, request.get("amount")), HttpStatus.OK);
	}
	
	@GetMapping("/getAllAccounts")
	public ResponseEntity<List<AccountDto>> getAllAccount(){
		return new ResponseEntity<List<AccountDto>>(accountService.getAllAccount(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id){
		accountService.deleteAccount(id);
		return new ResponseEntity<String>("Account is deleted successfully", HttpStatus.OK);
	}
	
}
