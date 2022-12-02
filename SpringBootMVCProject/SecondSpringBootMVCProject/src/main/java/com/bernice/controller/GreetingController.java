package com.bernice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bernice.model.service.WelcomeService;


//@Controller is used to mark any class as controller
@Controller
public class GreetingController {

	@Autowired
	private WelcomeService welcomeService;
	
	//Mapping Handler
	@RequestMapping("/mon")
	//all controller methods must be public
	public ModelAndView myFirstController() {
		ModelAndView modelAndView=new ModelAndView();
		String monMessage=welcomeService.morning();
		//Setting data for viewing on view
		modelAndView.addObject("morningMessage", monMessage);
		
		//Setting view name with is supposed to display output to the client
		modelAndView.setViewName("Greet");
		return modelAndView;
	}
	

	@RequestMapping("/eve")
	public ModelAndView mySecondController() {
		ModelAndView modelAndView=new ModelAndView();
		String eveMessage=welcomeService.evening();
		//Setting data for viewing on view
		modelAndView.addObject("eveningMessage", eveMessage);
		
		//Setting view name with is supposed to display output to the client
		modelAndView.setViewName("Greet");
		return modelAndView;
	}
	

}