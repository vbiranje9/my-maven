package com.cdac.StartupProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.StartupProject.bean.Project;
import com.cdac.StartupProject.bean.StartUp;
import com.cdac.StartupProject.dao.StartUpDao;;

@Service
public class StartUpServImpl implements StartUpService {

	@Autowired
	private StartUpDao startUpDao;
	
	
	public StartUpServImpl() {
		super();
		
	}
	
	public void setStartUpDao(StartUpDao startUpDao) {
		this.startUpDao = startUpDao;
	}


	@Override
	public boolean add(StartUp startup) {
	
		
		return startUpDao.add(startup);
	}

	@Override
	public StartUp selectByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
