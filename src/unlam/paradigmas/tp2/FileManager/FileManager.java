package unlam.paradigmas.tp2.FileManager;

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

    // Rutas relativas de archivos de prolog
    // private static final String filePathConocimientosMagos =
    // "src/main/querys/rivalesMagos.pl"; //archivo actualizable por ronda
    // private static final String filePathConocimientosMortifagos =
    // "src/main/querys/rivalesMortifagos.pl"; //archivo actualizable por ronda
    private static final String FILEPATH_RIVALES = "src/unlam/paradigmas/tp2/FileManager/querys/rivales.pl"; // archivo
                                                                                                             // actualizable
                                                                                                             // por
                                                                                                             // ronda
    private static final String FILEPATH_FUNCIONES = "src/unlam/paradigmas/tp2/FileManager/querys/consultas.pl"; // archivo
                                                                                                                 // a no
                                                                                                                 // modificar

    private Query query;

    public FileManager() {

        // Obtengo Funciones
        Query q = new Query("consult('" + FILEPATH_FUNCIONES + "')");

        // Verifica si el archivo se cargó correctamente
        if (q.hasSolution()) {
            // System.out.println("Archivo Prolog cargado correctamente.");
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

        if (batallonMagos == null || batallonMagos.getTotalCombatientes() == 0) {
            System.out.println("-> No hay magos");
            return;
        }

        System.out.println("-> Magos");

        for (Mago mago : batallonMagos.getBatallon()) {
            System.out.println(mago.darReporteCompleto());
        }

    }

    public void mostrarLogMortifagos(BatallonMortifagos batallonMortifagos) {

        if (batallonMortifagos == null || batallonMortifagos.getTotalCombatientes() == 0) {
            System.out.println("-> No hay Mortifagos");
            return;
        }

        System.out.println("-> Mortigafos");

        for (Mortifago mortifago : batallonMortifagos.getBatallon()) {
            System.out.println(mortifago.darReporteCompleto());
        }

    }

    public boolean actualizarFileLogGenerico(Batallon<Personaje> batallon) {
        try {
            // Crear el archivo Prolog
            FileWriter logger = new FileWriter(FILEPATH_RIVALES);

            // Escribir los hechos en el archivo
            for (Personaje rival : batallon.getBatallon()) {
                logger.write("rival(" + rival.toPrologStr() + ").\n");
            }

            logger.close();
            // System.out.println("Archivo '" + FILEPATH_RIVALES + "' generado con éxito!");

        } catch (Exception e) {
            System.out.println("Error al escribir el log. " + e.getMessage());
            return false;
        }
        return true;
    }

    // - - - - - - - - - - Decisiones - - - - - - - - - -
    public boolean decisionCurarse(double puntosVida) {

        // Realiza la consulta segun parametro
        query = new Query("curarse(" + puntosVida + ")");
        // System.out.println("Se debe curar? " + query.hasSolution() );

        return query.hasSolution();

    }

    public boolean decisionDefenderse(double puntosDefensa) {

        // Realiza la consulta segun parametro
        query = new Query("defenderse(" + puntosDefensa + ")");
        // System.out.println("Se debe defender? " + query.hasSolution() );

        return query.hasSolution();

    }

    // FALTA CREAR METODO LLAMADANDO A LA FUNCION DE PROLOG DE MENORVIDA
    public String decisionAtacar(Batallon batallonEnemigo) {

        this.actualizarFileLogGenerico(batallonEnemigo);

        query = new Query("consult('" + FILEPATH_RIVALES + "')");

        if (query.hasSolution()) {
            // System.out.println("Archivo Prolog cargado correctamente.");
        } else {
            System.out.println("No se pudo cargar el archivo Prolog.");
            throw new RuntimeException("Error al abrir el archivo de rivales");
        }

        query = new Query("menosVida(R)");

        String rival = query.oneSolution().get("R").toString();
        return rival;
    }

    public String verificarVivos() {
        query = new Query("consult('" + FILEPATH_RIVALES + "')");

        if (query.hasSolution()) {
            // System.out.println("Archivo Prolog cargado correctamente.");
        } else {
            System.out.println("No se pudo cargar el archivo Prolog.");
            throw new RuntimeException("Error al abrir el archivo de rivales");
        }

        query = new Query("vivos(R)");

        String rivales = query.oneSolution().get("R").toString();

        return rivales;
    }

}
