package com.adaming.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.restaurant.entity.Menu;
import com.adaming.restaurant.service.MenuService;

@Controller
@RequestMapping(value="/Menu")
public class MenuController {
	
	@Autowired
	private MenuService mserv;

	
	public MenuService getMserv() {
		return mserv;
	}

	public void setMserv(MenuService mserv) {
		this.mserv = mserv;
	}

	@RequestMapping(value="/init", method=RequestMethod.GET)
	public String init(@ModelAttribute("m") Menu m) {
		m = new Menu();
		return "menu";
	}
	
	@RequestMapping(value="/Ajout", method=RequestMethod.POST)
	public String AjoutMenu(@ModelAttribute("m") Menu m, Model model) {
		mserv.AjoutMenuService(m);
		return "redirect:All";
	}
	
	@RequestMapping(value="/Supprimer", method=RequestMethod.POST)
	public String SupprimerMenu(@ModelAttribute("m") Menu m, Model model) {
		mserv.SupprimerMenuService(m);
		return "redirect:All";
	}
	
	@RequestMapping(value="/MAJ", method=RequestMethod.POST)
	public String MAJMenu(@ModelAttribute("m") Menu m, Model model) {
		mserv.MAJMenuService(m);
		return "redirect:All";
	}
	
	@RequestMapping(value="/All", method=RequestMethod.GET)
	public String GetAllMenu(ModelMap model) {
		model.addAttribute("listeDesMenus", mserv.GetAllMenuService());
		return "menu";
	}
	
	@RequestMapping(value="/ByID", method=RequestMethod.GET)
	public String GetMenuByID(@ModelAttribute("m") Menu m, Model model) {
		model.addAttribute("lemenu", mserv.GetMenuByID(m.getIdMenu()));
		return "leMenu";
	}
	
	@RequestMapping(value="/SupByID", method=RequestMethod.POST)
	public String SupMenuByID(@ModelAttribute("m") Menu m, Model model) {
		mserv.SupMenuByID(m.getIdMenu());
		return "redirect:All";
	}

}
