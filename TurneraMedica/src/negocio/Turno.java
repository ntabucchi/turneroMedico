package negocio;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
	private LocalDate fecha;
	private LocalTime hora;
	private Medico medico;
	private Paciente paciente;
	
	public Turno(LocalDate fecha, LocalTime hora, Medico medico, Paciente paciente) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.medico = medico;
		this.paciente = paciente;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
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
