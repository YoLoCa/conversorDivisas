package modelo;


public abstract class Factoria {

	public static Calculadora obtenerCalculadora() {
		return new Calculadora();
	}

	public static Conversor obtenerConversor() {
		return new Conversor();
	}
	
	// MEJOR UTILIZA LA FACTOR�A GEN�RICA <T>T
	
}
