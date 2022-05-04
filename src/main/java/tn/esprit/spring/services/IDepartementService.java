package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;


public interface IDepartementService {
	List<Departement> retrieveAllDeps(); 
	Departement addDep(Departement d);
	void deleteDep(String id);
	Departement updateDep(Departement d);
	Departement retrieveDep(String id);

}
