package zoo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.formation.ouafi.controlleur.Zoo;
/**
 * Ces tests fonctionnent avec ou sans fichier de données.
 * On a 5 cages dont la 3ieme est vide
 * 
Cage [x=101, y=201]----je suis un(e) Singe je m'appelle Cheeta j'ai 2 an(s) et je pèse 25.0 kg
Cage [x=100, y=50]----je suis un(e) Lion je m'appelle Simba j'ai 3 an(s) et je pèse 20.0 kg
Cage [x=150, y=250]----VIDE
Cage [x=90, y=230]----je suis un(e) Gazelle je m'appelle Lady Gaga j'ai 20 an(s) et je pèse 75.0 kg et mes cornes font 10 cm
Cage [x=60, y=100]----je suis un(e) Singe je m'appelle Baloo j'ai 30 an(s) et je pèse 30.0 kg
A TABLE!!!
Cage [x=101, y=201]----je suis un(e) Singe je m'appelle Cheeta j'ai 2 an(s) et je pèse 25.35 kg
Cage [x=100, y=50]----je suis un(e) Lion je m'appelle Simba j'ai 3 an(s) et je pèse 21.9 kg
Cage [x=150, y=250]----VIDE
Cage [x=90, y=230]----je suis un(e) Gazelle je m'appelle Lady Gaga j'ai 20 an(s) et je pèse 75.4 kg et mes cornes font 12 cm
Cage [x=60, y=100]----je suis un(e) Singe je m'appelle Baloo j'ai 30 an(s) et je pèse 30.8 kg

 *
 * @author jacques
 *
 */
class ZooTests {
	private static Zoo controleur;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		controleur = new Zoo();
	}

	@Test
	void testNourrir() {
		List<String> infos =controleur.getInfos(); 
		assertEquals(5, infos.size());
		assertEquals("Cage [x=101, y=201]----je suis un(e) Singe je m'appelle Cheeta j'ai 2 an(s) et je pèse 25.0 kg", infos.get(0));
		//Cage VIDE
		assertEquals("Cage [x=150, y=250]----VIDE", infos.get(2));
		controleur.nourrir();
		infos = controleur.getInfos();
		assertEquals("Cage [x=101, y=201]----je suis un(e) Singe je m'appelle Cheeta j'ai 2 an(s) et je pèse 25.35 kg", infos.get(0));
	}

	@Test
	void testDevorer() {
		List<String> infos =controleur.getInfos(); 
		//5 enregistrements
		assertEquals(5, infos.size());
		//cage vide , singe
		assertEquals("INCOMPATIBLE",controleur.devorer(2,0));
		assertEquals("Cage [x=101, y=201]----je suis un(e) Singe je m'appelle Cheeta j'ai 2 an(s) et je pèse 25.0 kg", infos.get(0));
		assertEquals("Cage [x=150, y=250]----VIDE", infos.get(2));
		//singe , cage vide
		assertEquals("INCOMPATIBLE",controleur.devorer(0,2));
		assertEquals("Cage [x=101, y=201]----je suis un(e) Singe je m'appelle Cheeta j'ai 2 an(s) et je pèse 25.0 kg", infos.get(0));
		assertEquals("Cage [x=150, y=250]----VIDE", infos.get(2));
		//lion, cage vide
		assertEquals("INCOMPATIBLE",controleur.devorer(1,2));
		assertEquals("Cage [x=100, y=50]----je suis un(e) Lion je m'appelle Simba j'ai 3 an(s) et je pèse 20.0 kg", infos.get(1));
		assertEquals("Cage [x=150, y=250]----VIDE", infos.get(2));
		//lion, singe
		assertEquals("INCOMPATIBLE",controleur.devorer(1,0));
		assertEquals("Cage [x=100, y=50]----je suis un(e) Lion je m'appelle Simba j'ai 3 an(s) et je pèse 20.0 kg", infos.get(1));
		assertEquals("Cage [x=101, y=201]----je suis un(e) Singe je m'appelle Cheeta j'ai 2 an(s) et je pèse 25.0 kg", infos.get(0));
		// singe , gazelle
		assertEquals("Je n'aime pas ça",controleur.devorer(0,3));
		assertEquals("Cage [x=90, y=230]----je suis un(e) Gazelle je m'appelle Lady Gaga j'ai 20 an(s) et je pèse 75.0 kg et mes cornes font 10 cm", infos.get(3));
		assertEquals("Cage [x=101, y=201]----je suis un(e) Singe je m'appelle Cheeta j'ai 2 an(s) et je pèse 25.0 kg", infos.get(0));
		// lion , gazelle
		assertEquals("Miam miam",controleur.devorer(1,3));
		infos = controleur.getInfos();
		assertTrue(infos.get(1).contains("Lion"));
		System.out.println(infos.get(1));
		assertTrue(infos.get(1).contains("45.0 kg"));
		assertTrue(infos.get(3).contains("VIDE"));
	}

	@Test
	void testGetInfos() {
		List<String> infos = null;

		infos = controleur.getInfos();
		assertEquals(5, infos.size());
		assertTrue(infos.get(0).startsWith("Cage [x=101, y=201]----je suis un(e) Singe je m'appelle Cheeta"));
		assertTrue(infos.get(infos.size()-1).startsWith("Cage [x=60, y=100]----je suis un(e) Singe je m'appelle Baloo"));

	}

}
