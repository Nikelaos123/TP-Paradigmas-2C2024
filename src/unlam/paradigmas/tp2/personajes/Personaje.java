package unlam.paradigmas.tp2.personajes;

import unlam.paradigmas.tp2.FileManager.FileManager;
import unlam.paradigmas.tp2.hechizos.CreadorHechizoAtaque;
import unlam.paradigmas.tp2.hechizos.Hechizo;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BooleanSupplier;

public abstract class Personaje {

	// private static final int DEFENSA_TOTAL = 1000;

	protected String nombre;
	protected double mana; // nivel de magia disponible para gastar en ejecutar hechizos
	protected double defensa; // puntos para disminuir el danio al recibir un ataque
	// private double vidaMaxima; // puntos de vida para poder recibir danio hasta
	// morir???
	protected double vida;
	protected boolean vivo = true;

	protected List<Hechizo> hechizos = new LinkedList<Hechizo>();
	protected String nombreHechizoElegido;
	// private String nombreRivalElegido = new String();
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
		return this.getNombre().toLowerCase() + ", " + (int) this.getVida() + ", " + (int) this.getDefensa();
	}

	public void agregarHechizo(Hechizo hechizo) {
		this.hechizos.add(hechizo);
	}

	public void removerHechizo(String nombreHechizo) {

		hechizos.removeIf(hechizo -> hechizo.getNombre().equals(nombreHechizo));
	}

	// A usar en FileManager cuando se muestra el Log
	public String darReporte() {
		return this.getNombre() + " / HP:  " + this.getVida() + " / MP:" + this.getMana() + " / DEF: " +
				this.getDefensa() + "/ Hechizos: " + hechizos.size() +
				" / Estado: " + (this.getVivo() ? "OK" : "Eliminado");
	}

	public String darReporteCompleto() {
		return this.getNombre() +
				"\n / Puntos de Vida:  " + this.getVida() +
				"\n / MP:" + this.getMana() +
				"\n / Defensa: " + this.getDefensa() +
				"\n / Hechizos Disponibles: " + hechizos.size() +
				"\n / Estado: " + (this.getVivo() ? "En Combate" : "Fuera de Combate");
	}

	private void setEnemigoElegido(String enemigo) {
		this.enemigoElegido = enemigo;
	}

	public boolean getVivo() {
		return vivo;
	}

	public int getCantidadHechizos() {
		return hechizos.size();
	}

	// retorna true si hay mana suficiente para el mayor coste
	public boolean verificarMana() {

		double maxManaRequerido = 5;

		/*
		 * for (Hechizo hechizo : hechizos) {
		 * if (hechizo.getCosto() > maxManaRequerido)
		 * maxManaRequerido = hechizo.getCosto();
		 * }
		 */

		return mana >= maxManaRequerido;
	}

	public void descansar() {
		System.out.println("-" + this.getNombre() + " se dispone a descansar.");
		this.recibirMana(25);
	}

	// Implementa Strategy
	private Optional<Hechizo> elegirHechizo(Batallon obj) {

		FileManager fileManager = new FileManager();

		// Consulta si tiene el hechizo de curacion y si debe usar hechizo sanacion
		if (hechizos.stream().anyMatch(hec -> hec.getNombre().contains("Sanacion"))
				&& fileManager.decisionCurarse(vida)) {
			setEnemigoElegido("");
			return hechizos.stream().filter(hec -> hec.getNombre().contains("Sanacion")).findFirst();
		}

		// Consulta si tiene el hechizo de defensa y si debe usar hechizo defensa
		if (hechizos.stream().anyMatch(hec -> hec.getNombre().contains("Defensa"))
				&& fileManager.decisionDefenderse(this.defensa)) {
			setEnemigoElegido("");
			return hechizos.stream().filter(hec -> hec.getNombre().contains("Defensa")).findFirst();
		}

		// Consulta si tiene el hechizo de ataque y a quien atacar
		if (hechizos.stream().anyMatch(hec -> hec.getNombre().contains("Ataque"))) {

			this.setEnemigoElegido(fileManager.decisionAtacar(obj));
			return hechizos.stream().filter(hec -> hec.getNombre().contains("Ataque")).findFirst();
		}

		// verificar que hay hechizos

		hechizos.add(new CreadorHechizoAtaque().crearHechizo()); // invoca un nuevo hechizo

		return null; // A reemplazar
	}

	// Realizar Turno
	public boolean atacar(Batallon obj) {

		if (!obj.hayVivos())
			return false;

		if (!this.vivo)
			return false;

		System.out.println(
				"-->Es turno de " + this.getNombre() + "! (" + this.vida + "/" + this.defensa + "/" + this.mana + ")");

		if (!verificarMana()) {
			this.descansar();
			return true;
		}

		this.lanzarHechizo(elegirHechizo(obj), obj);
		return true;
	}

	private void lanzarHechizo(Optional<Hechizo> hechizo, Batallon obj) {

		if (hechizo == null) {
			this.descansar();
			return;
		}

		if (enemigoElegido.isEmpty()) {
			System.out.println(
					"-->" + this.getNombre() + " lanza un hechizo de sanacion/defensa.");
			hechizo.get().ejecutar(this);
		} else {
			System.out.println("->" + this.getNombre() + " lanza un hechizo de ataque a " + this.enemigoElegido);
			hechizo.get().ejecutar(obj.getCombatiente(this.enemigoElegido));
		}

		hechizos.removeIf(hec -> hec.getNombre().equals(hechizo.get().getNombre()));

		this.restarMana(hechizo.get().getCosto());
	}

	private void sumarVida(double vida) {
		if (!this.getVivo())
			throw new RuntimeException(
					"El Personaje " + this.getNombre() + " esta muerto! No puede recibir puntos de vida.");

		this.vida += vida;
	}

	private void restarVida(double danio) {

		this.vida -= danio;

		if (vida <= 0)
			this.morir();
	}

	private void restarMana(double mana) {

		if ((this.mana - mana) < 0)
			this.mana = 0;
		else
			this.mana -= mana;
	}

	private void sumarMana(double mana) {
		this.mana += mana;
	}

	private void restarDefensa(double danio) {
		this.defensa -= danio;
	}

	private void morir() {

		this.vida = 0;
		this.defensa = 0;
		this.mana = 0;
		this.vivo = false;
	}

	public void recibirDefensa(double defensa) {

		if (!this.vivo) {
			this.mensajeMuerto();

		} else {
			this.defensa += defensa;
			System.out.println(this.getNombre() + " recibió " + defensa + " puntos de defensa.");
		}
	}

	public void recibirMana(double mana) {

		if (!this.vivo) {
			this.mensajeMuerto();

		} else {
			this.sumarMana(mana);
			System.out.println(this.getNombre() + " recibió " + mana + " puntos de mana.");
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

		} else if (this.getDefensa() > 0) {
			if (this.getDefensa() > danio) {
				this.restarDefensa(danio);
			} else {
				double restaDanio = danio - this.getDefensa();
				this.restarDefensa(this.getDefensa());
				System.out.print("El Personaje " + this.getNombre() + " ha perdido su defensa! ");
				this.restarVida(restaDanio);
				System.out.println("El Personaje " + this.getNombre() + " ha sufrido daño! Queda con "
						+ this.getVida() + " puntos de Vida! ");
			}
		} else {
			this.restarVida(danio);
			System.out.println("El Personaje " + this.getNombre() + " ha sufrido daño! Queda con " + this.getVida()
					+ " puntos de Vida!");
		}

	}

	private void mensajeMuerto() {

		System.out.println(this.nombre + " ha caído en batalla.");
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		// if (o == null || getClass() != o.getClass())
		if (o == null || !(o instanceof Personaje))
			return false;
		Personaje persona = (Personaje) o;
		return Objects.equals(nombre, persona.getNombre());
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

}
