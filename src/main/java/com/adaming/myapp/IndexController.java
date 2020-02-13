package com.adaming.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/index")
public class IndexController {
	
	@RequestMapping(value="/initMatiere", method=RequestMethod.GET)
	public String initMatiere() {
		return "redirect:index/Matiere/All";
	}
	
	@RequestMapping(value="/initEtudiant", method=RequestMethod.GET)
	public String initEtudiant() {
		return "redirect:index/Etudiant/All";
	}
	
	@RequestMapping(value="/initUser", method=RequestMethod.GET)
	public String initUser() {
		return "redirect:index/User/All";
	}
	
	@RequestMapping(value="/initRole", method=RequestMethod.GET)
	public String initRole() {
		return "redirect:index/Role/All";
	}

}
