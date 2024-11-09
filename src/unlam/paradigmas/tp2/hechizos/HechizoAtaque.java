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

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public double getPoder() {
		return poder;
	}

	@Override
	public double getCosto() {
		return this.costo;
	}

	/*
	public Hechizo getHechizo() {
		return this;
	}
	*/
	
	public double ejecutar(Personaje objetivo, double manaActualPersonaje) {
		return 0;
		
	}

	

}
