package zoo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.formation.ouafi.model.Gazelle;
import org.formation.ouafi.model.Mangeable;
import org.formation.ouafi.model.Singe;
import org.formation.ouafi.model.technique.BeurkException;

class SingeTests {
	private static Singe moi = new Singe("Cheeta",3,35.0);
	@Test
	void testManger() {
		double poids = 0;
		
		poids = moi.getPoids();
		
		assertEquals(35.0, poids);
		moi.manger();
		assertEquals(poids+0.35, moi.getPoids());
		for(int i = 0; i < 200; i++) {
			moi.manger();
		}
		assertTrue(moi.getPoids() < 45.0);
		moi.setPoids(poids);
	}

	@Test
	void testDormir() {
		double poids = 0;
		
		poids = moi.getPoids();
		
		assertEquals(35.0, poids);
		moi.dormir();
		assertEquals(poids-0.12, moi.getPoids());
		for(int i = 0; i < 200; i++) {
			moi.dormir();
		}
		assertTrue(moi.getPoids() >= 0);
		moi.setPoids(poids);
	}

	@Test
	void testMangerMangeable() {
		Mangeable autre = new Gazelle();
		Exception exc = null;
		
		exc = assertThrows(BeurkException.class, () -> {moi.manger(autre);});
		assertEquals("Je n'aime pas ça", exc.getMessage());
	}

}
