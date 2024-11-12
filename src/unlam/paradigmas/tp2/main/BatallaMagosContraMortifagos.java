package unlam.paradigmas.tp2.main;

import unlam.paradigmas.tp2.FileManager.FileManager;
import unlam.paradigmas.tp2.personajes.*;

public class BatallaMagosContraMortifagos {

	public static void main(String[] args) {

		// Creacion de batallones
		BatallonMagos batallonMagos = new BatallonMagos();
		BatallonMortifagos batallonMortigafos = new BatallonMortifagos();

		// Creacion de
		FileManager fm = new FileManager();

		batallonMagos.generarBatallon();
		batallonMortigafos.generarBatallon();

		int contadorRonda = 1;
		fm.mostrarLogCompleto(batallonMagos, batallonMortigafos);

		while (batallonMagos.hayVivos() && batallonMortigafos.hayVivos()) {

			System.out.println("\n\n----> Ronda numero " + contadorRonda + "!!");

			batallonMagos.atacarEnGrupo(batallonMortigafos);

			if (batallonMortigafos.hayVivos())
				batallonMortigafos.atacarEnGrupo(batallonMagos);

			// fm.mostrarLogCompleto(batallonMagos, batallonMortigafos);
			contadorRonda++;
		}

		System.out.println("------------------->> FINAL DEL COMBATE <<-------------------");

		// Quien ganó?
		if (batallonMagos.hayVivos()) {

			System.out.println("------------------->> G A N A R O N   L O S   M A G O S ");
			fm.mostrarLogMagos(batallonMagos);

		} else {

			System.out
					.println("------------------->> G A N A R O N   L O S   M O R T I F A G O S ");
			fm.mostrarLogMortifagos(batallonMortigafos);

		}

	}

}
