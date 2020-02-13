package com.adaming.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.myapp.DAO.UserDAO;
import com.adaming.myapp.Entity.User;

@Controller
@RequestMapping(value="/User")
public class UserController {
	
	@Autowired
	private UserDAO udao;

	public UserDAO getUdao() {
		return udao;
	}

	public void setUdao(UserDAO udao) {
		this.udao = udao;
	}
	
	@RequestMapping(value="/init", method=RequestMethod.GET)
	public String init(@ModelAttribute("user") User user) {
		user = new User();
		return "user";
	}

	@RequestMapping(value="/Ajout", method = RequestMethod.POST)
	public String AjoutUser(@ModelAttribute("user") User user, Model model) {  // mat sert à appeler un nouvel objet de type matière
		udao.AjoutUser(user);		
		return "redirect:All";		
	}
	
	@RequestMapping(value="/Supprimer", method = RequestMethod.POST)
	public String SupprimerUser(@ModelAttribute("user") User user) {  
		udao.SupprimerUser(user);		
		return "redirect:All";		
	}
	
	@RequestMapping(value="/All", method = RequestMethod.GET)
	public String GetAllUser(ModelMap model) { 
		model.addAttribute("listeDesUsers", udao.getAllUser());		
		return "user";		
	}

}
