package unlam.paradigmas.tp2.personajes.magos;

import unlam.paradigmas.tp2.hechizos.CreadorHechizoAtaque;
import unlam.paradigmas.tp2.hechizos.CreadorHechizoDefensa;
import unlam.paradigmas.tp2.hechizos.CreadorHechizoSanacion;

public class Auror extends Mago{



    public Auror(String nombre) {
		super(nombre);
		this.potenciadorLealtad = 1.8;
		this.mana *= potenciadorLealtad;
		this.defensa *= potenciadorLealtad;
		this.vida *= potenciadorLealtad;
		this.hechizos.add(new CreadorHechizoAtaque().crearHechizo());
		this.hechizos.add(new CreadorHechizoDefensa().crearHechizo());
		this.hechizos.add(new CreadorHechizoSanacion().crearHechizo()) ; 
	}

	public Auror(String nombre, double mana, double defensa, double vida) {
		super(nombre,  mana,  defensa,  vida);
	}

	public String darReporte(){
		return  "(Auror)" + super.darReporte();
	}
}
