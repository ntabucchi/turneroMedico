package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import negocio.Paciente;

public class PacienteDAO {

	public Paciente obtener(String documento) {
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    Paciente paciente = null;
	    try {
	        String query = "SELECT u.Nombre, u.Apellido, u.Documento, p.idPaciente, p.direccion, p.celular " +
	                       "FROM Usuarios u " +
	                       "JOIN Pacientes p ON u.Id = p.idPaciente " +
	                       "WHERE u.Documento = ?";
	        Connection con = DataSource.obtenerConexion();
	        stmt = con.prepareStatement(query);
	        stmt.setString(1, documento);
	        rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            String nombre = rs.getString("Nombre");
	            String apellido = rs.getString("Apellido");
	            int idPaciente = rs.getInt("idPaciente");
	            String direccion = rs.getString("direccion");
	            String celular = rs.getString("celular");
	            
	            System.out.println("idPaciente: " + idPaciente);
	            
	            paciente = new Paciente(nombre, apellido, documento, idPaciente, direccion, celular);
	            paciente.setIdPaciente(idPaciente);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        DataSource.cerrarConexion(rs, stmt);
	    }
	    return paciente;
	}
	
	public int altaPaciente(String direccion, String celular, int idPaciente) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int nuevo_paciente = -1;
		
		try {
			String query = "INSERT INTO Pacientes(idPaciente, direccion, celular) VALUES (?, ?, ?); SELECT @@IDENTITY";
			Connection con = DataSource.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, idPaciente);
			stmt.setString(2, direccion);
			stmt.setString(3, celular);

			rs = stmt.executeQuery();
			if (rs.next()) {
				nuevo_paciente = rs.getInt(1);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataSource.cerrarConexion(rs,stmt);
		}
		
		return nuevo_paciente;
	}
	
	public boolean eliminar(Paciente paciente) {
	    PreparedStatement stmt = null;
	    boolean exito = false;

	    try {
	        String query = "DELETE FROM Pacientes WHERE idPaciente = ?";
	        Connection con = DataSource.obtenerConexion();
	        stmt = con.prepareStatement(query);
	        stmt.setInt(1, paciente.getIdPaciente());

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
}
