package unlam.paradigmas.tp2.personajes.mortifagos;

import unlam.paradigmas.tp2.hechizos.CreadorHechizoAtaque;
import unlam.paradigmas.tp2.hechizos.CreadorHechizoDefensa;
import unlam.paradigmas.tp2.hechizos.CreadorHechizoSanacion;

public class Comandante extends Mortifago{


    public Comandante(String nombre) {
		super(nombre);
		this.potenciadorMalvado = 1.5;
		this.mana *= potenciadorMalvado;
		this.defensa *= potenciadorMalvado; 
		this.hechizos.add(new CreadorHechizoAtaque().crearHechizo());
		this.hechizos.add(new CreadorHechizoDefensa().crearHechizo());
		this.hechizos.add(new CreadorHechizoSanacion().crearHechizo());
	}

	public Comandante(String nombre, double mana, double defensa, double vida) {
		super(nombre,  mana,  defensa,  vida);
	}

	public String darReporte(){
		return  "(Comandante)" + super.darReporte();
	}
}
