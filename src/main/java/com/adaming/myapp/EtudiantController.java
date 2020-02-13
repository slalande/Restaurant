package com.adaming.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.myapp.DAO.EtudiantDAO;
import com.adaming.myapp.Entity.Etudiant;

@Controller
@RequestMapping(value="/Etudiant")
public class EtudiantController {
	
	@Autowired
	private EtudiantDAO etudao;

	
	public EtudiantDAO getEtudao() {
		return etudao;
	}

	public void setEtudao(EtudiantDAO etudao) {
		this.etudao = etudao;
	}
	
	@RequestMapping(value="/init", method=RequestMethod.GET)
	public String init(@ModelAttribute("etudiant") Etudiant etud) {
		etud = new Etudiant();
		return "etudiant";
	}

	@RequestMapping(value="/Ajout", method=RequestMethod.POST)
	public String AjoutEtudiant(@ModelAttribute("etu") Etudiant etudiant, Model model) {
//		model.addAttribute("idEtudiant", etudiant.getIdEtudiant());
//		model.addAttribute("nomEtudiant", etudiant.getNomEtudiant());
		etudao.AjoutEtudiant(etudiant);
		return "redirect:init";
		
	}
	
	@RequestMapping(value="/Supprimer", method= {RequestMethod.GET, RequestMethod.POST})
	public String SupprimerEtudiant(@ModelAttribute("etu") Etudiant etudiant) {		
		etudao.SupprimerEtudiant(etudiant);
		return "redirect:All";
		
	}
	
	@RequestMapping(value="/All", method=RequestMethod.GET)
	public String GetAllEtudiant(ModelMap model) {
		model.addAttribute("listeDesEtudiants", etudao.getAllEtudiants());
		return "etudiant";
		
	}
	
//	@RequestMapping(value="/SupprimerByID", method= {RequestMethod.GET, RequestMethod.POST})
//	public String SupprimerEtudiantByID(@ModelAttribute("etu") Etudiant etudiant) {		
//		etudao.SupprimerEtudiant(etudiant);
//		return "redirect:All";
//	}

}
