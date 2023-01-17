package zoo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.formation.ouafi.model.Gazelle;
import org.formation.ouafi.model.Lion;

class LionTests {
	private static Lion leLion = new Lion("Gerard",12,  100);
	@Test
	void testManger() {
		double poids = 0;
		poids = leLion.getPoids();
		
		assertEquals(100.0, poids);
		leLion.manger();
		assertEquals(poids+1.9, leLion.getPoids());
		for(int i = 0; i < 200; i++) {
			leLion.manger();
		}
		assertTrue(leLion.getPoids() < 230.0);
//		leLion.setPoids(-10);
//		assertEquals(poids+1.9, leLion.getPoids());
//		leLion.setPoids(266);
//		assertEquals(poids+1.9, leLion.getPoids());
//		leLion.setPoids(poids);
	}

	@SuppressWarnings("deprecation")
	@Test
	void testMangerGazelle() {
		double lePoids = 0;
		Gazelle gaz = new Gazelle("lady gaga",4,  60, 10);
		lePoids = leLion.getPoids();
		
		assertEquals(100.0, lePoids);
		leLion.manger(gaz);
		assertEquals(lePoids+(gaz.getPoids()/3), leLion.getPoids());
		leLion.setPoids(lePoids);
	}

	@Test
	void testCrier() {
		double lePoids = 0;
		lePoids = leLion.getPoids();
		assertEquals(100.0, lePoids);
		assertEquals("je rugis!!!! woaw!!!!!", leLion.crier());
		//perte de poids!!!!
		assertEquals(lePoids-0.003, leLion.getPoids());
		leLion.setPoids(lePoids);
	}

}
