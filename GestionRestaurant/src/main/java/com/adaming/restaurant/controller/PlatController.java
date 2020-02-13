package com.adaming.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.restaurant.entity.Plat;
import com.adaming.restaurant.service.PlatService;
@CrossOrigin
@Controller
@RequestMapping(value="/Plat")
public class PlatController {

	@Autowired
	private PlatService pserv;
	
	public PlatService getPserv() {
		return pserv;
	}

	public void setPserv(PlatService pserv) {
		this.pserv = pserv;
	}

	@RequestMapping(value="/init", method=RequestMethod.GET)
	public String init(@ModelAttribute("p") Plat p) {
		p = new Plat();
		return "plat";
	}
	
	@RequestMapping(value="/Ajout", method=RequestMethod.POST)
	public String AjoutPlat(@ModelAttribute("p") Plat p, Model model) {
		pserv.AjoutPlatService(p);
		return "redirect:All";
	}
	
	@RequestMapping(value="/Supprimer", method=RequestMethod.POST)
	public String SupprimerPlat(@ModelAttribute("p") Plat p, Model model) {
		pserv.SupprimerplatService(p);
		return "redirect:All";
	}
	
	@RequestMapping(value="/MAJ", method=RequestMethod.POST)
	public String MAJPlat(@ModelAttribute("p") Plat p, Model model) {
		pserv.MAJPlatService(p);
		return "redirect:All";
	}
	
	@RequestMapping(value="/All", method=RequestMethod.GET)
	public String GetAllPlat(ModelMap model) {
		model.addAttribute("listeDesPlats", pserv.GetAllPlat());
		return "plat";
	}
	
	@RequestMapping(value="/ByID", method=RequestMethod.GET)
	public String GetPlatByID(@ModelAttribute("p") Plat p, Model model) {
		model.addAttribute("leplat", pserv.GetPlatByID(p.getIdPlat()));
		return "lePlat";
	}
	
	@RequestMapping(value="/SupByID", method=RequestMethod.POST)
	public String SupPlatByID(@ModelAttribute("p")Plat p, Model model) {
		pserv.SupPlatByID(p.getIdPlat());
		return "redirect:All";
	}
}
