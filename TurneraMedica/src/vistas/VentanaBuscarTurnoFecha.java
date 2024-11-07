package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;

import negocio.Medico;
import negocio.Turno;
import persistencia.SistemaTurnosDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class VentanaBuscarTurnoFecha extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public VentanaBuscarTurnoFecha(Medico m) {
		JFrame frame = new JFrame("Buscar Pacientes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 100);
        JPanel panel = new JPanel(new GridLayout(2, 2));
        
        JLabel lblNewLabel = new JLabel("Fecha (yyyy-mm-yy)");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblNewLabel);
        JButton btnBuscar = new JButton("Buscar");
        JTextArea textArea = new JTextArea();
        panel.add(textArea);
        panel.add(btnBuscar);
        
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		buscar(m, textArea.getText());
        	}
        });
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        	}
        });
        panel.add(btnVolver);
        
        frame.getContentPane().add(panel);
        frame.setVisible(true);
	}

	public void buscar(Medico m, String fecha) {
		if(m != null) {
			SistemaTurnosDAO lstTurnos = new SistemaTurnosDAO();
			List<Turno> turnos = lstTurnos.consultarTurno(m.getIdMedico(), fecha);
			Object[][] data = new Object[turnos.size()][];		
		
			for (int i = 0; i < turnos.size(); i++) {
				Turno turno = turnos.get(i);
		    
				data[i] = new Object[] {
		    		turno.getPaciente().getNombre() + " " + turno.getPaciente().getApellido(), 
		    		turno.getFecha(),
		    		turno.getHora()
				};
			}					
		
			new VentanaMedicoTurnos(data);				
		}
	}
}
