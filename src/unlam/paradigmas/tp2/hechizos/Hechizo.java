package unlam.paradigmas.tp2.hechizos;

import unlam.paradigmas.tp2.personajes.Personaje;

public interface Hechizo {

	public void ejecutar(Personaje objetivo);

	public String getNombre();

	public double getPoder();

	public double getCosto();

}
