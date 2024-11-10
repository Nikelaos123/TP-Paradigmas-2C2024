package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;

import unlam.paradigmas.tp2.personajes.*;
import unlam.paradigmas.tp2.personajes.magos.*;
import unlam.paradigmas.tp2.personajes.mortifagos.*;


public class Main {

	public static void main(String[] args) {
		
		
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
		
		

		try {
			// Crear el archivo Prolog
			FileWriter logger = new FileWriter("rivales.pl");

			// Escribir los hechos en el archivo
			for (Mago mago : batallonMagos.getMagos()) {
				logger.write("rival(" + mago.toPrologStr() + ").\n");
			}

			logger.close();

		} catch (Exception e) {
			System.out.println("Error al escribir el log.");
			e.printStackTrace();
		}
		/*
		//System.out.println("testsita");
		
		//String filePath = "C:/Users/Abigail/Downloads/consultas.pl";

		Query cargarArchivo = new Query("consult('" + filePath + "')");
		// Verifica si el archivo se cargó correctamente

		if(cargarArchivo.hasSolution()) {
			System.out.println("Archivo Prolog cargado correctamente.");
		} else {
			System.out.println("No se pudo cargar el archivo Prolog.");
			return;
		}
		
		
		
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
