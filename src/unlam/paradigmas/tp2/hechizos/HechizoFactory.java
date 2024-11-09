package unlam.paradigmas.tp2.hechizos;

import java.util.Random;

public abstract class HechizoFactory {

	private static final Random random = new Random();

	public Hechizo crearHechizo(String nombre, int costo, int poder) {

		int tipoAleatorio = random.nextInt(2);

		switch (tipoAleatorio) {
		case 0:
			return new HechizoAtaque(nombre, costo, poder);
		case 1:
			return new HechizoSanacion(nombre, costo, poder);
		case 2:
			return new HechizoDefensa(nombre, costo, poder);
		default:
            throw new IllegalArgumentException("Hechizo desconocido");
		}
		

	}

}
