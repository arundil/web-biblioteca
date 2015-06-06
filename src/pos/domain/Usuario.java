package pos.domain;

public interface Usuario {
	public int GetUsuarioID();
	public String GetNombreUsuario();
	public String GetApellidosUsuario();
	public String GetDni();
	
	public void SetUsuarioID(int idusuario);
	public void SetNombreUsuario(String nombre);
	public void SetApellidosUsuario(String apellidos);
	public void SetDni(String DNI);
}
