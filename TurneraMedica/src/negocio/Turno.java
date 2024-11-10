package negocio;

import java.util.Calendar;
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
	
	public static Integer[] dias() {
		Integer[] dias = new Integer[31];
        for (int i = 0; i < 31; i++) {
            dias[i] = i + 1;
        }
        return dias;
	}
	
	public static String[] meses() {
		String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		return meses;
	}
	
	public static String obtenerMes(String _mes) {
		String mes = null;
		
		if(_mes.equals("Enero")) { mes = "1";}
		if(_mes.equals("Febrero")) { mes = "2";}
		if(_mes.equals("Marzo")) { mes = "3";}
		if(_mes.equals("Abril")) { mes = "4";}
		if(_mes.equals("Mayo")) { mes = "5";}
		if(_mes.equals("Junio")) { mes = "6";}
		if(_mes.equals("Julio")) { mes = "7";}
		if(_mes.equals("Agosto")) { mes = "8";}
		if(_mes.equals("Septiembre")) { mes = "9";}
		if(_mes.equals("Octubre")) { mes = "10";}
		if(_mes.equals("Noviembre")) { mes = "11";}
		if(_mes.equals("Diciembre")) { mes = "12";}

		return mes;
	}
	
	public static Integer[] anios() {
		Integer[] anios = new Integer[101];
	    int currentYear = Calendar.getInstance().get(Calendar.YEAR);

	    for (int i = 0; i < 101; i++) {
	    	anios[i] = currentYear - i;
	    }
	    return anios;
	}
	
	public static String[] horas() {
		String[] horas = {"09", "10", "11", "12", "13", "14", 
                "15", "16", "17", "18", "19", "20"};
		return horas;
	}
	
	public static String[] minutos() {
		String[] minutos = {"00", "30"};
		return minutos;
	}
}
