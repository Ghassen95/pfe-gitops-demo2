package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {
	
	@Autowired
	EntrepriseRepository entrepriseRepository;
private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);
@Override
	public List<Entreprise> retrieveAllEntreprises() { 
		List<Entreprise> entreprises = null; 
		try {
			
			l.info("In Method retrieveAllEntreprises :");
			entreprises = (List<Entreprise>) entrepriseRepository.findAll(); 
			l.debug("connexion à la DB Ok :"); 
			for (Entreprise entreprise : entreprises) {
				l.debug("entreprise :" + entreprise.getRaisonSocial()); 
			} 
			l.info("Out of Method retrieveAllEntreprises with Success" + entreprises.size());
		}catch (Exception e) {
			l.error("Out of Method retrieveAllEntreprises with Errors : " + e); 
		}

		return entreprises;
	}
	@Override
	public Entreprise addEntreprise(Entreprise en) {
		
		Entreprise u_saved = null; 
		
		try {
			l.info("In Method addEntreprise :");
			// Log en début de la méthode 
			u_saved = entrepriseRepository.save(en); 
			// Log à la fin de la méthode 
			l.debug("connexion à la DB Ok :"); 
		} catch (Exception e) {
			// log ici : l....("error in addEntreprise() : " + e);
			l.error("error in addEntreprise() : " + e);
		}
		
		return u_saved; 
	}

	@Override 
	public Entreprise updateEntreprise(Entreprise en) {
		
		Entreprise entrepriseUpdated = null; 
		
		try {
			l.info("In Method updateEntreprise :"); 
			// Log en début de la méthode 
			entrepriseUpdated = entrepriseRepository.save(en); 
			//Log à la fin de la méthode 
			l.debug("connexion à la DB Ok :");
		} catch (Exception e) {
			// log ici : l....("error in updateEntreprise() : " + e);
			l.error("error in updateEntreprise() : " + e);
		}
		
		return entrepriseUpdated; 
	}

	@Override
	public void deleteEntreprise(String id) {
		
		try {
			l.info("In Method deleteEntreprise :");
			//Log en début de la méthode 
			entrepriseRepository.deleteById(Long.parseLong(id)); 
			//Log à la fin de la méthode 
			l.debug("connexion à la DB Ok :");
		} catch (Exception e) {
			// log ici : l....("error in deleteEntreprise() : " + e);
			l.error("error in deleteEntreprise() : " + e);
		}
		
	}

	@Override
	public Entreprise retrieveEntreprise(String id) {
		Entreprise en = null; 
		try {
			l.info("In Method retrieveEntreprise :");
			//Log en début de la méthode 
			en =  entrepriseRepository.findById(Long.parseLong(id)).get(); 
			// Log à la fin de la méthode 
			l.debug("connexion à la DB Ok :");
		} catch (Exception e) {
			//log ici : l....("error in retrieveEntreprise() : " + e);
			l.error("error in retrieveEntreprise() : " + e);
		}

		return en; 
	}

}
