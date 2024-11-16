package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
	
	public int altaUsuario(String nombre, String apellido, String documento) {
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    int idUsuario = -1;

	    try {
	        String query = "INSERT INTO Usuarios(nombre, apellido, documento) VALUES (?, ?, ?); SELECT @@IDENTITY";
	        Connection con = DataSource.obtenerConexion();
	        stmt = con.prepareStatement(query);
	        stmt.setString(1, nombre);
	        stmt.setString(2, apellido);
	        stmt.setString(3, documento);

	        rs = stmt.executeQuery();

	        if (rs.next()) {
	            idUsuario = rs.getInt(1);
	        }
	    } catch (Exception e) {
	    	if (!e.getMessage().contains("UNIQUE KEY")) {
				e.printStackTrace();
            }
	    } finally {
	        DataSource.cerrarConexion(rs, stmt);
	    }

	    return idUsuario;
	}
	
	public boolean update(String nombre, String apellido, String documento, int idPaciente) {
	    PreparedStatement stmt = null;
	    boolean exito = false;

	    try {
	        String query = "UPDATE Usuarios set nombre=?, apellido=?, documento= ? where id= ?";
	        Connection con = DataSource.obtenerConexion();
	        stmt = con.prepareStatement(query);
	        stmt.setString(1, nombre);
	        stmt.setString(2, apellido);
	        stmt.setString(3, documento);
	        stmt.setInt(4, idPaciente);

	        int filasAfectadas = stmt.executeUpdate();
	        if (filasAfectadas > 0) {
	            exito = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        DataSource.cerrarConexion(null, stmt);
	    }

	    return exito;
	}
	
	public boolean eliminar(int id) {
	    PreparedStatement stmt = null;
	    boolean resultado = false;

	    try {
	        String query = "DELETE FROM Usuarios WHERE id = ?";
	        Connection con = DataSource.obtenerConexion();
	        stmt = con.prepareStatement(query);
	        stmt.setInt(1, id);

	        int filasAfectadas = stmt.executeUpdate();
	        if (filasAfectadas > 0) {
	            resultado = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        DataSource.cerrarConexion(null, stmt);
	    }

	    return resultado;
	}
}
