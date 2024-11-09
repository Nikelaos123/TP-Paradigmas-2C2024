/*

NO PORQUE NO ME DEJA INSTANCIAR HECHIZOSANACION PORQUE COMO HECHIZO ES 
UNA INTERFAZ NO PUEDO LLEGAR A LOS ATRIBUTOS DE LAS CLASES CONCRETAS 
HECHIZOATAQUE, HECHIZODEFENSA, ETC

package unlam.paradigmas.tp2.hechizos;

public class CreadorHechizoSanacion extends HechizoFactory{
	
	@Override
	public Hechizo crearHechizo(String nombre, int costo, int poder) {

		return new HechizoSanacion(nombre, costo, poder);
	}

}

*/