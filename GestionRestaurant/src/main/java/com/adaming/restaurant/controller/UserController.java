package com.adaming.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.restaurant.entity.User;
import com.adaming.restaurant.service.UserService;

@Controller
@RequestMapping(value = "/User")
public class UserController {

	@Autowired
	private UserService userv;

	public UserService getUserv() {
		return userv;
	}

	public void setUserv(UserService userv) {
		this.userv = userv;
	}

	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String init(@ModelAttribute("user") User user) {
		user = new User();
		return "user";
	}

	@RequestMapping(value = "/Ajout", method = RequestMethod.POST)
	public String AjoutUser(@ModelAttribute("user") User user, Model model) { // mat sert � appeler un nouvel objet de
																				// type mati�re
		userv.ajoutUserService(user);
		return "redirect:All";
	}

	@RequestMapping(value = "/Supprimer", method = RequestMethod.POST)
	public String SupprimerUser(@ModelAttribute("user") User user) {
		userv.supprimerUserService(user);
		return "redirect:All";
	}
	
	@RequestMapping(value="/MAJ", method=RequestMethod.POST)
	public String MAJUser(@ModelAttribute("user") User user, Model model) {
		userv.MAJUserService(user);
		return "redirect:All";
	}

	@RequestMapping(value = "/All", method = RequestMethod.GET)
	public String GetAllUser(ModelMap model) {
		model.addAttribute("listeDesUsers", userv.consultUserService());
		return "user";
	}

}
