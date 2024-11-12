package unlam.paradigmas.tp2.main;

import unlam.paradigmas.tp2.FileManager.FileManager;
import unlam.paradigmas.tp2.personajes.*;

public class Main {

	public static void main(String[] args) {

		BatallonMagos batallonMagos = new BatallonMagos();
		BatallonMortifagos batallonMortigafos = new BatallonMortifagos();

		// Batallon batallonGenerico = new BatallonMortifagos();

		FileManager fm = new FileManager();

		batallonMagos.generarBatallon();

		batallonMortigafos.generarBatallon();

		// fm.mostrarLogCompleto(batallonMagos, batallonMortigafos);

		// fm.actualizarFileLogMagos(batallonMagos);
		// fm.actualizarFileLogMortifagos(batallonMortigafos);
		// fm.actualizarFileLogGenerico(batallonMagos);
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
		// fm.mostrarLogCompleto(batallonMagos, batallonMortigafos);

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
