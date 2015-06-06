package servlets;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pos.domain.Libro;
import pos.domain.LibroStore;
import pos.domain.UsuarioStore;

public class Reservar extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Reservar ()
	{
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String num_libros = request.getParameter("numlibros");
		LibroStore ls = new LibroStore();
		UsuarioStore us = new UsuarioStore();

		
		int num_lib = -1;
		if (num_libros != null)
		{
			 num_lib= Integer.valueOf(num_libros);
		}
		
		
		if ((num_lib<=10) && (num_lib!= -1))
		{
			request.getRequestDispatcher("lessthan10books.jsp").include(request,response);
		}
		else if (num_lib == -1)
		{
			request.getRequestDispatcher("error.jsp").include(request,response);
		}
		else if (num_lib>10)
		{
			List<String> lista_reserva = new LinkedList<String>();
			
			for (int i = 1; i<=num_lib; i++)
			{
				String valueCheckbox = request.getParameter("libro"+i);
				if (valueCheckbox != null)
				{
					lista_reserva.add(valueCheckbox);
				}
			}
			
			
			List<Libro> ll = new LinkedList<Libro>();
			ll= ls.ObtenerTodosLosLibros();
			int num_libros_libres_BBDD = 0; 
			Boolean conflicto_reserva = false;
			List<String> id_disponibles = new LinkedList<String>();
			
			for (Libro l : ll)
			{
				if (l.GetDisponibilidad().equals("SI"))
				{
					num_libros_libres_BBDD = num_libros_libres_BBDD+1;
					id_disponibles.add(String.valueOf(l.GetIDLibro()));
				}	
				
			}

			if (num_libros_libres_BBDD == num_lib)
			{
				conflicto_reserva = false;
			}
			else
			{
				//Aqui hay que comparar el listado de libros
				
				if (!id_disponibles.containsAll(lista_reserva))
				{
					conflicto_reserva = true;
				}
			}
			
			
			if (num_libros_libres_BBDD > 10 && conflicto_reserva)
			{
				//Hay libros que se han solicitado prestarse, pero ahora estan no disponibles.
				request.getRequestDispatcher("revisarreserva.jsp").include(request,response);
			}
			else if (num_libros_libres_BBDD-lista_reserva.size() < 10)
			{
				//Hay menos de 10 libros para prestar... se cancela la transaccion.
				
				request.getRequestDispatcher("lessthan10books.jsp").include(request,response);
			}
			else if (num_libros_libres_BBDD > 10 && !conflicto_reserva)
			{
				//Todos los libros estan disponibles y se prestan. Queda su estado como No disponible
				//hasta que se devuelvan.
				
				ls.ActualizarDisponibles(lista_reserva, "NO");
				String iduser = String.valueOf(request.getSession().getAttribute("id_usuario"));
				us.AsignarLibrosUsuario(lista_reserva,iduser);
				request.getRequestDispatcher("prestar.jsp").include(request,response);
			}
			else
			{
				request.getRequestDispatcher("error.jsp").include(request,response);
			}
		}	
	}
}
