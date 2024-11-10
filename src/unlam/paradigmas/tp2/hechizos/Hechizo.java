package unlam.paradigmas.tp2.hechizos;

import unlam.paradigmas.tp2.personajes.Personaje;

public interface Hechizo {
	
	public double ejecutar(Personaje objetivo, double manaActualPersonaje);
	
	public String getNombre();
	public double getPoder();
	public double getCosto();
	// RARO -> para nada
	/*
	public Hechizo getCosto();
	public Hechizo getPoder();
	public Hechizo getNombre();
	*/
	
	

}
