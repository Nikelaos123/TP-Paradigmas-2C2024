package test.PersonajeTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unlam.paradigmas.tp2.personajes.*;
import unlam.paradigmas.tp2.personajes.magos.*;
import unlam.paradigmas.tp2.personajes.mortifagos.*;

class AurorTests {

	//Tipo Mago para verificar Polimorfismo
	private Mago personaje;
	
	@BeforeEach
	public void setUp() {
		personaje = new Auror("Raul");
	}
	
	@Test
	public void puedeCrear() {
		assertNotNull(personaje);
	}
	
	@Test
	public void getters() {
		assertNotNull(personaje.getNombre());
		assertNotNull(personaje.getMana());
		assertNotNull(personaje.getVida());
		assertNotNull(personaje.getVivo());
		assertNotNull(personaje.getDefensa());
	}
	
	@Test
	public void reportarse() {
		assertNotNull(personaje.darReporteCompleto());
		
	} 
	
	@Test
	public void igualarse() {
		assertEquals(personaje, new Auror("Raul"));
		assertNotEquals(personaje, new Auror("José"));
	}
	
	//Aplica tambien para recibirAtaque
	@Test
	public void verificarMuerte() {
		personaje.recibirAtaque(Double.MAX_VALUE);
		assertFalse(personaje.getVivo());
		
		Batallon batallonEnemigo = new BatallonMortifagos();
		batallonEnemigo.generarBatallon();
		assertFalse(personaje.atacar(batallonEnemigo));
	}
	
	@Test
	public void noAtacarSinEnemigos() {
		Batallon batallonEnemigo = new BatallonMortifagos();
		
		assertFalse(personaje.atacar(batallonEnemigo));
	}
	
	//Aplica tambien a recibirMana()
	@Test
	public void descanso() {
		double manaAnterior = personaje.getMana();
		personaje.descansar();
		assertTrue(manaAnterior < personaje.getMana());
	}
	
	@Test  
	public void recibirDefensa() {
		double defensaAnterior = personaje.getDefensa();
		personaje.recibirDefensa(50);
		assertTrue(defensaAnterior < personaje.getDefensa());
	}
	
	@Test  
	public void recibirVida() {
		double vidaAnterior = personaje.getVida();
		personaje.recibirSanacion(50);
		assertTrue(vidaAnterior < personaje.getVida());
	}
	
	
	
	
}



