package pos.domain;

import java.util.LinkedList;
import java.util.List;

import pos.data.JDBCLibroDAO;

public class LibroStore implements ILibroStore {

	public JDBCLibroDAO dao;
	
	public LibroStore(){
		dao = new JDBCLibroDAO();
	}

	@Override
	public List<Libro> ObtenerTodosLosLibros() {
		return dao.sellectAll();
	}

	@Override
	public List<Libro> ObtenerIDsReservados(List<String> ids) {
		
		List<Libro> res = new LinkedList <Libro>();
		for (String id_libro : ids)
		{
			Libro l = dao.selectLibroPorId(Integer.valueOf(id_libro));
			if (l!=null)
			{
				if (l.GetDisponibilidad().equals("NO"))
				{
					res.add(l);
				}
			}
			
		}
		return res;
	}

	@Override
	public void ActualizarDisponibles(List<String> ids, String valor) {
		
		for (String id_libro : ids)
		{
			dao.updateDispobible(Integer.valueOf(id_libro), valor);
		}
	}
}