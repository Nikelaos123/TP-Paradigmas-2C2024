package unlam.paradigmas.tp2.personajes.magos;

import unlam.paradigmas.tp2.hechizos.CreadorHechizoAtaque;

public class Estudiante extends Mago{

	

    public Estudiante(String nombre) {
		super(nombre);
		this.potenciadorLealtad = 1.2;
		this.mana *= potenciadorLealtad;
		this.hechizos.add(new CreadorHechizoAtaque().crearHechizo());
	}

	public Estudiante(String nombre, double mana, double defensa, double vida) {
		super(nombre,  mana,  defensa,  vida);
	}

	public String darReporte(){
		return  "(Estudiante)" + super.darReporte();
	}
	
}
