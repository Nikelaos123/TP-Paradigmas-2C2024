package unlam.paradigmas.tp2.hechizos;

import unlam.paradigmas.tp2.personajes.Personaje;

public class HechizoDefensa implements Hechizo{
	
	private String nombre;
	private double costo;
	private double poder;

	//Niveles de Defensa:
	//Debil: 25 / 50
	//Comun: 30 / 75 -> Default
	//Fuerte: 35 / 100
	
	//Caso default
	public HechizoDefensa() {

		this.nombre = "Defensa - Comun";
		this.costo = 30;
		this.poder = 75;
	}

	public HechizoDefensa(String nombre, int costo, int poder) {
		this.nombre = nombre;
		this.costo = costo;
		this.poder = poder;
	}
	
	public void ejecutar(Personaje objetivo) {
		objetivo.recibirDefensa(poder);
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
	
	
	
	

}
