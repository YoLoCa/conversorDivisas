package modelo;


/* de paquete */
class Conversor implements IConversor {

	public double convertir(String cadena) {
		return Double.parseDouble(cadena);
	}
	
}
