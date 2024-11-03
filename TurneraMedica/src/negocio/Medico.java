package negocio;

public class Medico extends Usuario {
	private int idMedico;
	private double montoConsulta;
	
	public Medico(String nombre, String apellido, String documento, int idMedico, double montoConsulta) {
		super(nombre, apellido, documento);
		this.idMedico = idMedico;
		this.montoConsulta = montoConsulta;
	}
	
	public int getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	public double getMontoConsulta() {
		return montoConsulta;
	}
	public void setMontoConsulta(double montoConsulta) {
		this.montoConsulta = montoConsulta;
	}	
}
