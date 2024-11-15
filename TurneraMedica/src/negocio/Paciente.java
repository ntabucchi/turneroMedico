package negocio;

public class Paciente extends Usuario{
	private int idPaciente;
	private String direccion;
	private String celular;	
	
	public Paciente(String nombre, String apellido, String documento, int idPaciente, String direccion, String celular) {
		super(nombre, apellido, documento);
		this.idPaciente = idPaciente;
		this.direccion = direccion;
		this.celular = celular;
	}
	
	public Paciente(String nombre, String apellido, String documento, String direccion, String celular) {
		super(nombre, apellido, documento);
		this.direccion = direccion;
		this.celular = celular;
	}
	
	public Paciente(String nombre, String apellido, String documento) {
		super(nombre, apellido, documento);
	}
	
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}	
}
