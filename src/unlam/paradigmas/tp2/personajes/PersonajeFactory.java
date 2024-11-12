package unlam.paradigmas.tp2.personajes;

import java.util.LinkedList;
import java.util.Random;

import unlam.paradigmas.tp2.hechizos.HechizoSanacion;
import unlam.paradigmas.tp2.personajes.magos.*;
import unlam.paradigmas.tp2.personajes.mortifagos.*;

public class PersonajeFactory {

	private static final Random RANDOM = new Random();
	private static final String[] nombresMagos = { "Ignis", "Aquamaris", "Orion", "Merlin", "Lucas", "Kael",
			"Lyra", "Freya", "Luna", "Hornet", "Icarus", "Nora", "Bernard", "Tita" };
	private static final String[] nombresMortifagos = { "Daemon", "Salakar", "Astarot", "Veromos", "Malrath",
			"Nerathor", "Drakoth", "Beltharoth", "Kro", "Vorgar", "Ravok" };

	// FALTA IMPLEMENTAR
	public Mago crearMago() {

		// Generar numero aleatorio (1 al 3) para definir nivel del hechizo
		int randTipo = RANDOM.nextInt(3) + 1;
		int randNombre = RANDOM.nextInt(nombresMagos.length);

		switch (randTipo) {
			case 1:
				// System.out.println("Se creó a " + nombresMagos[randNombre] +"! Un Mago de
				// tipo
				// Estudiante");
				return new Estudiante(nombresMagos[randNombre]);

			case 2:
				// System.out.println("Se creó a " + nombresMagos[randNombre] +"! Un Mago de
				// tipo
				// Profesor");
				return new Profesor(nombresMagos[randNombre]);

			case 3:
				// System.out.println("Se creó a " + nombresMagos[randNombre] +"! Un Mago de
				// tipo
				// Auror");
				return new Auror(nombresMagos[randNombre]);
		}

		// En caso de error, se retorna un Estudiante
		return new Estudiante(nombresMagos[randNombre]);
	}

	public Mortifago crearMortifago() {

		// Generar numero aleatorio (1 al 3) para definir nivel del hechizo
		int randTipo = RANDOM.nextInt(2) + 1;
		int randNombre = RANDOM.nextInt(nombresMortifagos.length);

		switch (randTipo) {
			case 1:
				// System.out.println("Se creó un Mortifago de tipo Seguidor");
				return new Seguidor(nombresMortifagos[randNombre]);

			case 2:
				// System.out.println("Se creó un Mortifago de tipo Comandante");
				return new Comandante(nombresMortifagos[randNombre]);

		}

		// En caso de error, se retorna un Estudiante
		return new Seguidor(nombresMortifagos[randNombre]);
	}

}
