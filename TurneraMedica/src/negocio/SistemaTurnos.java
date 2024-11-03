package negocio;

import java.util.List;

public class SistemaTurnos {
	private List<Medico> medicos;
    private List<Paciente> pacientes;
    private List<Turno> turnos;
	
    public SistemaTurnos(List<Medico> medicos, List<Paciente> pacientes, List<Turno> turnos) {
		this.medicos = medicos;
		this.pacientes = pacientes;
		this.turnos = turnos;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}
}
