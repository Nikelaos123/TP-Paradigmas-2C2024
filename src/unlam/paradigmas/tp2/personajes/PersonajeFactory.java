package unlam.paradigmas.tp2.personajes;

import unlam.paradigmas.tp2.personajes.magos.*;
import unlam.paradigmas.tp2.personajes.mortifagos.*;

public class PersonajeFactory {
	
	//FALTA IMPLEMENTAR
	public Mago crearMago() {
		return new Auror("Raul");
	}
	
	public Mortifago crearMortifago() {
		return new Seguidor("Lucas");
	}
	
	
}
