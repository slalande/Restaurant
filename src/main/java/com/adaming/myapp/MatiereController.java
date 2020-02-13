package com.adaming.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.myapp.DAO.MatiereDAO;
import com.adaming.myapp.Entity.Etudiant;
import com.adaming.myapp.Entity.Matiere;

@Controller
@RequestMapping(value="/Matiere")
public class MatiereController {
	
	@Autowired
	private MatiereDAO matdao;
	
	
	public MatiereDAO getMatdao() {
		return matdao;
	}

	public void setMatdao(MatiereDAO matdao) {
		this.matdao = matdao;
	}
	
	@RequestMapping(value="/init", method=RequestMethod.GET)
	public String init(@ModelAttribute("matiere") Matiere mat) {
		mat = new Matiere();
		return "matiere";
	}

	@RequestMapping(value="/Ajout", method = RequestMethod.POST)
	public String AjoutMatiere(@ModelAttribute("mat") Matiere matiere, Model model) {  // mat sert à appeler un nouvel objet de type matière
//		model.addAttribute("idMatiere", matiere.getIdMatiere());
//		model.addAttribute("nomMatiere", matiere.getNomMatiere());
		matdao.AjoutMatiere(matiere);
		
		return "redirect:init";		
	}
	
	@RequestMapping(value="/Supprimer", method = RequestMethod.POST)
	public String SupprimerMatiere(@ModelAttribute("mat") Matiere matiere) {  
		matdao.SupprimerMatiere(matiere);
		
		return "redirect:All";		
	}
	
	@RequestMapping(value="/All", method = RequestMethod.GET)
	public String GetAllMatiere(ModelMap model) { 
		model.addAttribute("listeDesMatieres", matdao.getAllMatieres());		
		return "matiere";		
	}
	
//	@RequestMapping(value="/SupprimerByID", method= {RequestMethod.GET, RequestMethod.POST})
//	public String SupprimerMatiereByID(@ModelAttribute("mat") Matiere matiere) {		
//		matdao.supprimerMatiereByID(matiere);
//		return "redirect:All";
//	}
		
		
	

}
