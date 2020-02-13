package com.adaming.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.restaurant.entity.Client;
import com.adaming.restaurant.service.ClientService;

@Controller
@RequestMapping(value="/Client")
public class ClientController {
	
	@Autowired
	private ClientService cserv;

	public ClientService getCserv() {
		return cserv;
	}

	public void setCserv(ClientService cserv) {
		this.cserv = cserv;
	}
	
	@RequestMapping(value="/init", method=RequestMethod.GET)
	public String init(@ModelAttribute("cl") Client cl) {
		cl = new Client();
		return "client";
	}
	
	@RequestMapping(value="/Ajout", method=RequestMethod.POST)
	public String AjoutClient(@ModelAttribute("cl") Client cl, Model model) {
		cserv.AjoutClientService(cl);
		return "redirect:All";
	}
	
	@RequestMapping(value="/Supprimer", method=RequestMethod.POST)
	public String SupprimerClient(@ModelAttribute("cl") Client cl, Model model) {
		cserv.SupprimerClientService(cl);
		return "redirect:All";
	}
	
	@RequestMapping(value="/MAJ", method=RequestMethod.POST)
	public String MAJClient(@ModelAttribute("cl") Client cl, Model model) {
		cserv.MAJClientService(cl);
		return "redirect:All";
	}
	
	@RequestMapping(value="/All", method=RequestMethod.GET)
	public String GetAllClient(ModelMap model) {
		model.addAttribute("listeDesClients", cserv.GetAllClient());
		return "client";
	}
	
	@RequestMapping(value="/ByID", method=RequestMethod.GET)
	public String GetClientByID(@ModelAttribute("cl") Client cl, Model model) {
		model.addAttribute("leclient", cserv.GetClientByIDService(cl.getIdClient()));
		return "leClient";
	}
	
	@RequestMapping(value="/SupByID", method=RequestMethod.POST)
	public String SupClientByID(@ModelAttribute("cl") Client cl, Model model) {
		cserv.SupClientByIDService(cl.getIdClient());
		return "redirect:All";
	}

}
