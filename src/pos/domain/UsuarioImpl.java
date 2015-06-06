package pos.domain;

public class UsuarioImpl implements Usuario {
	
	private int usuarioid;
	private String nombre;
	private String apellidos;
	private String dni;

	public UsuarioImpl()
	{
		super();
	}
	
	@Override
	public int GetUsuarioID() {
		return usuarioid;
	}

	@Override
	public String GetNombreUsuario() {
		return nombre;
	}

	@Override
	public String GetApellidosUsuario() {
		return apellidos;
	}

	@Override
	public String GetDni() {
		return dni;
	}

	@Override
	public void SetUsuarioID(int idusuario) {
		this.usuarioid=idusuario;
	}

	@Override
	public void SetNombreUsuario(String nombre) {
		this.nombre=nombre;
	}

	@Override
	public void SetApellidosUsuario(String apellidos) {
		this.apellidos=apellidos;
	}

	@Override
	public void SetDni(String DNI) {
		this.dni=DNI;
	}

}
