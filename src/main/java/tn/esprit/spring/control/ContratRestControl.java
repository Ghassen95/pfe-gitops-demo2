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

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;

@RestController
public class ContratRestControl {
	
	@Autowired
	IContratService contractService;
	// URL : http://localhost:6868/timesheet-devops/retrieve-all-contracts
	@GetMapping("/retrieve-all-contracts")
	public List<Contrat> retrieveAllContracts() {
		List<Contrat> list = contractService.retrieveAllContracts();
		return list;
	}
	// http://localhost:6868/timesheet-devops/retrieve-contract/{contract-id}
	@GetMapping("/retrieve-contract/{contract-id}")
	public Contrat retrieveContract(@PathVariable("contract-id") String contractId) {
		return contractService.retrieveContract(contractId);
	}
	// http://localhost:6868/timesheet-devops/add-contract
	@PostMapping("/add-contract")
	public Contrat addContract(@RequestBody Contrat c) {
		Contrat contract = contractService.addContract(c); 
		return contract;
	}
	// http://localhost:6868/timesheet-devops/remove-contract/{contract-id}
	@DeleteMapping("/remove-contract/{contract-id}") 
	public void removeContract(@PathVariable("contract-id") String contractId) { 
		contractService.deleteContract(contractId);
	} 
	// http://localhost:6868/timesheet-devops/modify-contract
	@PutMapping("/modify-contract") 
	public Contrat updateContract(@RequestBody Contrat c) {
		return contractService.updateContract(c);
	}
	 



}
