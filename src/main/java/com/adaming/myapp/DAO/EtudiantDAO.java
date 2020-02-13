package com.adaming.myapp.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adaming.myapp.Entity.Etudiant;

@Repository
public class EtudiantDAO {
	
//	List<Etudiant> etudiants = new ArrayList<Etudiant>();
	@Autowired
	SessionFactory sf;
	
	public void AjoutEtudiant(Etudiant etu) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.save(etu);
		sess.getTransaction().commit();
		sess.close();
	}
	
	public void SupprimerEtudiant(Etudiant etu) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		sess.delete(etu);
		sess.getTransaction().commit();
		sess.close();
	}
	
	public List<Etudiant> getAllEtudiants() {
		final Session sess = sf.openSession();		
		final Criteria crit = sess.createCriteria(Etudiant.class); 		
		return crit.list();
	}
	
	public Etudiant getByID(Long id) {
		Session sess = sf.openSession();
		sess.beginTransaction();
		Etudiant etu = (Etudiant) sess.get(Etudiant.class,id);
		return etu;
		
	}
	
//	public void supprimerEtudiantByID(Etudiant etu) {
//		for (int i=0; i<etudiants.size(); i++) {
//			if(etudiants.get(i).getIdEtudiant() == etu.getIdEtudiant())  {
//				etudiants.remove(i);
//			}
//		}
//	}

}
