package com.Heroku.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Heroku.entity.Banks;
import com.Heroku.entity.Branches;
import com.Heroku.repo.BankRepo;
import com.Heroku.repo.BranchRepo;

@RestController
public class MyController {
	
	@Autowired
	BranchRepo branchRepo;
	@Autowired
	BankRepo bankRepo;
	
	@RequestMapping("/test")
	public String hello() {
		return "Hello World";
	}
	
	@RequestMapping(value="/getBranch", method = RequestMethod.GET)
	public Branches getBranches(@RequestParam(name= "ifsc") String ifsc) {
		Branches branch = branchRepo.getBranchById(ifsc);
		return branch;
	}
	
	@RequestMapping(value="/getBanks", method = RequestMethod.GET)
	public List<Banks> getBanks() {
		List<Banks> bank = bankRepo.findAll();
		return bank;
	}
	
	@RequestMapping(value="/getBanksbyCity", method = RequestMethod.GET)
	public List<Branches> getBranchesByCity(@RequestParam("name")String bankName,@RequestParam("city") String city) {
		Banks bank = bankRepo.findId(bankName);
		List<Branches> branches= branchRepo.findBranchesByCity(bank,city);
		return branches;
	}
	}

