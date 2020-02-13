package com.adaming.restaurant.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.restaurant.entity.Menu;
import com.adaming.restaurant.entity.Reservation;
import com.adaming.restaurant.service.MenuService;
import com.adaming.restaurant.service.ReservationService;
@CrossOrigin
@Controller
@RequestMapping(value="/Reservation")
public class ReservationController {
	
	@Autowired
	private ReservationService rserv;
	
	@Autowired
	private MenuService mserv;

	
	public MenuService getMserv() {
		return mserv;
	}

	public void setMserv(MenuService mserv) {
		this.mserv = mserv;
	}

	public ReservationService getRserv() {
		return rserv;
	}

	public void setRserv(ReservationService rserv) {
		this.rserv = rserv;
	}

	@RequestMapping(value="/init", method=RequestMethod.GET)
	public String init(@ModelAttribute("r") Reservation r) {
		r = new Reservation();
		return "reservation";
	}
	
	@RequestMapping(value="/Ajout", method=RequestMethod.POST)
	public String AjoutReservation(@ModelAttribute("r") Reservation r, ServletRequest req) {
		 List<Menu> listmenu = new ArrayList<Menu>();	  
		  List<String> liststr = new ArrayList<String>();	  
		  liststr = Arrays.asList(req.getParameterValues("test"));	  
		  for(String setri : liststr) listmenu.add(mserv.GetMenuByID(Long.parseLong(setri)));	  
		  r.setLstmenus(listmenu);
		rserv.AjoutReservationService(r);
		return "redirect:All";
	}
	
	@RequestMapping(value="/Supprimer", method=RequestMethod.POST)
	public String SupprimerReservation(@ModelAttribute("r") Reservation r, Model model) {
		rserv.SupprimerReservationService(r);
		return "redirect:All";
	}
	
	@RequestMapping(value="/MAJ", method=RequestMethod.POST)
	public String MAJReservation(@ModelAttribute("r") Reservation r, Model model) {
		rserv.MAJReservationService(r);
		return "redirect:All";
	}
	
	@RequestMapping(value="/All", method=RequestMethod.GET)
	public String GetAllReservation(ModelMap model) {
		model.addAttribute("listeDesReservations", rserv.GetAllResService());
		model.addAttribute("listeDesMenus", mserv.GetAllMenuService());
		return "reservation";
	}
	
	@RequestMapping(value="/ByID", method=RequestMethod.GET)
	public String GetReservationByID(@ModelAttribute("r") Reservation r, Model model) {
		model.addAttribute("lareservation", rserv.GetResByID(r.getIdReservation()));
		return "laReservation";
	}
	
	@RequestMapping(value="/SupByID", method=RequestMethod.POST)
	public String SupReservationByID(@ModelAttribute("r") Reservation r, Model model) {
		rserv.SupResByID(r.getIdReservation());
		return "redirect:All";
	}

}
