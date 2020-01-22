package com.cdac.StartupProject.service;

import java.util.List;

import com.cdac.StartupProject.bean.Project;
import com.cdac.StartupProject.bean.StartUp;

public interface StartUpService {

	boolean add(StartUp startup);
	StartUp selectByEmail(String email);
	List<Project> selectAll();
}
