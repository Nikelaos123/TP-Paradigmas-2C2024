package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;
import org.jpl7.fli.fid_t;

import unlam.FileManager.FileManager;
import unlam.paradigmas.tp2.hechizos.CreadorHechizoAtaque;
import unlam.paradigmas.tp2.hechizos.CreadorHechizoDefensa;
import unlam.paradigmas.tp2.hechizos.CreadorHechizoSanacion;
import unlam.paradigmas.tp2.hechizos.HechizoFactory;
import unlam.paradigmas.tp2.hechizos.HechizoSanacion;
import unlam.paradigmas.tp2.personajes.*;
import unlam.paradigmas.tp2.personajes.magos.*;
import unlam.paradigmas.tp2.personajes.mortifagos.*;


public class Main {

	public static void main(String[] args) {
		
		/* 
		PersonajeFactory pf1 = new PersonajeFactory();
		
		BatallonMagos batallonMagos = new BatallonMagos();
		BatallonMortifagos batallonMortifagos = new BatallonMortifagos();
		
		batallonMagos.agregar( pf1.crearMago() );
		batallonMagos.agregar( pf1.crearMago() );
		batallonMagos.agregar( pf1.crearMago() );
		batallonMagos.agregar( pf1.crearMago() );
		batallonMortifagos.agregar( pf1.crearMortifago() );
		
		System.out.println("Vivos: " + batallonMagos.getVivos() );
		
		String filePath = "C:/Users/urano/eclipse-workspace/TP/TP-Paradigmas-2C2024/src/main/consultas.pl";
		String filePathConocimientos = "src/main/querys/rivales.pl";
		String filePathFunciones = "src/main/querys/consultas.pl";*/


		/*double HP = 20;
		double DEF = 10;
		System.out.println("Vida: " + HP);
		System.out.println("Defensa: " + DEF);

		FileManager fm = new FileManager();

		System.out.println("Curar? " + fm.decisionCurarse(HP));
		System.out.println("Defender? " + fm.decisionDefenderse(DEF));*/
		
		
		/*HechizoFactory hechizoFactorysanacion = new CreadorHechizoSanacion();
		HechizoFactory hechizoFactoryAtaque = new CreadorHechizoAtaque();
		HechizoFactory hechizoFactoryDefensa = new CreadorHechizoDefensa();

		hechizoFactorysanacion.crearHechizo();
		hechizoFactoryAtaque.crearHechizo();
		hechizoFactoryDefensa.crearHechizo();*/


		PersonajeFactory FabricaDePersonajes = new PersonajeFactory();

		BatallonMagos batallonMagos = new BatallonMagos();
		BatallonMortifagos batallonMortigafos = new BatallonMortifagos();

		batallonMagos.agregar(FabricaDePersonajes.crearMago());
		batallonMagos.agregar(FabricaDePersonajes.crearMago());
		batallonMagos.agregar(FabricaDePersonajes.crearMago());
		batallonMagos.agregar(FabricaDePersonajes.crearMago());

		batallonMortigafos.agregar(FabricaDePersonajes.crearMortifago());
		batallonMortigafos.agregar(FabricaDePersonajes.crearMortifago());
		batallonMortigafos.agregar(FabricaDePersonajes.crearMortifago());
		batallonMortigafos.agregar(FabricaDePersonajes.crearMortifago());

		FileManager fm = new FileManager();
		fm.mostrarLogCompleto(batallonMagos, batallonMortigafos);
		

		/*try {
			// Crear el archivo Prolog
			FileWriter logger = new FileWriter("src/main/querys/rivales.pl");

			// Escribir los hechos en el archivo
			for (Mago mago : batallonMagos.getMagos()) {
				logger.write("rival(" + mago.toPrologStr() + ").\n");
			}

			logger.close();
			System.out.println("Archivo generado con éxito!");

		} catch (Exception e) {
			System.out.println("Error al escribir el log.");
			e.printStackTrace();
		}*/
		
		//System.out.println("testsita");
		
		//String filePath = "C:/Users/Abigail/Downloads/consultas.pl";

/*
		//Obtengo datos
		Query q = new Query("consult('" + filePathConocimientos + "')");
		// Verifica si el archivo se cargó correctamente

		if(q.hasSolution()) {
			System.out.println("Archivo Prolog cargado correctamente.");
		} else {
			System.out.println("No se pudo cargar el archivo Prolog.");
			return;
		}


		//Obtengo Funciones
		q = new Query("consult('" + filePathFunciones + "')");
		// Verifica si el archivo se cargó correctamente

		if(q.hasSolution()) {
			System.out.println("Archivo Prolog cargado correctamente.");
		} else {
			System.out.println("No se pudo cargar el archivo Prolog.");
			return;
		}

		q = new Query("menosVida(R)");


		while(q.hasMoreSolutions()) {
			System.out.println(q.nextSolution().get("R"));
		}


		
		/*
		// Consultar si el hecho "hechizo(expecto_patronum)" es verdadero
		Query consultaHechizo = new Query("menosVida(R)");
		
		Map<String, Term> solution = new HashMap<String,Term>() ;
		solution = consultaHechizo.oneSolution();
		System.out.println(solution.get("R"));
		
		System.out.println("¿Total?: " + consultaHechizo.allSolutions().length );
		
		while (consultaHechizo.hasMoreSolutions()) { // until a good sol is found
		    
		    solution = consultaHechizo.nextSolution();
		    
		}*/
		
		

		// Consultar si "energia_suficiente(harry_potter)" es verdadero
//		Query consultaEnergia = new Query("energia_suficiente(harry_potter)");
//		System.out.println("¿Harry Potter tiene energía suficiente?: " + consultaEnergia.hasSolution());

		/*
		// Consultar si "varita_sauco_disponible" es verdadero
		Query consultaVarita = new Query("varita_sauco_disponible");
		System.out.println("¿La varita de sauco está disponible?: " + consultaVarita.hasSolution());
		*/


		// Auror m1 = new Auror();
		

		// Batallon batallonMagos1 = new batallonMagos();

		// batallonMagos1.agregar(m1);

		// System.out.println(batallonMagos1.getVivos());

		try {
//			String connect = "consult('a.pl')"; //../unlam/paradigmas/tp2/
//			Query con = new Query(connect);
//			System.out.println(con.hasMoreSolutions());

			//  Query q1 = new Query("consult", new Term[] {new Atom("a.pl")});
			//  System.out.println( "consult " + (q1.hasSolution() ? "succeeded" : "failed"));
			// System.out.println(System.getProperty("java.library.path"));
		} catch (Exception e) {
			System.out.println("PORFA");
		}
	}

}
