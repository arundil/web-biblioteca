package pos.data;

import java.util.List;

import pos.domain.Usuario;

public interface IUsuarioDAO {
	
	public List<Usuario> selectAllUsuarios();
	public Usuario selectUsuarioPorId(int id);
	public Usuario selectUsuarioPorDni(String dni);
	public List<String> selectIDLibrosPrestados(int userid);
	public void insertarLibrosPorUsuario(int libroID , int userId);
	public void eliminarLibrosPorUsuario(int userId);

}
