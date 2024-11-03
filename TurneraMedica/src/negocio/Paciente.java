package negocio;

public class Paciente extends Usuario{
	private int idPaciente;

	public Paciente(String nombre, String apellido, String documento, int idPaciente) {
		super(nombre, apellido, documento);
		this.idPaciente = idPaciente;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}	
}
