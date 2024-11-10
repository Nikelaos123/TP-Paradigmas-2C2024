package unlam.paradigmas.tp2.hechizos;

public class CreadorHechizoDefensa extends HechizoFactory {

	//Niveles de Defensa:
	//Debil: 25 / 50
	//Comun: 30 / 75 -> Default
	//Fuerte: 35 / 100

	@Override
	public Hechizo crearHechizo() {

		//Generar numero aleatorio (1 al 3) para definir nivel del hechizo
        int numeroAleatorio = RANDOM.nextInt(3) + 1; 

		switch (numeroAleatorio) {
			case 1:
				System.out.println("Se creó un hechizo de Defensa Debil");
				return new HechizoDefensa("Defensa - Debil", 25, 50);

			case 2:
				System.out.println("Se creó un hechizo de Defensa Comun");
				return new HechizoDefensa("Defensa - Comun", 30, 75);

			case 3:
				System.out.println("Se creó un hechizo de Defensa Fuerte!");
				return new HechizoDefensa("Defensa - Fuerte", 35, 100);
		}

		//En caso de error, se retorna un Hechizo Comun
		return new HechizoDefensa();
	}

}
