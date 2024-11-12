package unlam.paradigmas.tp2.personajes.mortifagos;

import unlam.paradigmas.tp2.hechizos.CreadorHechizoAtaque;
import unlam.paradigmas.tp2.hechizos.CreadorHechizoDefensa;

public class Seguidor extends Mortifago {

	public Seguidor(String nombre) {
		super(nombre);
		this.potenciadorMalvado = 1.4;
		this.mana *= potenciadorMalvado;
		this.hechizos.add(new CreadorHechizoAtaque().crearHechizo());
		this.hechizos.add(new CreadorHechizoDefensa().crearHechizo());
	}

	public Seguidor(String nombre, double mana, double defensa, double vida) {
		super(nombre, mana, defensa, vida);
	}

	public String darReporte() {
		return "(Seguidor)" + super.darReporte();
	}
}
