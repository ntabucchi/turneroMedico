package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import negocio.Medico;

public class MedicoDAO {

	public Medico obtenerByDocumento(String documento) {
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    Medico medico = null;
	    try {
	        String query = "SELECT u.Nombre, u.Apellido, u.Documento, m.idMedico, m.MontoConsulta " +
	                       "FROM Usuarios u " +
	                       "JOIN Medicos m ON u.id = m.idMedico " +
	                       "WHERE u.Documento = ?";
	        Connection con = DataSource.obtenerConexion();
	        stmt = con.prepareStatement(query);
	        stmt.setString(1, documento);
	        rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            String nombre = rs.getString("nombre");
	            String apellido = rs.getString("apellido");
	            int id = rs.getInt("idMedico");
	            double montoConsulta = rs.getDouble("montoConsulta");
	            
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
