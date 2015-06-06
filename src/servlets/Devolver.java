package servlets;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pos.domain.LibroStore;
import pos.domain.UsuarioStore;

public class Devolver extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Devolver()
	{
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Logica de negocio para devolver todos libros
		
		UsuarioStore us = new UsuarioStore();
		LibroStore ls = new LibroStore();
		String userid = String.valueOf((request.getSession().getAttribute("id_usuario")));
		List<String> idlibrosprestados = new LinkedList<String>();
		idlibrosprestados = us.SeleccionarLibrosPrestadosPorUsuario(userid);
		ls.ActualizarDisponibles(idlibrosprestados, "SI");
		us.DevolverTodosLosLibros(userid);
		request.getRequestDispatcher("devolver.jsp").include(request, response);
		
	}
}
