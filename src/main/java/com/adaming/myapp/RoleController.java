package com.adaming.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.myapp.DAO.RoleDAO;
import com.adaming.myapp.Entity.Role;

@Controller
@RequestMapping(value="/Role")
public class RoleController {
	
	@Autowired
	private RoleDAO rdao;
	
	
	public RoleDAO getRdao() {
		return rdao;
	}

	public void setRdao(RoleDAO rdao) {
		this.rdao = rdao;
	}
	

	@RequestMapping(value="/init", method=RequestMethod.GET)
	public String init(@ModelAttribute("role") Role role) {
		role = new Role();
		return "role";
	}

	@RequestMapping(value="/Ajout", method = RequestMethod.POST)
	public String AjoutRole(@ModelAttribute("role") Role role, Model model) {  // mat sert à appeler un nouvel objet de type matière
		rdao.AjoutRole(role);		
		return "redirect:All";		
	}
	
	@RequestMapping(value="/Supprimer", method = RequestMethod.POST)
	public String SupprimerRole(@ModelAttribute("role") Role role) {  
		rdao.SupprimerUser(role);		
		return "redirect:All";		
	}
	
	@RequestMapping(value="/All", method = RequestMethod.GET)
	public String GetAllRole(ModelMap model) { 
		model.addAttribute("listeDesRoles", rdao.getAllRole());		
		return "role";		
	}

}
