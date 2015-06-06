package pos.domain;

public class LibroImpl implements Libro {

	private int idlibro;
	private String nombreLibro;
	private String autor;
	private String editorial;
	private String edicion;
	private String aniopub;
	private String ubib;
	private String disponib;
	
	public LibroImpl()
	{
		
	}
	@Override
	public int GetIDLibro() {
		
		return this.idlibro;
	}

	@Override
	public String GetNombreLibro() {
		return this.nombreLibro;
	}

	@Override
	public String GetAutor() {
		return this.autor;
	}

	@Override
	public String GetEditorial() {
		return this.editorial;
	}

	@Override
	public String GetEdicion() {
		return this.edicion;
	}

	@Override
	public String GetAnioPublicacion() {
		return this.aniopub;
	}

	@Override
	public String GetUbicacion() {
		return this.ubib;
	}

	@Override
	public String GetDisponibilidad() {
		return this.disponib;
	}
	@Override
	public void SetGIDLibro(int id_libro) {
		this.idlibro= id_libro;
	}
	@Override
	public void SetNombreLibro(String nombre_libro) {
		this.nombreLibro= nombre_libro;
	}
	@Override
	public void SetAutor(String autor) {
		this.autor = autor;
	}
	@Override
	public void SetEditorial(String editorial) {
		this.editorial = editorial;
	}
	@Override
	public void SetEdicion(String edicion) {
		this.edicion = edicion;
	}
	@Override
	public void SetAnioPublicacion(String anopub) {
		this.aniopub = anopub;
	}
	@Override
	public void SetUbicacion(String ubicacion) {
		this.ubib= ubicacion;
	}
	@Override
	public void SetDisponibilidad(String disponibilidad) {
		this.disponib= disponibilidad;
	}

}
