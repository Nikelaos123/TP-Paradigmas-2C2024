package unlam.FileManager;

import java.io.FileWriter;

import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;


import unlam.paradigmas.tp2.personajes.Personaje;
import unlam.paradigmas.tp2.personajes.Batallon;
import unlam.paradigmas.tp2.personajes.magos.Mago;
import unlam.paradigmas.tp2.personajes.mortifagos.Mortifago;
import unlam.paradigmas.tp2.personajes.BatallonMagos;
import unlam.paradigmas.tp2.personajes.BatallonMortifagos;

public class FileManager {

    //Rutas relativas de archivos de prolog
    private static final String  filePathConocimientosMagos = "src/main/querys/rivalesMagos.pl"; //archivo actualizable por ronda
    private static final String  filePathConocimientosMortifagos = "src/main/querys/rivalesMortifagos.pl"; //archivo actualizable por ronda
    private static final String filePathFunciones = "src/main/querys/consultas.pl"; //archivo a no modificar

    Query query;

    public FileManager() {

        //Obtengo Funciones
        Query q = new Query("consult('" + filePathFunciones + "')");

        // Verifica si el archivo se cargó correctamente
        if(q.hasSolution()) {
            //System.out.println("Archivo Prolog cargado correctamente.");
        } else {
            System.out.println("No se pudo cargar el archivo Prolog.");
        }
    }

    public void mostrarLogCompleto(BatallonMagos batallonMagos, BatallonMortifagos batallonMortifagos) {

        
        System.out.println("- - - - Reporte completo - - - - ");

        this.mostrarLogMagos(batallonMagos);

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");

        this.mostrarLogMortifagos(batallonMortifagos);

    }

    public void mostrarLogMagos(BatallonMagos batallonMagos) {

        if(batallonMagos == null || batallonMagos.getTotalCombatientes() == 0) {
            System.out.println("-> No hay magos");
            return;
        }

        System.out.println("-> Magos");
        
        for (Mago mago : batallonMagos.getBatallon()) {
            System.out.println(mago.darReporte());
        }

    }

    public void mostrarLogMortifagos(BatallonMortifagos batallonMortifagos) {

        if(batallonMortifagos == null || batallonMortifagos.getTotalCombatientes() == 0) {
            System.out.println("-> No hay Mortifagos");
            return;
        }

        System.out.println("-> Mortigafos");
        
        for (Mortifago mortifago : batallonMortifagos.getBatallon()) {
            System.out.println(mortifago.darReporte());
        }

    }

    public boolean actualizarFileLogMagos(BatallonMagos batallonMagos) {
        try {
			// Crear el archivo Prolog
			FileWriter logger = new FileWriter(filePathConocimientosMagos);

			// Escribir los hechos en el archivo
			for (Mago mago : batallonMagos.getBatallon()) {
				logger.write("rival(" + mago.toPrologStr() + ").\n");
			}

			logger.close();
			System.out.println("Archivo '"+ filePathConocimientosMagos +"' generado con éxito!");

		} catch (Exception e) {
			System.out.println("Error al escribir el log. " + e.getMessage());
            return false;
		} 
        return true;
    }

    public boolean actualizarFileLogMortifagos(BatallonMortifagos batallonMortifagos) {
        try {
			// Crear el archivo Prolog
			FileWriter logger = new FileWriter(filePathConocimientosMortifagos);

			// Escribir los hechos en el archivo
			for (Mortifago mortifago : batallonMortifagos.getBatallon()) {
				logger.write("rival(" + mortifago.toPrologStr() + ").\n");
			}

			logger.close();
			System.out.println("Archivo '"+ filePathConocimientosMortifagos +"' generado con éxito!");

		} catch (Exception e) {
			System.out.println("Error al escribir el log. " + e.getMessage());
            return false;
		} 
        return true;
    }


    // - - - - - - - - - - Decisiones - - - - - - - - - - 
    public boolean decisionCurarse( double puntosVida )  {

        //Realiza la consulta segun parametro
        query = new Query("curarse("+ puntosVida +")");
        //System.out.println("Se debe curar? " + query.hasSolution() );

        return query.hasSolution();

    }

    public boolean decisionDefenderse( double puntosDefensa )  {

        //Realiza la consulta segun parametro
        query = new Query("defenderse("+ puntosDefensa +")");
        //System.out.println("Se debe defender? " + query.hasSolution() );

        return query.hasSolution();

    }

    //FALTA CREAR METODO LLAMADANDO A LA FUNCION DE PROLOG DE MENORVIDA

    
    

    /*try {
			// Crear el archivo Prolog
			FileWriter logger = new FileWriter("src/main/querys/rivales.pl");

			// Escribir los hechos en el archivo
			for (Mago mago : batallonMagos.getBatallon()) {
				logger.write("rival(" + mago.toPrologStr() + ").\n");
			}

			logger.close();
			System.out.println("Archivo generado con éxito!");

		} catch (Exception e) {
			System.out.println("Error al escribir el log.");
			e.printStackTrace();
		} */
}
