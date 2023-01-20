package zoo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.formation.ouafi.model.Gazelle;
import org.formation.ouafi.model.Mangeable;
import org.formation.ouafi.model.technique.BeurkException;

class GazelleTests {

	private static Gazelle moi = new Gazelle("Moaa",3,60,10);

	@Test
	void testManger() {
		double poids = 0;
		int cornes = 0;
		
		poids = moi.getPoids();
		cornes = moi.getLgCornes();
		
		assertEquals(60.0, poids);
		assertEquals(10, cornes);
		moi.manger();
		assertEquals(poids+0.4, moi.getPoids());
		assertEquals(cornes+2, moi.getLgCornes());
		for(int i = 0; i < 200; i++) {
			moi.manger();
		}
		assertTrue(moi.getPoids() < 150.0);
		moi.setPoids(poids);
		moi.setLgCornes(cornes);
	}

	@Test
	void testDormir() {
		double poids = 0;
		
		poids = moi.getPoids();
		
		assertEquals(60.0, poids);
		moi.dormir();
		assertEquals(poids-0.15, moi.getPoids());
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
