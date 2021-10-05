package servlets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do") 									// PATRÓN DE LLAMADA
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesarPeticion(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesarPeticion(request, response);
	}

	
	
	//////////////////////////////////////
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("\n>>> EN EL SERVLET ... " + getClass().getSimpleName() + "\n\n");
	
		// TU LÓGICA DE DESPACHAMIENTO ...
		//
		//
		
		String peticion = request.getServletPath();
		System.out.println("\nFC: peticion - servletPath: " + peticion);
	
		// 			/KelvinServlet.do
		
		peticion = peticion.substring(0, peticion.lastIndexOf("."));
		
		//			/KelvinServlet
		
		request.getRequestDispatcher(peticion).forward(request, response);
		
	}
	
}
