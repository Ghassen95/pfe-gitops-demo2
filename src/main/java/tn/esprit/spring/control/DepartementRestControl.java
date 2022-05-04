package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IDepartementService;

@RestController
public class DepartementRestControl {
	
	@Autowired
	IDepartementService depService;
	// URL : http://localhost:6868/timesheet-devops/retrieve-all-deps
	@GetMapping("/retrieve-all-deps")
	public List<Departement> retrieveAllDeps() {
		List<Departement> list = depService.retrieveAllDeps();
		return list;
	}
	// http://localhost:6868/timesheet-devops/retrieve-dep/{dep-id}
	@GetMapping("/retrieve-dep/{dep-id}")
	public Departement retrieveUser(@PathVariable("dep-id") String depId) {
		return depService.retrieveDep(depId);
	}
	// Ajouter departement : http://localhost:6868/timesheet-devops/add-dep 
	@PostMapping("/add-dep")
	public Departement addUser(@RequestBody Departement d) {
		Departement departement = depService.addDep(d); 
		return departement;
	}
	// Supprimer Departement : 
	// http://localhost:6868/timesheet-devops/remove-dep/{dep-id}
	@DeleteMapping("/remove-dep/{dep-id}") 
	public void removeDep(@PathVariable("dep-id") String depId) { 
		depService.deleteDep(depId);
	} 
	// Modifier Departement 
	// http://localhost:6868/timesheet-devops/modify-dep 
	@PutMapping("/modify-dep") 
	public Departement updateDep(@RequestBody Departement dep) {
		return depService.updateDep(dep);
	}
	 



}
