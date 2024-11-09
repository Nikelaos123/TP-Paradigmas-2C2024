package unlam.paradigmas.tp2.hechizos;

import unlam.paradigmas.tp2.personajes.Personaje;

public class HechizoDefensa implements Hechizo{
	
	private String nombre;
	private int costo;
	private int poder;
	
	public HechizoDefensa(String nombre, int costo, int poder) {

		this.nombre = nombre;
		this.costo = costo;
		this.poder = poder;
	}
	
	public int ejecutar(Personaje objetivo, int manaActualPersonaje) {
		return 0;
		
	}
	
	
	

}
