package pos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pos.domain.Libro;
import pos.domain.LibroImpl;
import pos.domain.Usuario;
import pos.utils.ConnectionManager;

public class JDBCLibroDAO implements ILibroDAO {

	private Connection conn;
	
	public JDBCLibroDAO (){
		conn = ConnectionManager.getInstance().checkOut();
		//udao = new JDBCUsuarioDao();
	}
	
	@Override
	public List<Libro> sellectAll() {
		String sql = "SELECT * FROM Libro";
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Libro> res = new LinkedList<Libro>();
		
		try 
		{
			stmt = conn.prepareStatement(sql);

			result = stmt.executeQuery();
			
			while(result.next())
			{
				Libro l = new LibroImpl();
				l.SetGIDLibro(result.getInt("id_libro"));
				l.SetNombreLibro(result.getString("nombre_libro"));
				l.SetAutor(result.getString("autor"));
				l.SetEditorial(result.getString("editorial"));
				l.SetAnioPublicacion(result.getString("anio_publicacion"));
				l.SetUbicacion(result.getString("ubicacion"));
				l.SetDisponibilidad(result.getString("disponible"));
				res.add(l);
			}
		}
		catch(SQLException ex)
		{
			System.out.println("Message: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("ErrorCode: " + ex.getErrorCode());
		}
		finally 
		{
			try 
			{
				if (result != null) {
					result.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			}
			catch (SQLException e) 
			{
				System.out.println("Message: " + e.getMessage());
				System.out.println("SQLState: " + e.getSQLState());
				System.out.println("ErrorCode: " + e.getErrorCode());
			}
		}
		
		return res;
	}

	@Override
	public List<Libro> getLibroPorUsuario(Usuario user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro selectLibroPorId(int id_libro) {
		
		String sql = "SELECT * FROM Libro WHERE id_libro = "+id_libro+";";
		PreparedStatement stmt = null;
		ResultSet result = null;
		Libro res = new LibroImpl();
		
		try 
		{
			stmt = conn.prepareStatement(sql);

			result = stmt.executeQuery();
			while(result.next())
			{
				res.SetGIDLibro(result.getInt("id_libro"));
				res.SetNombreLibro(result.getString("nombre_libro"));
				res.SetAutor(result.getString("autor"));
				res.SetEditorial(result.getString("editorial"));
				res.SetAnioPublicacion(result.getString("anio_publicacion"));
				res.SetUbicacion(result.getString("ubicacion"));
				res.SetDisponibilidad(result.getString("disponible"));
			}
		}
		catch(SQLException ex)
		{
			System.out.println("Message: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("ErrorCode: " + ex.getErrorCode());
		}
		finally 
		{
			try 
			{
				if (result != null) {
					result.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			}
			catch (SQLException e) 
			{
				System.out.println("Message: " + e.getMessage());
				System.out.println("SQLState: " + e.getSQLState());
				System.out.println("ErrorCode: " + e.getErrorCode());
			}
		}
		
		return res;
	}

	@Override
	public List<Libro> selectLibrosDisponibles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Libro> selectLibrosPrestados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDispobible(int id_libro, String valor) {
		
		String sql = "UPDATE Libro SET disponible ='"+valor+"' WHERE id_libro ="+id_libro+";";
		
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try 
		{
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			
		}
		catch(SQLException ex)
		{
			System.out.println("Message: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("ErrorCode: " + ex.getErrorCode());
		}
		finally 
		{
			try 
			{
				if (result != null) {
					result.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			}
			catch (SQLException e) 
			{
				System.out.println("Message: " + e.getMessage());
				System.out.println("SQLState: " + e.getSQLState());
				System.out.println("ErrorCode: " + e.getErrorCode());
			}
		}
		
	}

}
