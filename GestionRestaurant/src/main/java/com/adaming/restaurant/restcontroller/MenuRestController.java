package com.adaming.restaurant.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.restaurant.entity.Menu;
import com.adaming.restaurant.service.MenuService;
@CrossOrigin
@RestController
@RequestMapping(value="/MenuRest")
public class MenuRestController {
	
	@Autowired
	private MenuService mserv;

	
	public MenuService getMserv() {
		return mserv;
	}

	public void setMserv(MenuService mserv) {
		this.mserv = mserv;
	}

	@RequestMapping(value="/Ajout", method=RequestMethod.POST)
//	public ResponseEntity<Object> AjoutMenu(@RequestBody Menu m) {
//		mserv.AjoutMenuService(m);
//		return new ResponseEntity<Object>("Menu ajouté avec succès", HttpStatus.OK);
	public void AjoutMenu(@RequestBody Menu m) {
		mserv.AjoutMenuService(m);
	}
	
	@RequestMapping(value="/Supprimer", method=RequestMethod.POST)
	public ResponseEntity<Object> SupprimerMenu(@RequestBody Menu m) {
		mserv.SupprimerMenuService(m);
		return new ResponseEntity<Object>("menu supprimé avec succès", HttpStatus.OK);

	}
	
	@RequestMapping(value="/ByID/{id}", method=RequestMethod.GET)
//	public ResponseEntity<Object> GetMenuByID(@PathVariable("id") String id) {
//		return new ResponseEntity<Object>("Le menu est :" + mserv.GetMenuByID(Long.parseLong(id)), HttpStatus.OK);
	public Menu GetMenuByID(@PathVariable("id") String id) {
		return mserv.GetMenuByID(Long.parseLong(id));
	}
	
	@RequestMapping(value="/All", method=RequestMethod.GET)
//	public ResponseEntity<Object> getAllMenu() {
//		return new ResponseEntity<Object>("Les menus sont :" + mserv.GetAllMenuService(), HttpStatus.OK);
	public List<Menu> getAllMenus() {
		return mserv.GetAllMenuService();
	}
	
	@RequestMapping(value="/SupByID/{id}", method=RequestMethod.DELETE)
//	public ResponseEntity<Object> SupMenuByID(@PathVariable("id") String id, @RequestBody Menu m) {
//		mserv.SupMenuByID(Long.parseLong(id));
//		return new ResponseEntity<Object>("Menu supprimé avec succès", HttpStatus.OK);
	public void SupMenuByID(@PathVariable("id") String id) {
		mserv.SupMenuByID(Long.parseLong(id));
	}
	
	

}
