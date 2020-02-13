package com.adaming.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.adaming.myapp.Entity.Matiere;

/**
 * Handles requests for the application home page.
 */
@Controller()

public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)  // méthode considérée comme un service
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home2 () {	
		return "index";		
	}
//	
//	public String hello() {  
//		String viewName = "index";
//		
//		return viewName;
//		
//	}
	
	@RequestMapping(value="/initLogin", method=RequestMethod.GET)
	public String initLogin() {
		return "redirect:login";
	}
	
//	@RequestMapping(value="/initMatiere", method=RequestMethod.GET)
//	public String initMatiere() {
//		return "redirect:Matiere/All";
//	}
//	
//	@RequestMapping(value="/initEtudiant", method=RequestMethod.GET)
//	public String initEtudiant() {
//		return "redirect:Etudiant/All";
//	}
	
}
