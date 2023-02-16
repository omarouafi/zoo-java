package zoo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.formation.ouafi.controlleur.Zoo;
import org.junit.jupiter.api.Test;

class ZooTests {
	private static Zoo controleur= Zoo.getInstance();

	@Test
	void testNourrir() {
		List<String> infos = controleur.getInfos();
 		assertEquals(5, infos.size());
		// Cage VIDE assertEquals("Cage [x=800, y=400]----je suis un(e) Lion je
		// m'appelle clarence j'ai 10 an(s) et je pèse 215.46666666666667 kg",
		// infos.get(0));

		assertEquals("Cage n° 4 Cage [x=300, y=300]----VIDE", infos.get(3));
		controleur.nourrir();
		infos = controleur.getInfos();
		assertEquals("Cage n° 1 Cage [x=800, y=400]----je suis un(e) Lion je m'appelle clarence j'ai 10 an(s) et je pèse 217.36666666666667 kg",
				infos.get(0));
	}

	@Test
	void testDevorer() {
		List<String> infos = controleur.getInfos();
		// 5 enregistrements
		assertEquals(5, infos.size());
		// cage vide , singe
		assertEquals("INCOMPATIBLE", controleur.devorer(3, 2));
		assertTrue(infos.get(2).contains(
				"Cage [x=500, y=480]----je suis un(e) Singe je m'appelle chita j'ai 4 an(s) et je pèse 38.0 kg"));
		assertTrue(infos.get(3).contains("Cage [x=300, y=300]----VIDE"));
		// singe , cage vide
		assertEquals("INCOMPATIBLE", controleur.devorer(2, 3));
		assertTrue(infos.get(2).contains("Cage [x=500, y=480]----je suis un(e) Singe je m'appelle chita j'ai 4 an(s) et je pèse 38.0 kg"));
		assertTrue(infos.get(3).contains("Cage [x=300, y=300]----VIDE"));
		// lion, cage vide
		assertEquals("INCOMPATIBLE", controleur.devorer(0, 3));
		assertTrue(infos.get(0).contains("Cage [x=800, y=400]----je suis un(e) Lion je m'appelle clarence j'ai 10 an(s)"));
		assertTrue(infos.get(3).contains("Cage [x=300, y=300]----VIDE"));
		// lion, singe
		assertEquals("INCOMPATIBLE", controleur.devorer(0, 2));
		assertTrue(infos.get(0).contains("Cage [x=800, y=400]----je suis un(e) Lion je m'appelle clarence j'ai 10 an(s)"));
		assertTrue(infos.get(2).contains("Cage [x=500, y=480]----je suis un(e) Singe je m'appelle chita j'ai 4 an(s) et je pèse 38.0 kg"));
		// singe , gazelle
		assertEquals("Je n'aime pas ça", controleur.devorer(2, 1));
		assertTrue(infos.get(1).contains(
				"Cage [x=200, y=400]----je suis un(e) Gazelle je m'appelle GAGAG j'ai 5 an(s) et je pèse 135.2 kg et mes cornes font 34 cm"));
		assertTrue(infos.get(2).contains("Cage [x=500, y=480]----je suis un(e) Singe je m'appelle chita j'ai 4 an(s) et je pèse 38.0 kg"));
		// lion , gazelle
		assertEquals("Miam miam", controleur.devorer(0, 1));
		infos = controleur.getInfos();
		assertTrue(infos.get(0).contains("Lion"));
		assertTrue(infos.get(0).contains("215.46666666666667 kg"));
		assertTrue(infos.get(1).contains("VIDE"));
	}

	@Test
	void testGetInfos() {
		List<String> infos = null;

		infos = controleur.getInfos();
		assertEquals(5, infos.size());
		assertTrue(infos.get(0).contains("Cage [x=800, y=400]----je suis un(e) Lion je m'appelle clarence "));
		assertTrue(infos.get(infos.size() - 1).contains("Cage [x=700, y=230]----je suis un(e) Gazelle"));

	}

}
