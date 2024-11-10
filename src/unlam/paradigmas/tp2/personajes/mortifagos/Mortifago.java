package unlam.paradigmas.tp2.personajes.mortifagos;

import unlam.paradigmas.tp2.personajes.Personaje;

public abstract class Mortifago extends Personaje {
	
	protected double potenciadorMalvado = 1;

    //Ahora solamente llamar al Personaje ctor, hay que poner diferencias. Lo mismo con los hijos
    public Mortifago(String nombre) {
		super(nombre);
		this.mana *= potenciadorMalvado;
	}

	public Mortifago(String nombre, double mana, double defensa, double vida) {
		super(nombre,  mana,  defensa,  vida);
	}
}
