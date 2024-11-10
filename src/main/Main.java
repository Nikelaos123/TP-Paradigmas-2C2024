package main;

import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;

public class Main {

	public static void main(String[] args) {
		
		//System.out.println("testsita");
		
		//String filePath = "C:/Users/Abigail/Downloads/consultas.pl";
		String filePath = "C:/Users/DanielaGonzalez/Desktop/consultas.pl";

		Query cargarArchivo = new Query("consult('" + filePath + "')");
		// Verifica si el archivo se cargó correctamente

		if(cargarArchivo.hasSolution()) {
			System.out.println("Archivo Prolog cargado correctamente.");
		} else {
			System.out.println("No se pudo cargar el archivo Prolog.");
			return;
		}
		
		// Consultar si el hecho "hechizo(expecto_patronum)" es verdadero
		Query consultaHechizo = new Query("hechizo(expecto_patronum)");
		System.out.println("¿El hechizo expecto_patronum existe?: " + consultaHechizo.hasSolution());

		// Consultar si "energia_suficiente(harry_potter)" es verdadero
		Query consultaEnergia = new Query("energia_suficiente(harry_potter)");
		System.out.println("¿Harry Potter tiene energía suficiente?: " + consultaEnergia.hasSolution());

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
