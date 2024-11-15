package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import negocio.Paciente;
import negocio.Turno;

public class TurnoDAO {
	
	public List<Turno> consultarTurno(int idMedico, String _fecha) {
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    List<Turno> turnos = new ArrayList<>();
	    try {
	    	String query = "SELECT u.Nombre, u.Apellido, u.Documento, t.Fecha, t.Hora, m.Id AS MedicoId " +
	                   "FROM Turnos t " +
	                   "JOIN Medicos m ON t.MedicoId = m.Id " +
	                   "JOIN Pacientes p ON t.PacienteId = p.Id " +
	                   "JOIN Usuarios u ON u.Id = p.UsuarioId " +
	                   "WHERE m.id = ? AND t.Fecha=?";
	        Connection con = DataSource.obtenerConexion();
	        stmt = con.prepareStatement(query);
	        stmt.setInt(1, idMedico);
	        stmt.setString(2, _fecha);
	        rs = stmt.executeQuery();
	        
	        while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String documento = rs.getString("Documento");
                String hora = rs.getString("Hora");
                Date fecha = rs.getDate("Fecha");
                
                Paciente paciente = new Paciente(nombre, apellido, documento);
                Turno turno = new Turno(fecha, hora, paciente);
                turnos.add(turno);
            }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        DataSource.cerrarConexion(rs, stmt);
	    }
	    return turnos;
	}
}
