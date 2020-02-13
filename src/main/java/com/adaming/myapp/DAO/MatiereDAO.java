package com.adaming.myapp.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adaming.myapp.Entity.Matiere;

@Repository
public class MatiereDAO {
	
	@Autowired
	SessionFactory sf;
	
	public void AjoutMatiere(Matiere mat) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.save(mat);
		sess.getTransaction().commit();
		sess.close();
	}
	
	public void SupprimerMatiere(Matiere mat) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.delete(mat);
		sess.getTransaction().commit();
		sess.close();
	}
	
	public List<Matiere> getAllMatieres() {
		final Session sess = sf.openSession();		
		final Criteria crit = sess.createCriteria(Matiere.class); 		
		return crit.list();
	}
	
//	public void supprimerMatiereByID(Matiere mat) {
//		for (int i=0; i<matieres.size(); i++) {
//			if(matieres.get(i).getIdMatiere() == mat.getIdMatiere())  {
//				matieres.remove(i);
//			}
//		}
//	}

	

}
