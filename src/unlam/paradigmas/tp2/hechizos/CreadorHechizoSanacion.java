package unlam.paradigmas.tp2.hechizos;



public class CreadorHechizoSanacion extends HechizoFactory{
	
	//Niveles de Sanación:
	//Debil: 25 / 75
	//Comun: 30 / 100 -> Default
	//Fuerte: 35 / 150

	@Override
	public Hechizo crearHechizo() {
	
        //Generar numero aleatorio (1 al 3) para definir nivel del hechizo
        int numeroAleatorio = RANDOM.nextInt(3) + 1; 

		switch (numeroAleatorio) {
			case 1:
				//System.out.println("Se creó un hechizo de Sanación Debil");
				return new HechizoSanacion("Sanacion - Debil", 25, 50);

			case 2:
				//System.out.println("Se creó un hechizo de Sanación Comun");
				return new HechizoSanacion("Sanacion - Comun", 30, 100);

			case 3:
				//System.out.println("Se creó un hechizo de Sanación Fuerte!");
				return new HechizoSanacion("Sanacion - Fuerte", 35, 150);
		}

		//En caso de error, se retorna un Hechizo Comun
		return new HechizoSanacion();
    }

}



