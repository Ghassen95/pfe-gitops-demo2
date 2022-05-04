package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Entreprise;

public interface IEntrepriseService {
	List<Entreprise> retrieveAllEntreprises(); 
	Entreprise addEntreprise(Entreprise en);
	void deleteEntreprise(String id);
	Entreprise updateEntreprise(Entreprise en);
	Entreprise retrieveEntreprise(String id);
}
