package unlam.paradigmas.tp2.hechizos;

public enum HechizosEnum {
	
	ATAQUE(1),
	DEFENSA(2),
	SANACION(3);
	
	private final int valor;
	
	HechizosEnum(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public static int obtenerCantidadValores() {
		
		return HechizosEnum.values().length;
	}
	
	public static HechizosEnum obtenerPorValor(int valor) {
		
		for(HechizosEnum hechizo : HechizosEnum.values()) {
			
			if(hechizo.getValor() == valor) {
				return hechizo;
			}
		}
		
		throw new IllegalArgumentException("Hechizo desconocido");
	}
	

}
