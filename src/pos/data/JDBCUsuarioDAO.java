package pos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pos.domain.Usuario;
import pos.domain.UsuarioImpl;
import pos.utils.ConnectionManager;

public class JDBCUsuarioDAO implements IUsuarioDAO {
	
	private Connection conn;
	
	public JDBCUsuarioDAO()
	{
		conn = ConnectionManager.getInstance().checkOut();
	}
	
	@Override
	public List<Usuario> selectAllUsuarios() {
		String sql = "SELECT * FROM Usuario;";
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<Usuario> res = new LinkedList<Usuario>();
		
		try 
		{
			stmt = conn.prepareStatement(sql);

			result = stmt.executeQuery();
			
			while(result.next())
			{
				Usuario u = new UsuarioImpl();
				u.SetUsuarioID(result.getInt("id_usuario"));
				u.SetNombreUsuario(result.getString("nombre"));
				u.SetApellidosUsuario(result.getString("apellidos"));
				u.SetDni(result.getString("dni"));
				res.add(u);
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
	public Usuario selectUsuarioPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario selectUsuarioPorDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> selectIDLibrosPrestados(int userid) {
		
		String sql = "SELECT * FROM Asociacion_Usuario_Libro WHERE id_usuario = "+userid+";";
		PreparedStatement stmt = null;
		ResultSet result = null;
		List<String> res = new LinkedList<String>();
		
		try 
		{
			stmt = conn.prepareStatement(sql);

			result = stmt.executeQuery();
			
			while(result.next())
			{
				
				int id = result.getInt("id_libro");
				res.add(String.valueOf(id));
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
	public void insertarLibrosPorUsuario(int l, int u) {

		String sql = "INSERT INTO Asociacion_Usuario_Libro (id_usuario, id_libro) VALUES ("+u+","+l+");";
		
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

	@Override
	public void eliminarLibrosPorUsuario(int userId) {
		
		String sql = "DELETE FROM Asociacion_Usuario_Libro WHERE id_usuario = "+userId+";";
		
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
