package unlam.paradigmas.tp2.personajes.magos;

import unlam.paradigmas.tp2.hechizos.CreadorHechizoAtaque;
import unlam.paradigmas.tp2.hechizos.CreadorHechizoDefensa;
import unlam.paradigmas.tp2.hechizos.CreadorHechizoSanacion;

public class Auror extends Mago{



    public Auror(String nombre) {
		super(nombre);
		this.potenciadorLeal = 1.8;
		this.mana *= potenciadorLeal;
		this.defensa *= potenciadorLeal;
		this.vida *= potenciadorLeal;
		this.hechizos.add(new CreadorHechizoAtaque().crearHechizo());
		this.hechizos.add(new CreadorHechizoDefensa().crearHechizo());
		this.hechizos.add(new CreadorHechizoSanacion().crearHechizo()) ; 
	}

	public Auror(String nombre, double mana, double defensa, double vida) {
		super(nombre,  mana,  defensa,  vida);
	}
}
