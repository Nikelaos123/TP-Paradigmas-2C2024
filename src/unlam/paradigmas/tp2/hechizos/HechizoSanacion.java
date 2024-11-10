package unlam.paradigmas.tp2.hechizos;

import unlam.paradigmas.tp2.personajes.Personaje;

public class HechizoSanacion implements Hechizo {

	private String nombre;
	private double costo;
	private double poder;


	//Niveles de Sanación:
	//Debil: 25 / 50
	//Comun: 30 / 100 -> Default
	//Fuerte: 35 / 150

	public HechizoSanacion() {
		this.nombre = "Sanacion - Comun";
		this.costo = 30;
		this.poder = 100;
	}

	public HechizoSanacion(String nombre, int costo, int poder) {
		this.nombre = nombre;
		this.costo = costo;
		this.poder = poder;
	}

	public double ejecutar(Personaje objetivo, double manaActualPersonaje) {
		return 0;
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
