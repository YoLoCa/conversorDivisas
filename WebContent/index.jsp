<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css"/>


    <title>CONVERSOR DIVISAS</title>

<style type="text/css">

input[type=number]::-webkit-outer-spin-button,
input[type=number]::-webkit-inner-spin-button {
-webkit-appearance: none;
-moz-appearance:textfield;
}

input[type=number] {

-moz-appearance:textfield;

}

</style>


<script type="text/javascript">

function llamarServlet() {
	
	
	var salto = "PesetaServlet.do";
	
	if(document.getElementById("libra").checked) {
		salto = "LibraServlet.do";
	}
	// MODIFICAR EL ACTION DEL FORMULARIO EN TIEMPO REAL (que radio esta elegido).
	document.getElementById("conversorform").action = salto;
	
}



</script>


</head>

<body onload="f_inicio();">

    <div class="container bg-light p-3 border" style="margin: 30px auto 60px auto">
         <form action="" id="conversorform" name="conversorform" onsubmit="return llamarServlet();">
        <div class="row justify-content-center">
           
            <div class="col-12" style="text-align: center;">

                <h1>Conversor Divisas</h1> <hr>
            </div>
            <br />
           
            <div class="col-12"></div>

            <div class="col-4" style="text-align: center;">
                <img src="imagenes/euro-a-libra.png" alt="euros-libras" width="300" height="300"/>
            </div>

            <div class="col-12"></div>

            <div class="col-2" style="margin: 30px 0 30px 0; text-align: center">
                <label for="cantidad" id="canti">EUROS A</label>
                <input type="number" name="cantidad" id="cantidad" class="form-control input-sm" required step="0.01"/>
                
            </div>

            <div class="col-sm-12"></div>
            
            
            
            <div class="col-sm-12"></div>
            <div class="col-md-2" style="text-align: center;">CONVERTIR A
            <hr>
            </div>
            <div class="col-sm-12"></div>
            
            
            
            <div class="col-md-1">
                Libras <input type="radio" name="divisa" id="libra" value="libra" required checked/>
            </div>
            <div class="col-md-1">
                Pesetas <input type="radio" name="divisa" id="pesetas" value="pesetas" required/>
            </div>

            <div class="col-12"></div>
            
             
			
            <div class="row justify-content-center" style="margin-top: 30px ;">
                <div class="col-6">
                    <button class="btn btn-primary" type="submit">Convertir</button>
                </div>
                <div class="col-6">
                    <button class="btn btn-warning" type="reset" id="limpiar">Borrar</button>
                </div>
            </div>
            
            <div class="col-12"></div>
            
            
             <div class="row justify-content-center">
			<div class="col-12" style="margin: 30px 0 30px 0; text-align: center;">
            <p id="mensajesJS"></p>
		
		
			<p id="mensajesSERVIDOR" >
				${param.mensajeError}
			</p>
		<c:if test="${not empty param.resultadoConversion}">
		 <label for="resultados">RESULTADO</label>
		 <input type="text" id="resultados" class="form-control input-sm" step="0.01" 
					placeholder="${param.resultadoConversion} ${param.divisa}"/>					
				</c:if>
            
            </div>
            
         </div> 
            
        </div>
        </form> 
    </div>
</body>
</html>