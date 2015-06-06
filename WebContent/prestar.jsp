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
<h1> Prestar libros</h1>
<hr>
<h3> El prestamo de tus libros se ha hecho de forma correcta</h3>

<input id="Volver" type="button" onclick="javascript:enviarFormulario(this.value);" value="Volver al listado"></input>
</body>
</html>