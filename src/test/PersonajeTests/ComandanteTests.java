package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unlam.paradigmas.tp2.personajes.*;
import unlam.paradigmas.tp2.personajes.magos.*;
import unlam.paradigmas.tp2.personajes.mortifagos.*;

class ComandanteTests {

	//Tipo Mortifago para verificar Polimorfismo
	private Mortifago personaje;
	
	@BeforeEach
	public void setUp() {
		personaje = new Comandante("Raul");
	}
	
	@Test
	void puedeCrear() {
		assertNotNull(personaje);
	}
	
	@Test
	void getters() {
		assertNotNull(personaje.getNombre());
		assertNotNull(personaje.getMana());
		assertNotNull(personaje.getVida());
		assertNotNull(personaje.getVivo());
		assertNotNull(personaje.getDefensa());
	}
	
	@Test
	void reportarse() {
		assertNotNull(personaje.darReporteCompleto());
		
	} 
	
	@Test
	void igualarse() {
		assertEquals(personaje, new Comandante("Raul"));
		assertNotEquals(personaje, new Comandante("José"));
	}
	
	//Aplica tambien para recibirAtaque
	@Test
	void verificarMuerte() {
		personaje.recibirAtaque(Double.MAX_VALUE);
		assertFalse(personaje.getVivo());
		
		Batallon batallonEnemigo = new BatallonMortifagos();
		batallonEnemigo.generarBatallon();
		assertFalse(personaje.atacar(batallonEnemigo));
	}
	
	@Test
	void noAtacarSinEnemigos() {
		Batallon batallonEnemigo = new BatallonMortifagos();
		
		assertFalse(personaje.atacar(batallonEnemigo));
	}
	
	//Aplica tambien a recibirMana()
	@Test
	void descanso() {
		double manaAnterior = personaje.getMana();
		personaje.descansar();
		assertTrue(manaAnterior < personaje.getMana());
	}
	
	@Test  
	void recibirDefensa() {
		double defensaAnterior = personaje.getDefensa();
		personaje.recibirDefensa(50);
		assertTrue(defensaAnterior < personaje.getDefensa());
	}
	
	@Test  
	void recibirVida() {
		double vidaAnterior = personaje.getVida();
		personaje.recibirSanacion(50);
		assertTrue(vidaAnterior < personaje.getVida());
	}
	
	
	
	
}



