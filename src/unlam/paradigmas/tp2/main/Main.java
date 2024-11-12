package unlam.paradigmas.tp2.main;

import unlam.paradigmas.tp2.FileManager.FileManager;
import unlam.paradigmas.tp2.personajes.*;

public class Main {

	public static void main(String[] args) {

		/*
		 * PersonajeFactory pf1 = new PersonajeFactory();
		 * 
		 * BatallonMagos batallonMagos = new BatallonMagos();
		 * BatallonMortifagos batallonMortifagos = new BatallonMortifagos();
		 * 
		 * batallonMagos.agregar( pf1.crearMago() );
		 * batallonMagos.agregar( pf1.crearMago() );
		 * batallonMagos.agregar( pf1.crearMago() );
		 * batallonMagos.agregar( pf1.crearMago() );
		 * batallonMortifagos.agregar( pf1.crearMortifago() );
		 * 
		 * System.out.println("Vivos: " + batallonMagos.getVivos() );
		 * 
		 * String filePath =
		 * "C:/Users/urano/eclipse-workspace/TP/TP-Paradigmas-2C2024/src/main/consultas.pl";
		 * String filePathConocimientos = "src/main/querys/rivales.pl";
		 * String filePathFunciones = "src/main/querys/consultas.pl";
		 */

		/*
		 * double HP = 20;
		 * double DEF = 10;
		 * System.out.println("Vida: " + HP);
		 * System.out.println("Defensa: " + DEF);
		 * 
		 * FileManager fm = new FileManager();
		 * 
		 * System.out.println("Curar? " + fm.decisionCurarse(HP));
		 * System.out.println("Defender? " + fm.decisionDefenderse(DEF));
		 */

		/*
		 * HechizoFactory hechizoFactorysanacion = new CreadorHechizoSanacion();
		 * HechizoFactory hechizoFactoryAtaque = new CreadorHechizoAtaque();
		 * HechizoFactory hechizoFactoryDefensa = new CreadorHechizoDefensa();
		 * 
		 * hechizoFactorysanacion.crearHechizo();
		 * hechizoFactoryAtaque.crearHechizo();
		 * hechizoFactoryDefensa.crearHechizo();
		 */

		// PersonajeFactory fabricaDePersonajes = new PersonajeFactory();

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
		int contadorTurnos = 0;
		fm.mostrarLogCompleto(batallonMagos, batallonMortigafos);

		while (batallonMagos.hayVivos() && batallonMortigafos.hayVivos()) {

			batallonMagos.atacarEnGrupo(batallonMortigafos);

			if (batallonMortigafos.hayVivos())
				batallonMortigafos.atacarEnGrupo(batallonMagos);

			fm.mostrarLogCompleto(batallonMagos, batallonMortigafos);

		}

		System.out.println("-------------------------->>YESSSSSSS");
		fm.mostrarLogCompleto(batallonMagos, batallonMortigafos);

		// Quien ganó?
		if (batallonMagos.hayVivos()) {
			fm.mostrarLogMagos(batallonMagos);
			System.out.println("GANARON LOS MAGOS");
			return;
		}

		if (batallonMortigafos.hayVivos()) {

			System.out.println("GANARON LOS MORTIFAGOS");
			return;
		}

		// no tiene que llegar
		System.out.println("HELP");

	}

}
