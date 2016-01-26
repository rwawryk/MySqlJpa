package edu.starterkit.app;

import java.util.List;

/* STEP 1. Import required packages
 * Import the packages: Requires that you include the packages containing the JDBC classes needed
 * for database programming. Most often, using import java.persistance.* will suffice.
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.starterkit.model.Country;


public class AppJpa {
	private static final String PERSISTENCE_UNIT_NAME = "MySqlJpa";

	public static void main(String[] args) {
		/*
		 * STEP 2: Create entity manager factory 
		 * Create a persistence unit by providing the same unique name which we provide 
		 * for persistence-unit in persistent.xml file. 
		 */
		System.out.println("Creating entity manager factory...");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		
		/*
		 * STEP 3: Create entity manager
		 * The factory object will create the entity manager instance
		 */
		System.out.println("Creating entity manager...");
		EntityManager em = factory.createEntityManager();
		
		/* STEP 4: Create named query
		 * Named query to read the existing entries and write to console
		 */
		System.out.println("Creating named query...");
		Query q = em.createNamedQuery("Country.findAll");
		List<Country> result = q.getResultList();
		for (Country country : result) {
			System.out.println(country);
		}
		System.out.println("Size: " + result.size());
	}
}