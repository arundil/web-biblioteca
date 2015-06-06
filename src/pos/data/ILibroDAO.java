package pos.data;

import java.util.List;

import pos.domain.Libro;
import pos.domain.Usuario;

public interface ILibroDAO {
	
	public List<Libro> sellectAll();
	public List<Libro> getLibroPorUsuario(Usuario user);
	public Libro selectLibroPorId(int id_libro);
	public void updateDispobible(int id_libro, String valor);
	public List<Libro> selectLibrosDisponibles();
	public List<Libro> selectLibrosPrestados();

}
