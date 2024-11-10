package unlam.paradigmas.tp2.personajes;

import unlam.paradigmas.tp2.hechizos.Hechizo;
import unlam.paradigmas.tp2.personajes.magos.Auror;

import java.util.List;

public abstract class Personaje {
	
	private static final int DEFENSA_TOTAL = 1000;

	private String nombre;
	private double mana; // nivel de magia disponible para gastar en ejecutar hechizos
	private double defensa; // puntos para disminuir el danio al recibir un ataque
	private double vidaMaxima; // puntos de vida para poder recibir danio hasta morir
	private double vidaActual;
	private boolean vivo = true;


	private List<Hechizo> hechizos;
	


	public Hechizo elegirHechizo(Batallon obj) {
		//Implementa Strategy
		return hechizos.get(0); //A reemplazar
	}


	public boolean getVivo() {
		return vivo;
	}


	//retorna true si hay mana suficiente
	public boolean verificarMana(){
		double minMana = Double.MAX_VALUE;

		for (Hechizo hechizo : hechizos) {
			if( hechizo.getCosto() < minMana)
				minMana = hechizo.getCosto();
		}

		return mana >= minMana;
	}
	
	public void descansar() {
		this.recibirMana(15);
	}

	public boolean atacar(Batallon obj) {
		if(!this.vivo)
			return false;

		if(!verificarMana())
		{
			this.descansar();
			return false;
		}

		
		this.lanzarHechizo(elegirHechizo(obj), new Auror());
		return true;
	}

	public boolean atacar(Personaje obj) {
		if(!this.vivo)
			return false;

		if(!verificarMana())
		{
			this.descansar();
			return false;
		}

		this.lanzarHechizo(elegirHechizo(null), new Auror());
		return true;
	}

	

	public void lanzarHechizo(Hechizo hechizo, Personaje objetivo) {
		
		// QUE PASA CUANDO UN PERSONAJE SE QUEDA SIN MANA??? LISTO
		// Y SI SE QUEDAN TODOS SIN MANA???????????????????????? UN BAJON
		// RTA: LO TIENE QUE RESOLVER HECHIZO, nop descansan
		
		this.mana -= hechizo.ejecutar(objetivo, this.mana);
	}

	
	private void sumarVida(double vida) {

		double vidaCurada = vidaActual + vida;

		if (vidaCurada > vidaMaxima) {
			vidaActual = vidaMaxima;
		} else {

			this.vidaActual = vidaCurada;
		}
	}
	
	private void restarVida(double danio) {

		double danioReducido = danio - (danio * (this.defensa / DEFENSA_TOTAL));
		
		double vidaPerdida = vidaActual - danioReducido;

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


	public void recibirDefensa(double defensa) {

		if (!this.vivo) {
			this.mensajeMuerto();

		} else {

			this.defensa += defensa;
		}
	}

	public void recibirMana(double mana) {

		if (!this.vivo) {
			this.mensajeMuerto();

		} else {

			this.sumarVida(mana);
		}
	}

	public void recibirSanacion(double vida) {

		if (!this.vivo) {
			this.mensajeMuerto();

		} else {

			this.sumarVida(vida);
		}
	}

	public void recibirAtaque(double danio) { // recibirAtaque(Hechizo hechizo) 
		
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
