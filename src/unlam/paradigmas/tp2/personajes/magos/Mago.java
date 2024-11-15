package unlam.paradigmas.tp2.personajes.magos;

import java.util.Objects;

import unlam.paradigmas.tp2.personajes.Personaje;

public abstract class Mago extends Personaje {

	protected double potenciadorLealtad = 1;

	// Ahora solamente llamar al Personaje ctor, hay que poner diferencias. Lo mismo
	// con los hijos
	public Mago(String nombre) {
		super(nombre);
		this.mana *= potenciadorLealtad;
	}

	public Mago(String nombre, double mana, double defensa, double vida) {
		super(nombre, mana, defensa, vida);
	}

}
