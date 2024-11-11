package unlam.paradigmas.tp2.personajes;

import unlam.FileManager.FileManager;
import unlam.paradigmas.tp2.hechizos.CreadorHechizoAtaque;
import unlam.paradigmas.tp2.hechizos.Hechizo;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


public abstract class Personaje {
	
	//private static final int DEFENSA_TOTAL = 1000;

	protected String nombre;
	protected double mana; // nivel de magia disponible para gastar en ejecutar hechizos
	protected double defensa; // puntos para disminuir el danio al recibir un ataque
	//private double vidaMaxima; // puntos de vida para poder recibir danio hasta morir???
	protected double vida;
	protected boolean vivo = true;


	protected List<Hechizo> hechizos = new LinkedList<Hechizo>();
	protected String nombreHechizoElegido;
	//private String nombreRivalElegido = new String();
	protected int combatienteElegidoIndice = 0;
	private String enemigoElegido;

	
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

	public void agregarHechizo(Hechizo hechizo){
		this.hechizos.add(hechizo);
	}

	public void removerHechizo(String nombreHechizo){

		hechizos.removeIf(hechizo -> hechizo.getNombre().equals(nombreHechizo));
	
	}

	//Implementa Strategy
	public Optional<Hechizo> elegirHechizo(Batallon obj) {
		
		FileManager fm = new FileManager();




		//Consulta si tiene el hechizo de curacion y si debe usar hechizo sanacion
		if( hechizos.stream().anyMatch(hec -> hec.getNombre().contains("Sanacion"))  && fm.decisionCurarse(vida)){
			return hechizos.stream().filter(hec -> hec.getNombre().contains("Sanacion")).findFirst();
		}

		if(hechizos.stream().anyMatch(hec -> hec.getNombre().contains("Defensa")) && fm.decisionDefenderse(this.defensa)) {
			return hechizos.stream().filter(hec -> hec.getNombre().contains("Defensa")).findFirst();
		}

		if(hechizos.stream().anyMatch(hec -> hec.getNombre().contains("Ataque"))){
			//falta elegir a quien atacar, hay que llamar al fm y ejectuar menosVida
			this.setEnemigoElegido(fm.decisionAtacar(obj));
			return hechizos.stream().filter(hec -> hec.getNombre().contains("Ataque")).findFirst();
		}
		


		//verificar que hay hechizos
		if(hechizos.size() == 0)
			hechizos.add(new CreadorHechizoAtaque().crearHechizo()); //invoca un nuevo hechizo

		
		
		return null; //A reemplazar
	}

	private void setEnemigoElegido(String enemigo) {
		this.enemigoElegido = enemigo;
	}

	public boolean getVivo() {
		return vivo;
	}

	//A usar en FileManager cuando se muestra el Log
	public String darReporte(){
		return this.getNombre() + " / HP:  " + this.getVida() + " / MP:" + this.getMana() + " / DEF: " +
				this.getDefensa() + "/ Hechizos: " + hechizos.size() +
				" / Estado: " + (this.getVivo()?  "OK" : "Eliminado");
	}

	public String darReporteCompleto(){
		return this.getNombre() + " / Puntos de Vida:  " + this.getVida() + 
				"\n / MP:" + this.getMana() + 
				"\n / Defensa: " + this.getDefensa() + 
				"\n / Hechizos Disponibles: " + hechizos.size() +
				"\n / Estado: " + (this.getVivo()?  "En Combate" : "Fuera de Combate");
	}

	//retorna true si hay mana suficiente para el mayor coste
	public boolean verificarMana(){

		double maxManaRequerido = 0;
 
		for (Hechizo hechizo : hechizos) {
			if( hechizo.getCosto() > maxManaRequerido)
			maxManaRequerido = hechizo.getCosto();
		}

		return mana >= maxManaRequerido;
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

	

	public void lanzarHechizo(Optional<Hechizo>  hechizo, Personaje objetivo) {
		
		if(hechizo == null){
			this.descansar();
			return;
		}

		
		
		//hechizos.contains(objetivo)  .ejecutar(objetivo);

		mana -= hechizos.getFirst().getCosto();
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
