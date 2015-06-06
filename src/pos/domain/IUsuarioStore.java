package pos.domain;

import java.util.List;

public interface IUsuarioStore {
	
	public void AsignarLibrosUsuario(List<String> id_libros, String userId);
	public List<Usuario> SeleccionarTodosLosUsuarios();
	public void DevolverTodosLosLibros(String id_usuario);
	public List<String> SeleccionarLibrosPrestadosPorUsuario(String iduser);

}
