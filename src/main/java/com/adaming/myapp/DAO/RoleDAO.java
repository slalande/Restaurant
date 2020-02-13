package com.adaming.myapp.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adaming.myapp.Entity.Role;

@Repository
public class RoleDAO {
	
	@Autowired
	SessionFactory sf;
	
	public void AjoutRole(Role r) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.save(r);
		sess.getTransaction().commit();
		sess.close();
	}
	
	public void SupprimerUser(Role r) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.delete(r);
		sess.getTransaction().commit();
		sess.close();
	}
	
	public List<Role> getAllRole() {
		final Session sess = sf.openSession();		
		final Criteria crit = sess.createCriteria(Role.class); 		
		return crit.list();
	}


}
