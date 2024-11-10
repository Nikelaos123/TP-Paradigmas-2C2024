package unlam.paradigmas.tp2.personajes;

import unlam.paradigmas.tp2.hechizos.Hechizo;
import unlam.paradigmas.tp2.personajes.magos.Auror;

import java.util.List;

import javax.management.RuntimeErrorException;

public abstract class Personaje {
	
	private static final int DEFENSA_TOTAL = 1000;

	private String nombre;
	private double mana; // nivel de magia disponible para gastar en ejecutar hechizos
	private double defensa; // puntos para disminuir el danio al recibir un ataque
	//private double vidaMaxima; // puntos de vida para poder recibir danio hasta morir???
	private double vida;
	private boolean vivo = true;


	private List<Hechizo> hechizos;
	private int hechizoElegidoIndex = 0;
	//private String nombreRivalElegido = new String();
	private int combatienteElegidoIndice = 0;
	
	public String getNombre() {
		return nombre;
	}
	public double getDefensa() {
		return defensa;
	}
	public double getMana() {
		return mana;
	}
	public double getVida() {
		return vida;
	}

	public Personaje(String nombre) {
		super();
		this.nombre = nombre;
		this.mana = 50;
		this.defensa = 100;
		this.vida = 200;
	}

	public Personaje(String nombre, double mana, double defensa, double vida) {
		super();
		this.nombre = nombre;
		this.mana = mana;
		this.defensa = defensa;
		this.vida = vida;
	}

	public String toPrologStr() {
		return this.getNombre().toLowerCase() + ", " + (int)this.getVida() + ", " + (int)this.getDefensa();
	}


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

		
		this.lanzarHechizo(elegirHechizo(obj), (Personaje)obj.getCombatiente(this.combatienteElegidoIndice));
		return true;
	}

	//A borrar
	/*public boolean atacar(Personaje obj) {
		if(!this.vivo)
			return false;

		if(!verificarMana())
		{
			this.descansar();
			return false;
		}

		this.lanzarHechizo(elegirHechizo(null), new Auror());
		return true;
	}*/

	

	public void lanzarHechizo(Hechizo hechizo, Personaje objetivo) {
		
		// QUE PASA CUANDO UN PERSONAJE SE QUEDA SIN MANA??? LISTO
		// Y SI SE QUEDAN TODOS SIN MANA???????????????????????? UN BAJON
		// RTA: LO TIENE QUE RESOLVER HECHIZO, nop descansan
		
		this.mana -= hechizo.ejecutar(objetivo, this.mana);
	}

	
	private void sumarVida(double vida) {
		if(!this.getVivo())
			throw new RuntimeException("El Personaje " + this.getNombre() + " esta muerto! No puede recibir puntos de vida.");
		
		this.vida += vida;
	}
	
	private void restarVida(double danio) {

		this.vida -= danio;

		if (vida <= 0) 
			this.morir();
	}

	private void restarDefensa(double danio) {

		this.defensa -= danio;

	}


	
	private void morir() {
		
		this.vida = 0;
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
			if(this.getDefensa() > 0 )
				if(this.getDefensa() > danio)
					this.restarDefensa(danio);
				else{
					double restaDanio = danio - this.getDefensa();
					this.restarDefensa(this.getDefensa());
					System.out.println("El Personaje "+ this.getNombre()+" ha perdido su defensa!");
					this.restarVida(restaDanio);
					System.out.println("El Personaje "+ this.getNombre()+" ha sufrido daño! Queda con "+this.getVida()+" puntos de Vida!");
				}
			else
				this.restarVida(danio);
				System.out.println("El Personaje "+ this.getNombre()+" ha sufrido daño! Queda con "+this.getVida()+" puntos de Vida!");				
		}

	}
	
	private void mensajeMuerto() {
		
		// throw new RuntimeException
		System.out.println(this.nombre + " ha caído en batalla. El hechizo no surtió efecto!");
	}
	
	// setStrategyHechizo() : Hechizo
	// public void mostrarHechizos()

}
