package com.rest.AccountRest.controller;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import beans.AccountOperations;
import entitybeans.Account;

@RestController
public class AccountController {

	Account acc;
	AccountOperations open;
	ArrayList<Account> lst;
	
	@GetMapping("/home")
	public String home()
	{
		return "THis Is open";
	}
	
	@GetMapping("/record/{accno}")
	public Account getRecord(@PathVariable int accno)
	{
		acc=new Account();
		open=new AccountOperations();
		acc=open.getInfo(accno);
		return acc;
	}
	
	@GetMapping("/record")
	public ArrayList<Account> getRecords()
	{
		lst=new ArrayList<>();
		open=new AccountOperations();
		lst=(ArrayList<Account>) open.getReport();
		return lst;
		
	}
	@GetMapping("/type/{acctype}")
	public ArrayList<Account> getRecords2(@PathVariable("acctype") String acctype)
	{
		lst=new ArrayList<>();
		open=new AccountOperations();
		lst=(ArrayList<Account>) open.getReport2(acctype);
		return lst;
		
	}
	
	@PostMapping("/add")
	public String addAccount(@RequestBody Account acc)
	{
		String status = null;
		open=new AccountOperations();
		status =open.newAccount(acc);
		return status;
	}
	
	@PutMapping("/update")
	public String transaction(int accno,int accno2,double balance)
	{
		String status = null;
		open=new AccountOperations();
		status = open.updateBalance(accno, accno2, balance);
		return status;
		
	}
	
	@DeleteMapping("/delete/{accno}")
	public String deleteAccount(int accno) 
	{
		String status = null;
		open=new AccountOperations();
		status = open.delAccount(accno);
		return status;
	}
}
