package negocio;

import java.util.Date;

public class Turno {
	private Date fecha;
	private String hora;
	private Medico medico;
	private Paciente paciente;
		
	public Turno(Date fecha, String hora, Medico medico, Paciente paciente) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.medico = medico;
		this.paciente = paciente;
	}
	
	public Turno(Date fecha, String hora, Paciente paciente) {
		this.fecha = fecha;
		this.hora = hora;
		this.paciente = paciente;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
