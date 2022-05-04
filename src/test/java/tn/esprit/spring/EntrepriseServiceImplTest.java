package tn.esprit.spring;

import java.text.ParseException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {
	@Autowired
	IEntrepriseService enp;
	
	//@Test
	public void testRetrieveAllEntreprises(){
		List<Entreprise> entreprises = enp.retrieveAllEntreprises();
		Assertions.assertEquals(6,entreprises.size());
	}

	@Test
	public void testAddEntreprise() throws ParseException{
		
		Entreprise en = new Entreprise("Amen Bank","FCD457", null);
		Entreprise entrepriseAdded = enp.addEntreprise(en);
		Assertions.assertEquals(en.getRaisonSocial(),entrepriseAdded.getRaisonSocial());
	}
	
	//@Test
	public void testUpdateEntreprise() throws ParseException{
		
		Entreprise en = new Entreprise(2L,"Amen Bank","FCD45790FAPP", null);
		Entreprise entrepriseUpdate = enp.updateEntreprise(en);
		Assertions.assertEquals(en.getRaisonSocial(), entrepriseUpdate.getRaisonSocial());
	}
	
	//@Test
	public void testRetrieveEntreprise(){
		Entreprise entrepriseRetrieved = enp.retrieveEntreprise("2");
		Assertions.assertEquals(2L,entrepriseRetrieved.getId());
	}

	
	//@Test
	public void testDeleteEntreprise(){
		enp.deleteEntreprise("5");
		Assertions.assertNull(enp.retrieveEntreprise("5"));
	}

}
