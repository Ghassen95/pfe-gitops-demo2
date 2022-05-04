package tn.esprit.spring;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.ContratServiceImpl;
import tn.esprit.spring.services.IContratService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest

public class TestContratServiceImpl {
	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);
	@Autowired
	IContratService contractServive;


	@Test
	public void testAddContract() throws ParseException {
		Contrat c = new Contrat((Long) 1L, (Date) Date.from(Instant.now()) , "CDI", (float) 2500);
		Contrat contractAdded = contractServive.addContract(c);
		Assertions.assertEquals(c.getTypeContrat(), contractAdded.getTypeContrat());
	}
	
	@Test
	public void testDeleteContract() {
		contractServive.deleteContract("1L");
		Assertions.assertNull(contractServive.retrieveContract("1L"));
	}
	
	// @Test
	public void testRetrieveAllContracts() {
		List<Contrat> contracts = contractServive.retrieveAllContracts();
		Assertions.assertEquals(0, contracts.size());
	}
	
	// @Test
	public void testUpdateContract() throws ParseException {

		Contrat c = new Contrat((Date) Date.from(Instant.now()) , "CDD", (float) 1500);
		Contrat contractUpdate = contractServive.updateContract(c);
		Assertions.assertEquals(c.getReference(), contractUpdate.getReference());
	}

	// @Test
	public void testRetrieveContract() {
		Contrat contractRetrieved = contractServive.retrieveContract("1");
		Assertions.assertEquals(2L, contractRetrieved.getReference());
	}


}
