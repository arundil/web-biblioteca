<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="pos.domain.UsuarioStore"%>
<%@page import="pos.domain.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servicio de Prestasmo Bibliotecario</title>

<script language="JavaScript" >
			var css="css/estilos.css";
		document.write("<link href='" + css + "' rel='stylesheet' type='text/css'>"); 
		
		function enviarFormulario1(valor){
			document.form1.action="FrontController?accion=entrar";
			document.form1.submit();
		}
		function enviarFormulario2(valor){
			document.form2.action="FrontController?accion=entrar";
			document.form2.submit();
		}
		function enviarFormulario3(valor){
			document.form3.action="FrontController?accion=entrar";
			document.form3.submit();
		}
</script>
</head>
<body>
<h1>Bienvenido al servicio de prestamo bibliotecario</h1>
<hr>
<h3>Por favor seleccione el usuario con el que desa iniciar sesion y pulse entrar</h3>

<%
	UsuarioStore us = new UsuarioStore();
	int i = 1;
	for (Usuario s : us.SeleccionarTodosLosUsuarios())
	{
%>
	<form id="form<%=i%>" name="form<%=i%>" action="" method="post">
	<input id="usuariodata" name="user" type="hidden" onclick="" value="<%=s.GetUsuarioID()%>,<%=s.GetNombreUsuario()%>"></input>
	<input id="acceder" type="button" onclick="javascript:enviarFormulario<%=i%>(this.value);" value="entrar"></input>
	<label><%=s.GetNombreUsuario()%></label><br>
	</form>
   <%
   i= i+1;
	}%>
</body>
</html>