package modelo;


public abstract class Factoria {

	public static Calculadora obtenerCalculadora() {
		return new Calculadora();
	}

	public static Conversor obtenerConversor() {
		return new Conversor();
	}
	
	// MEJOR UTILIZA LA FACTORÍA GENÉRICA <T>T
	
}
