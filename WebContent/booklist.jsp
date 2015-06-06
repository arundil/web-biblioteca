<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="pos.domain.LibroStore"%>
<%@page import="pos.domain.Libro"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BibliotecaWEB-Lista de libros</title>

<script language="JavaScript" >
			var css="css/estilos.css";
		document.write("<link href='" + css + "' rel='stylesheet' type='text/css'>"); 
		
		function enviarFormulario(valor)
		{
			if (valor == "devolver")
			{
				window.location="FrontController?accion=devolver";
				
			}
			
			if (valor == "reservar")
			{
				document.formulario.action="FrontController?accion=reservar";
				document.formulario.submit()
			}
		}
</script>

</head>
<body>
	<h1>Lista de libros</h1>
	<hr>
	<h2>Bienvenid@: <%=session.getAttribute("nombre")%></h2>
	
	<input id="Devolver" type="button" onclick="javascript:enviarFormulario(this.value);" value="devolver"></input>
	
	<h3>por favor seleccione de la lista los libros que quiere
		reservar:</h3>
	<form id="formulario" name="formulario" action="" method="post">
		<h5>ID, Nombre libro, Autor, Editorial</h5>
		<%
		LibroStore ls = new LibroStore();
		int i = 1;
		for (Libro l : ls.ObtenerTodosLosLibros()) {
			if(l.GetDisponibilidad().equals("SI"))
			{
		%>
		<h5>
			<input id="libro<%=i%>" name="libro<%=i%>" type="checkbox" onclick="" value="<%=l.GetIDLibro()%>"></input>
			<%=i+". "+l.GetNombreLibro()+", "+l.GetAutor() +", "+ l.GetEditorial()%>
						
		</h5>
		<%
			i=i+1;
			}
		}%>
		
		<input id="numlibros" name="numlibros" type= "hidden" value="<%=i-1%>">
		<input id="Confirmar" type="button" onclick="javascript:enviarFormulario(this.value);" value="reservar"></input>
	</form>
</body>
</html>