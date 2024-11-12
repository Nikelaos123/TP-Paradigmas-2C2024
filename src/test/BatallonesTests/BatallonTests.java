package test.BatallonesTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unlam.paradigmas.tp2.personajes.Batallon;
import unlam.paradigmas.tp2.personajes.BatallonMagos;
import unlam.paradigmas.tp2.personajes.BatallonMortifagos;

class BatallonTests {

	Batallon batallonMagos;
	Batallon batallonMortifagos;
	
	@BeforeEach
	public void setUp() {
		batallonMagos = new BatallonMagos();
		batallonMortifagos = new BatallonMortifagos();
	}
 	
	@Test
	public void puedeCrearse() {

		assertNotNull(batallonMagos);
		assertNotNull(batallonMortifagos);
	}
	
	@Test
	public void batallonCompleto() {
		batallonMagos.generarBatallon();
		batallonMortifagos.generarBatallon();
		
		int cantMagosCreada = batallonMagos.getTotalCombatientes(), 
				cantMagosMaxima = batallonMagos.getMaxCombatientes(),
					cantMagosVivos = batallonMagos.getVivos();
		
		int cantMortifagosCreada = batallonMortifagos.getTotalCombatientes(), 
				cantMortifagosMaxima = batallonMortifagos.getMaxCombatientes(),
					cantMortifagosVivos = batallonMortifagos.getVivos();
		
		assertTrue(cantMagosCreada != 0 && cantMortifagosCreada != 0);
		assertTrue(cantMagosCreada == cantMagosMaxima && cantMagosMaxima == cantMagosVivos);
		assertTrue(cantMortifagosCreada == cantMortifagosMaxima && cantMortifagosMaxima == cantMortifagosVivos);
	}
	

}
