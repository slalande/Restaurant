package com.adaming.myapp.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adaming.myapp.Entity.User;

@Repository
public class UserDAO {
	

	@Autowired
	SessionFactory sf;
	
	public void AjoutUser(User u) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.save(u);
		sess.getTransaction().commit();
		sess.close();
	}
	
	public void SupprimerUser(User u) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.delete(u);
		sess.getTransaction().commit();
		sess.close();
	}
	
	public List<User> getAllUser() {
		final Session sess = sf.openSession();		
		final Criteria crit = sess.createCriteria(User.class); 		
		return crit.list();
	}

}
