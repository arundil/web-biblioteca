package pos.domain;

import java.util.LinkedList;
import java.util.List;

import pos.data.JDBCUsuarioDAO;

public class UsuarioStore implements IUsuarioStore {

	JDBCUsuarioDAO dao = new JDBCUsuarioDAO();
	
	public UsuarioStore()
	{
		super();
	}
	
	
	@Override
	public void AsignarLibrosUsuario(List<String> id_libros, String userid) {
		for (String s : id_libros)
		{
			dao.insertarLibrosPorUsuario(Integer.valueOf(s),Integer.valueOf(userid));	
		}
			
	}


	@Override
	public List<Usuario> SeleccionarTodosLosUsuarios() {
		return dao.selectAllUsuarios();
	}


	@Override
	public void DevolverTodosLosLibros(String idUsuario) {
		dao.eliminarLibrosPorUsuario(Integer.valueOf(idUsuario));
	}


	@Override
	public List<String> SeleccionarLibrosPrestadosPorUsuario(String iduser) {
		List<String> res = new LinkedList<String>();
		res = dao.selectIDLibrosPrestados(Integer.valueOf(iduser));
		return res;
	}

}
