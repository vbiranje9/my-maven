package com.cdac.StartupProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.StartupProject.bean.Company;
import com.cdac.StartupProject.dao.CompanyDaoImple;

@Service
public class CompanyServiceImple implements CompanyService {

	@Autowired
	private CompanyDaoImple compimple;
	
	public void insert(Company comp) {
		
		compimple.insert(comp);
	}

	@Override
	public boolean compLogin(Company comp) {

		compimple.compLogin(comp);	
		return true;
	}
}
