package com.cdac.StartupProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.StartupProject.bean.Login;
import com.cdac.StartupProject.bean.Project;
import com.cdac.StartupProject.bean.StartUp;
import com.cdac.StartupProject.service.LoginSevice;
import com.cdac.StartupProject.service.StartUpService;



@Controller
public class StartUpController 
{
	
	@Autowired
	private StartUpService startUpService;
	
	public void setStartUpService(StartUpService startUpService) {
		this.startUpService = startUpService;
	}

	@Autowired
	private LoginSevice loginService;
	

	public void setLoginService(LoginSevice loginService) {
		this.loginService = loginService;
	}


	public StartUpController() {
		super();
		// TODO Auto-generated constructor stub
	}


	@RequestMapping(value="/StpReg.htm",method = RequestMethod.POST)
	public String save(@ModelAttribute("stp") StartUp stp)
	{
		//System.out.println("hii");
		try {
		if(startUpService.add(stp))
			return "index";
		else 
			return "home";
		}catch(Exception e)
		{
			return "home";
		}
		
	}
	
	@RequestMapping(value="/compStpLog.htm",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("lg") Login lg)
	{
		ModelAndView model; 
		//System.out.println("hii");
		try {
			Login lgn = loginService.login(lg);
		if(lgn.getFlag() == 1)
		{
			  List<Project>list = startUpService.selectAll();
			model = new ModelAndView("startup_home");
			model.addObject("lists",list);
			return model;
		}
		else if (lgn.getFlag()==2) {
			model=new ModelAndView("company_home");
			return model;
		}
		else
		{
			model = new ModelAndView("login");
			return model;
		}
		}catch(Exception e)
		{
			model = new ModelAndView("index");
			return model;
		}
		
	}
	

}
