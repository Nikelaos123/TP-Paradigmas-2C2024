package unlam.paradigmas.tp2.personajes.magos;

import unlam.paradigmas.tp2.hechizos.CreadorHechizoAtaque;
import unlam.paradigmas.tp2.hechizos.CreadorHechizoDefensa;

public class Profesor extends Mago{
    
    public Profesor(String nombre) {
		super(nombre);
		this.potenciadorLealtad = 1.4;
		this.mana *= potenciadorLealtad;
		this.defensa *= potenciadorLealtad;
		this.hechizos.add(new CreadorHechizoAtaque().crearHechizo());
		this.hechizos.add(new CreadorHechizoDefensa().crearHechizo());
	}

	public Profesor(String nombre, double mana, double defensa, double vida) {
		super(nombre,  mana,  defensa,  vida);
	}

	public String darReporte(){
		return  "(Profesor)" + super.darReporte();
	}
}
