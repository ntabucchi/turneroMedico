package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import negocio.Medico;

public class MedicoDAO {

	public Medico obtener(int id) {
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    Medico medico = null;
	    try {
	        String query = "SELECT u.Nombre, u.Apellido, u.Documento, m.MontoConsulta " +
	                       "FROM Usuarios u " +
	                       "JOIN Medicos m ON u.Id = m.UsuarioId " +
	                       "WHERE m.Id = ?";
	        Connection con = DataSource.obtenerConexion();
	        stmt = con.prepareStatement(query);
	        stmt.setInt(1, id);
	        rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            String nombre = rs.getString("Nombre");
	            String apellido = rs.getString("Apellido");
	            String documento = rs.getString("Documento");
	            double montoConsulta = rs.getDouble("MontoConsulta");
	            
	            medico = new Medico(nombre, apellido, documento, id, montoConsulta);
	            medico.setIdMedico(id);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        DataSource.cerrarConexion(rs, stmt);
	    }
	    return medico;
	}
	
	public Medico obtenerByDocumento(String documento) {
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    Medico medico = null;
	    try {
	        String query = "SELECT m.Id, u.Nombre, u.Apellido, u.Documento, m.MontoConsulta " +
	                       "FROM Usuarios u " +
	                       "JOIN Medicos m ON u.Id = m.UsuarioId " +
	                       "WHERE u.Documento = ?";
	        Connection con = DataSource.obtenerConexion();
	        stmt = con.prepareStatement(query);
	        stmt.setString(1, documento);
	        rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            String nombre = rs.getString("Nombre");
	            String apellido = rs.getString("Apellido");
	            int id = rs.getInt("Id");
	            double montoConsulta = rs.getDouble("MontoConsulta");
	            
	            medico = new Medico(nombre, apellido, documento, id, montoConsulta);
	            medico.setIdMedico(id);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        DataSource.cerrarConexion(rs, stmt);
	    }
	    return medico;
	}
}
