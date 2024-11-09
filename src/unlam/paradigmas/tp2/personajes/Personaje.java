package unlam.paradigmas.tp2.personajes;

import unlam.paradigmas.tp2.hechizos.Hechizo;
import java.util.List;

public abstract class Personaje {
	
	private static final int DEFENSA_TOTAL = 1000;

	private String nombre;
	private int mana; // nivel de magia disponible para gastar en ejecutar hechizos
	private int defensa; // puntos para disminuir el danio al recibir un ataque
	private int vidaMaxima; // puntos de vida para poder recibir danio hasta morir
	private int vidaActual;
	private boolean vivo = true;

	//private List<Hechizo> hechizos;

	
	

	public void lanzarHechizo(Hechizo hechizo, Personaje objetivo) {

		// QUE PASA CUANDO UN PERSONAJE SE QUEDA SIN MANA???
		// Y SI SE QUEDAN TODOS SIN MANA???????????????????????????????????????	
		// RTA: LO TIENE QUE RESOLVER HECHIZO
		
		this.mana -= hechizo.ejecutar(objetivo, this.mana);
	}

	
	private void sumarVida(int vida) {

		int vidaCurada = vidaActual + vida;

		if (vidaCurada > vidaMaxima) {
			vidaActual = vidaMaxima;
		} else {

			this.vidaActual = vidaCurada;
		}
	}
	
	private void restarVida(int danio) {

		int danioReducido = danio - (danio * (this.defensa / DEFENSA_TOTAL));
		
		int vidaPerdida = vidaActual - danioReducido;

		if (vidaPerdida <= 0) {
			this.morir();
		} else {

			this.vidaActual = vidaPerdida;
		}
	}
	
	private void morir() {
		
		this.vidaActual = 0;
		this.vivo = false;
		this.defensa = 0;
		this.mana = 0;
	}


	public void recibirDefensa(int defensa) {

		if (!this.vivo) {
			this.mensajeMuerto();

		} else {

			this.defensa += defensa;
		}
	}

	public void recibirSanacion(int vida) {

		if (!this.vivo) {
			this.mensajeMuerto();

		} else {

			this.sumarVida(vida);
		}
	}

	public void recibirAtaque(int danio) { // recibirAtaque(Hechizo hechizo) 
		
		if (!this.vivo) {
			this.mensajeMuerto();

		} else {

			this.restarVida(danio);
		}

	}
	
	private void mensajeMuerto() {
		
		// throw new RuntimeException
		System.out.println(this.nombre + " ha caído en batalla. El hechizo no surtió efecto!");
	}
	
	// setStrategyHechizo() : Hechizo
	// public void mostrarHechizos()

}
