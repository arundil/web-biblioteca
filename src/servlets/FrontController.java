package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontControler
 */
@WebServlet("/FrontControler")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String accion = request.getParameter("accion");
    	procesarAccion(accion, request, response);
    }

    public void procesarAccion(String accion, HttpServletRequest request,
    		HttpServletResponse response) throws ServletException, IOException 
    {
    	if (accion.equals("entrar")) 
    	{
    		entrar(request, response);
    	}
    	else if (accion.equals("reservar"))
    	{
    		reservar(request, response);
    	}else if (accion.equals("devolver"))
    	{
    		devolver(request, response);
    	}else if (accion.equals("redireccionar"))
    	{
    		redireccionar(request, response);
    	}
    	else
    	{
    		error404(request, response);
    	}
    }
    
    private void redireccionar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("booklist.jsp").include(request, response);
	}

	private void devolver(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("Devolver").include(request, response);
	}

	private void error404(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("404.html").include(request, response);
		
	}

	private void reservar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("Reservar").include(request, response);
		
	}

	private void entrar(HttpServletRequest request,
    	HttpServletResponse response) throws ServletException, IOException {
		String [] data = request.getParameter("user").split(",");
		request.getSession().setAttribute("id_usuario", data[0]);
		request.getSession().setAttribute("nombre",data[1]);
    	request.getRequestDispatcher("booklist.jsp").include(request, response);
    }
}
