package com.adaming.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.restaurant.dao.IRoleDAO;
import com.adaming.restaurant.entity.Role;

@Service(value="roleService")
public class RoleService {
	
	@Autowired
	private IRoleDAO rdao;
	
	public void ajoutRoleService(Role r) {
		rdao.save(r);
	}
	
	public void supprimerRoleService(Role r) {
		rdao.delete(r);
	}
	
	public void MAJRoleService(Role r) {
		rdao.saveAndFlush(r);
	}
	
	public List<Role> consultRoleService() {
		return rdao.findAll();
	}
	
	public Role rechercheRoleIDService(long id) {
		return rdao.getOne(id);
	}

}
