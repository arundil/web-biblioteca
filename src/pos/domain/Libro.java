package pos.domain;

public interface Libro {

	public int GetIDLibro();
	public String GetNombreLibro();
	public String GetAutor();
	public String GetEditorial();
	public String GetEdicion();
	public String GetAnioPublicacion();
	public String GetUbicacion();
	public String GetDisponibilidad();
	
	public void SetGIDLibro(int id_libro);
	public void SetNombreLibro(String nombre_libro);
	public void SetAutor(String autor);
	public void SetEditorial(String editorial);
	public void SetEdicion(String edicion);
	public void SetAnioPublicacion(String anopub);
	public void SetUbicacion(String ubicacion);
	public void SetDisponibilidad(String disponibilidad);
}
