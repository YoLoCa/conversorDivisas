package modelo;


class Calculadora implements ICalculadora {


	private static final double FACTOR_PESETAS		= 166.38;
	private static final double FACTOR_LIBRAS 		= 0.86;
	
	
	public double convertirEurosPesetas(double cantidad) {		
		return cantidad * FACTOR_PESETAS;		
	}
	
	
	public double convertirEurosLibras(double cantidad) {		
		return cantidad * FACTOR_LIBRAS;		
	}
	
}
