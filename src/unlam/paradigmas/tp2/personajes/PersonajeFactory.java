package unlam.paradigmas.tp2.personajes;

import java.util.LinkedList;
import java.util.Random;

import unlam.paradigmas.tp2.hechizos.HechizoSanacion;
import unlam.paradigmas.tp2.personajes.magos.*;
import unlam.paradigmas.tp2.personajes.mortifagos.*;

public class PersonajeFactory {
	
	private static final Random RANDOM = new Random();
	private static final String[] nombres = {"Ignis", "Aquamaris", "Orion", "Merlin", "Lucas", "Kael", 
												"Lyra", "Freya", "Luna", "Hornet", "Icarus"};



	//FALTA IMPLEMENTAR
	public Mago crearMago() {

		//Generar numero aleatorio (1 al 3) para definir nivel del hechizo
        int randTipo = RANDOM.nextInt(3) + 1; 
		int randNombre = RANDOM.nextInt(nombres.length);	
		

		switch (randTipo) {
			case 1:
				//System.out.println("Se creó a " + nombres[randNombre] +"! Un Mago de tipo Estudiante");
				return new Estudiante(nombres[randNombre]);

			case 2:
				//System.out.println("Se creó  a " + nombres[randNombre] +"! Un Mago de tipo Profesor");
				return new Profesor(nombres[randNombre]);

			case 3:
				//System.out.println("Se creó  a " + nombres[randNombre] +"! Un Mago  de tipo Auror");
				return new Auror(nombres[randNombre]);
		}

		//En caso de error, se retorna un Estudiante
		return new Estudiante(nombres[randNombre]); 
	}
	
	public Mortifago crearMortifago() {


		//Generar numero aleatorio (1 al 3) para definir nivel del hechizo
		int randTipo = RANDOM.nextInt(2) + 1; 
		int randNombre = RANDOM.nextInt(nombres.length);


		switch (randTipo) {
			case 1:
				//System.out.println("Se creó un Mortifago de tipo Seguidor");
				return new Seguidor(nombres[randNombre]);

			case 2:
				//System.out.println("Se creó un Mortifago de tipo Comandante");
				return new Comandante(nombres[randNombre]);

		}

		//En caso de error, se retorna un Estudiante
		return new Seguidor(nombres[randNombre]); 
	}
	
	
}
