package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;

import negocio.Medico;
import negocio.Turno;
import persistencia.SistemaTurnosDAO;

import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

public class VentanaBuscarTurnoFecha extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public VentanaBuscarTurnoFecha(Medico m) {
		JFrame frame = new JFrame("Buscar por fecha");
		frame.setSize(506, 152);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
     
        JPanel pnlFecha = new JPanel();
        pnlFecha.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 1));
        
        JComboBox<Integer> comboBoxDia = new JComboBox<>(Turno.dias());
        pnlFecha.add(new JLabel("Día:"));
        pnlFecha.add(comboBoxDia);
        
        JComboBox<String> comboBoxMes = new JComboBox<>(Turno.meses());
        pnlFecha.add(new JLabel("Mes:"));
        pnlFecha.add(comboBoxMes);
        
        JComboBox<Integer> comboBoxAnio = new JComboBox<>(Turno.anios());
        pnlFecha.add(new JLabel("Año:"));
        pnlFecha.add(comboBoxAnio);
        panel.add(pnlFecha);
        
        JPanel pnlPie = new JPanel(new GridLayout(1, 2, 10, 10));
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String fecha = comboBoxAnio.getSelectedItem() + "-" + Turno.obtenerMes(comboBoxMes.getSelectedItem().toString()) + "-" + comboBoxDia.getSelectedItem();
        		buscar(m, fecha);
        	}
        });
        pnlPie.add(btnBuscar);
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        	}
        });
        pnlPie.add(btnVolver);
        panel.add(pnlPie);        
        
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
		
			new VentanaMedicoTurnos(data, fecha);				
		}
	}
}
