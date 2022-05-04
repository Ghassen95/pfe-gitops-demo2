package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {

	@Autowired
	ContratRepository contractRpo;
	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);

	@Override
	public List<Contrat> retrieveAllContracts() {
		List<Contrat> contracts = null;
		try {

			l.info("In Method retrieveAllContracts:");
			contracts = (List<Contrat>) contractRpo.findAll();
			l.debug("connexion à la DB Ok :");
			for (Contrat c : contracts) {
				l.debug("contrat :" + c.getReference());
			}
			l.info("Out of Method retrieveAllContracts with Success" + contracts.size());
		} catch (Exception e) {
			l.error("Out of Method retrieveAllContracts with Errors : " + e);
		}

		return contracts;
	}

	@Override
	public Contrat addContract(Contrat c) {
		Contrat c_saved = null;

		try {
			l.info("In Method addContract :");
			// TODO Log à ajouter en début de la méthode
			c_saved = contractRpo.save(c);
			// TODO Log à ajouter à la fin de la méthode
			l.debug("connexion à la DB Ok :");
		} catch (Exception e) {
			// TODO log ici : l....("error in addContract() : " + e);
			l.error("error in addContract() : " + e);
		}

		return c_saved;
	}

	@Override
	public void deleteContract(String id) {
		try {
			l.info("In Method deleteContract :");
			// TODO Log à ajouter en début de la méthode
			contractRpo.deleteById(Long.parseLong(id));
			// TODO Log à ajouter à la fin de la méthode
			l.debug("connexion à la DB Ok :");
		} catch (Exception e) {
			// TODO log ici : l....("error in deleteUser() : " + e);
			l.error("error in deleteContract() : " + e);
		}

	}

	@Override
	public Contrat updateContract(Contrat c) {
		Contrat contractUpdated = null;

		try {
			l.info("In Method updateContract :");
			// TODO Log à ajouter en début de la méthode
			contractUpdated = contractRpo.save(c);
			// TODO Log à ajouter à la fin de la méthode
			l.debug("connexion à la DB Ok :");
		} catch (Exception e) {
			// TODO log ici : l....("error in updateContract() : " + e);
			l.error("error in updateContract() : " + e);
		}

		return contractUpdated;
	}

	@Override
	public Contrat retrieveContract(String id) {
		Contrat c = null;
		try {
			l.info("In Method retrieveContract :");
			// TODO Log à ajouter en début de la méthode
			c = contractRpo.findById(Long.parseLong(id)).get();
			// TODO Log à ajouter à la fin de la méthode
			l.debug("connexion à la DB Ok :");
		} catch (Exception e) {
			// TODO log ici : l....("error in retrieveContract() : " + e);
			l.error("error in retrieveConract() : " + e);
		}

		return c;
	}

}
