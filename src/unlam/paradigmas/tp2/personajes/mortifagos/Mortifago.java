package unlam.paradigmas.tp2.personajes.mortifagos;

import unlam.paradigmas.tp2.personajes.Personaje;

public abstract class Mortifago extends Personaje {
    
    //Ahora solamente llamar al Personaje ctor, hay que poner diferencias. Lo mismo con los hijos
    public Mortifago(String nombre) {
		super(nombre);
	}

	public Mortifago(String nombre, double mana, double defensa, double vida) {
		super(nombre,  mana,  defensa,  vida);
	}
}
