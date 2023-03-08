package com.luv2code.springdemo.mvc;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
	
	// need a controller method to show
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller method to show the newer version of form
	@RequestMapping("/showFormV2") 
	public String showFormV2() {
		return "helloworld-form-version2";
	}
	
	// need a controller method to process the HTML form
	@RequestMapping("/processForm") 
	public String processForm() {
		return "helloworld";
	}
	
	
	// need a controller method to read form data and add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		//convert the data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Yo Yo !! " + theName ;
		
		// add message to the model 
		model.addAttribute("message", result); // first parameter is name and second parameter is value
		
		return "helloworld" ;
		
	}
	
	// need a controller method to read form data and add data to the model
	@RequestMapping("/processFormV3")
	public String processFormUsingRequestParam(@RequestParam("studentName") String theName, Model model) {
		
		//convert the data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Hello from V3 !! " + theName ;
		
		// add message to the model 
		model.addAttribute("message", result); // first parameter is name and second parameter is value
		
		return "helloworld" ;
		
	}
}
