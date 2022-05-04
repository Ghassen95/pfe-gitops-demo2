package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

@Service
public class DepartementServiceImpl implements IDepartementService {

	@Autowired
	DepartementRepository depRpo;
	private static final Logger l = LogManager.getLogger(DepartementServiceImpl.class);

	@Override
	public List<Departement> retrieveAllDeps() {
		List<Departement> deps = null;
		try {

			l.info("In Method retrieveAllDeps:");
			deps = (List<Departement>) depRpo.findAll();
			l.debug("connexion à la DB Ok :");
			for (Departement dep : deps) {
				l.debug("user :" + dep.getName());
			}
			l.info("Out of Method retrieveAllUsers with Success" + deps.size());
		} catch (Exception e) {
			l.error("Out of Method retrieveAllUsers with Errors : " + e);
		}

		return deps;
	}

	@Override
	public Departement addDep(Departement d) {
		Departement d_saved = null;

		try {
			l.info("In Method addDep :");
			// TODO Log à ajouter en début de la méthode
			d_saved = depRpo.save(d);
			// TODO Log à ajouter à la fin de la méthode
			l.debug("connexion à la DB Ok :");
		} catch (Exception e) {
			// TODO log ici : l....("error in addUser() : " + e);
			l.error("error in addDep() : " + e);
		}

		return d_saved;
	}

	@Override
	public void deleteDep(String id) {
		try {
			l.info("In Method deleteUser :");
			// TODO Log à ajouter en début de la méthode
			depRpo.deleteById(Long.parseLong(id));
			// TODO Log à ajouter à la fin de la méthode
			l.debug("connexion à la DB Ok :");
		} catch (Exception e) {
			// TODO log ici : l....("error in deleteUser() : " + e);
			l.error("error in deleteUser() : " + e);
		}

	}

	@Override
	public Departement updateDep(Departement d) {
		Departement departementUpdated = null;

		try {
			l.info("In Method updateUser :");
			// TODO Log à ajouter en début de la méthode
			departementUpdated = depRpo.save(d);
			// TODO Log à ajouter à la fin de la méthode
			l.debug("connexion à la DB Ok :");
		} catch (Exception e) {
			// TODO log ici : l....("error in updateUser() : " + e);
			l.error("error in updateUser() : " + e);
		}

		return departementUpdated;
	}

	@Override
	public Departement retrieveDep(String id) {
		Departement d = null;
		try {
			l.info("In Method retrieveUser :");
			// TODO Log à ajouter en début de la méthode
			d = depRpo.findById(Long.parseLong(id)).get();
			// TODO Log à ajouter à la fin de la méthode
			l.debug("connexion à la DB Ok :");
		} catch (Exception e) {
			// TODO log ici : l....("error in retrieveUser() : " + e);
			l.error("error in retrieveUser() : " + e);
		}

		return d;
	}

}
