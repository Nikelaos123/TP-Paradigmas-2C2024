package unlam.paradigmas.tp2.hechizos;

import unlam.paradigmas.tp2.personajes.Personaje;

public class HechizoAtaque implements Hechizo{
	
	private String nombre;
	private double costo;
	private double poder;
	

	//Niveles de Ataque:
	//Debil: 25 / 75
	//Comun: 30 / 125 -> Default
	//Fuerte: 35 / 200

	public HechizoAtaque() {
		
		this.nombre = "Ataque - Comun";
		this.costo = 30;
		this.poder = 125;
	}

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
	
	public void ejecutar(Personaje objetivo) {
		
		objetivo.recibirAtaque(this.poder);
		
	}

	

}
