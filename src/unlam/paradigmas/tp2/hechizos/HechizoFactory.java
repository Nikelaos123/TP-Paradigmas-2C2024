package unlam.paradigmas.tp2.hechizos;

import java.util.Random;

public abstract class HechizoFactory {

	protected static final Random RANDOM = new Random();

	public abstract Hechizo crearHechizo();

	/* //No se debería implementar, solo definir
	public Hechizo crearHechizo(String nombre, int costo, int poder) {

		int valorAleatorio = RANDOM.nextInt(HechizosEnum.obtenerCantidadValores());
		HechizosEnum hechizoAleatorio = HechizosEnum.obtenerPorValor(valorAleatorio);

		switch (hechizoAleatorio) {
		
		case ATAQUE:
			return new HechizoAtaque(nombre, costo, poder);
		case DEFENSA:
			return new HechizoSanacion(nombre, costo, poder);
		case SANACION:
			return new HechizoDefensa(nombre, costo, poder);
		default:
            throw new IllegalArgumentException("Hechizo desconocido");
		}
		
	}*/

}
