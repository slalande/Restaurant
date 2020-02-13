package com.adaming.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.restaurant.entity.Role;
import com.adaming.restaurant.service.RoleService;

@Controller
@RequestMapping(value="/Role")
public class RoleController {
	
	@Autowired
	private RoleService rserv;
	

	public RoleService getRserv() {
		return rserv;
	}

	public void setRserv(RoleService rserv) {
		this.rserv = rserv;
	}
	

	@RequestMapping(value="/init", method=RequestMethod.GET)
	public String init(@ModelAttribute("role") Role role) {
		role = new Role();
		return "role";
	}

	@RequestMapping(value="/Ajout", method = RequestMethod.POST)
	public String AjoutRole(@ModelAttribute("role") Role role, Model model) {  // mat sert � appeler un nouvel objet de type mati�re
		rserv.ajoutRoleService(role);	
		return "redirect:All";		
	}
	
	@RequestMapping(value="/Supprimer", method = RequestMethod.POST)
	public String SupprimerRole(@ModelAttribute("role") Role role) {  
		rserv.supprimerRoleService(role);	
		return "redirect:All";		
	}
	@RequestMapping(value="/MAJ", method=RequestMethod.POST)
	public String MAJRole(@ModelAttribute("role") Role role, Model model) {
		rserv.MAJRoleService(role);
		return "redirect:All";
	}
	
	@RequestMapping(value="/All", method = RequestMethod.GET)
	public String GetAllRole(ModelMap model) { 
		model.addAttribute("listeDesRoles", rserv.consultRoleService());		
		return "role";		
	}
	
	@RequestMapping(value="/ByID", method=RequestMethod.GET)
	public String RechRoleID(@ModelAttribute("role") Role role, ModelMap model) {
		model.addAttribute("lerole", rserv.rechercheRoleIDService(role.getIdrole()));
		return "lerole";
		
	}

}
