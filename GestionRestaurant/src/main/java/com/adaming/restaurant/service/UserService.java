package com.adaming.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.restaurant.dao.IUserDAO;
import com.adaming.restaurant.entity.User;

@Service(value="userService")
public class UserService {
	
	@Autowired
	private IUserDAO udao;
	
	public void ajoutUserService(User u) {
		udao.save(u);
	}
	
	public void supprimerUserService(User u) {
		udao.delete(u);;
	}
	
	public void MAJUserService(User u) {
		udao.saveAndFlush(u);
	}
	
	public List<User> consultUserService() {
		return udao.findAll();
	}
	
	public User rechercheUserIDService(long id) {
		return udao.getOne(id);
	}

}
