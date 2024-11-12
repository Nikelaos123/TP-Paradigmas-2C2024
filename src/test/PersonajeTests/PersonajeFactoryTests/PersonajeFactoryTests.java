package test.PersonajeTests.PersonajeFactoryTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unlam.paradigmas.tp2.personajes.PersonajeFactory;
import unlam.paradigmas.tp2.personajes.magos.Mago;
import unlam.paradigmas.tp2.personajes.mortifagos.Mortifago;

class PersonajeFactoryTests {

	PersonajeFactory fabrica;
	
	@BeforeEach
	public void setUp() {
		fabrica = new PersonajeFactory();
	}
	
	@Test
	public void puedeCrearse() {
		assertNotNull(fabrica);
	}
	
	@Test
	public void puedeCrearMago() {
		Object objetoMago = fabrica.crearMago();
		
		assertNotNull(objetoMago);
		assertTrue(objetoMago instanceof Mago);
	}
	
	@Test
	public void puedeCrearMortifago() {
		Object objetoMortifago = fabrica.crearMortifago();
		
		assertNotNull(objetoMortifago);
		assertTrue(objetoMortifago instanceof Mortifago);
	}

}
