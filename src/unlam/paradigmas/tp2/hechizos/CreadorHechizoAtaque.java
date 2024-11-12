package unlam.paradigmas.tp2.hechizos;

public class CreadorHechizoAtaque extends HechizoFactory {

	// Niveles de Ataque:
	// Debil: 25 / 75
	// Comun: 30 / 125 -> Default
	// Fuerte: 35 / 200

	@Override
	public Hechizo crearHechizo() {

		// Generar numero aleatorio (1 al 3) para definir nivel del hechizo
		int numeroAleatorio = RANDOM.nextInt(3) + 1;

		switch (numeroAleatorio) {
			case 1:
				// System.out.println("Se creó un hechizo de Ataque Debil");
				return new HechizoAtaque("Ataque - Debil", 25, 100);

			case 2:
				// System.out.println("Se creó un hechizo de Ataque Comun");
				return new HechizoAtaque("Ataque - Comun", 30, 150);

			case 3:
				// System.out.println("Se creó un hechizo de Ataque Fuerte!");
				return new HechizoAtaque("Ataque - Fuerte", 35, 200);
		}

		// En caso de error, se retorna un Hechizo Comun
		return new HechizoAtaque();
	}

}
