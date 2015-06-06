<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="JavaScript" >
			var css="css/estilos.css";
		document.write("<link href='" + css + "' rel='stylesheet' type='text/css'>"); 
		
		function enviarFormulario(valor){

					window.location="FrontController?accion=redireccionar";

		}
</script>
</head>
<body>
<h1>QUEDAN MENOS DE 10 LIBROS en el sistema</h1>
<h3>Debe esperar a que otros usuarios devuelvan sus libros o reducir su seleccion.</h3>
<input id="Volver" type="button" onclick="javascript:enviarFormulario(this.value);" value="Volver al listado"></input>
</body>
</html>