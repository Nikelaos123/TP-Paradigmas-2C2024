package unlam.paradigmas.tp2.hechizos;

import unlam.paradigmas.tp2.personajes.Personaje;

public class HechizoAtaque implements Hechizo{
	
	private String nombre;
	private int costo;
	private int poder;
	

	public HechizoAtaque(String nombre, int costo, int poder) {
		
		this.nombre = nombre;
		this.costo = costo;
		this.poder = poder;
	}

	
	public void ejecutar(Personaje objetivo) {

	}

}
