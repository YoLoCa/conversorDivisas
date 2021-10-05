package servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Factoria;
import modelo.ICalculadora;
import modelo.IConversor;


@WebServlet("/PesetaServlet") 
public class PesetaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesarPeticion(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesarPeticion(request, response);
	}

	
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("\n>>> EN EL SERVLET ... " + getClass().getSimpleName() + "\n\n");
	
		
		IConversor conversor = Factoria.obtenerConversor();
		
		String valorCantidad = request.getParameter("cantidad");
		
		
		double cantidad;		
		
		try {
			
			cantidad = conversor.convertir(valorCantidad);
			
		} catch(NumberFormatException nfe) {
			
			response.sendRedirect("index.jsp?mensajeError=VALOR INCORRECTO PARA LOS EUROS ... " + valorCantidad);
			
			return;
			
		}
		
		// CONVERSIÓN DE CELSIUS A KELVIN (crea un método en la calculadora que le des grados y te devuelva Kelvin y lo mismo con FH):
		//double resultadoConversion = grados * FACTOR_KELVIN;
		
		ICalculadora calculadora = Factoria.obtenerCalculadora();
		
		double resultadoConversion = calculadora.convertirEurosPesetas(cantidad);
		
		//double resultadoConversion = ((ICalculadora)Factoria.obtenerCalculadora()).convertirCelsiusFahrenheit(grados);
		
		response.sendRedirect("index.jsp" + 
								"?euro = " + cantidad + 
								"&divisa = PESETA" + 
								"&resultadoConversion=" + resultadoConversion);
		
	}
	
}
