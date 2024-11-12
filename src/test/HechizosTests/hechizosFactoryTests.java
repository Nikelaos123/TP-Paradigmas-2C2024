package test.HechizosTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unlam.paradigmas.tp2.hechizos.CreadorHechizoAtaque;
import unlam.paradigmas.tp2.hechizos.CreadorHechizoDefensa;
import unlam.paradigmas.tp2.hechizos.CreadorHechizoSanacion;
import unlam.paradigmas.tp2.hechizos.Hechizo;
import unlam.paradigmas.tp2.hechizos.HechizoFactory;
import unlam.paradigmas.tp2.personajes.PersonajeFactory;
import unlam.paradigmas.tp2.personajes.Personaje;

class hechizosFactoryTests {

	HechizoFactory fabricaAtaque;
	HechizoFactory fabricaSanacion;
	HechizoFactory fabricaDefensa;
	
	@BeforeEach
	public void setUp() {
		fabricaAtaque = new CreadorHechizoAtaque();
		fabricaSanacion = new CreadorHechizoSanacion();
		fabricaDefensa = new CreadorHechizoDefensa();
	}
	
	@Test
	public void puedenCrearse() {
		
		assertNotNull(fabricaAtaque);
		assertNotNull(fabricaSanacion);
		assertNotNull(fabricaDefensa);
	}
	
	@Test
	public void puedenCrear() {
		
		assertNotNull(fabricaAtaque.crearHechizo());
		assertNotNull(fabricaSanacion.crearHechizo());
		assertNotNull(fabricaDefensa.crearHechizo());
	}
	
	@Test
	public void puedenCrearCorrectamente() {
		
		assertNotNull(fabricaAtaque.crearHechizo() instanceof Hechizo);
		assertNotNull(fabricaSanacion.crearHechizo() instanceof Hechizo);
		assertNotNull(fabricaDefensa.crearHechizo() instanceof Hechizo);
	}
	
	@Test
	public void puedenSerAgregados() {
		Personaje personajeTest = new PersonajeFactory().crearMago();
		int cantHechizosAnterior = personajeTest.getCantidadHechizos();
		
		assertTrue(cantHechizosAnterior > 0);
		
		personajeTest.agregarHechizo( fabricaSanacion.crearHechizo() );
		
		assertTrue(cantHechizosAnterior < personajeTest.getCantidadHechizos());
		
	}
	
	
	
	

}
