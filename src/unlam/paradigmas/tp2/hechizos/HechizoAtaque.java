package unlam.paradigmas.tp2.hechizos;

import unlam.paradigmas.tp2.personajes.Personaje;

public class HechizoAtaque implements Hechizo{
	
	private String nombre;
	private double costo;
	private double poder;
	

	public HechizoAtaque(String nombre, int costo, int poder) {
		
		this.nombre = nombre;
		this.costo = costo;
		this.poder = poder;
	}

	/*
	public Hechizo getHechizo() {
		return this;
	}
	*/
	
	public int ejecutar(Personaje objetivo, int manaActualPersonaje) {
		return 0;
		
	}

	@Override
	public double getCosto() {
		return this.costo;
	}

}
