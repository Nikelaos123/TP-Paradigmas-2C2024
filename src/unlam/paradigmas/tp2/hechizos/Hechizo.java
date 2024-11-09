package unlam.paradigmas.tp2.hechizos;

import unlam.paradigmas.tp2.personajes.Personaje;

public interface Hechizo {
	
	public double ejecutar(Personaje objetivo, double manaActualPersonaje);
	
	public double getCosto();
	// RARO
	/*
	public Hechizo getCosto();
	public Hechizo getPoder();
	public Hechizo getNombre();
	*/
	
	

}
