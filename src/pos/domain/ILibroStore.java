package pos.domain;

import java.util.List;

public interface ILibroStore {
	public List<Libro> ObtenerTodosLosLibros();
	public List<Libro> ObtenerIDsReservados(List<String> ids);
	public void ActualizarDisponibles(List<String> ids,String valor);
}
