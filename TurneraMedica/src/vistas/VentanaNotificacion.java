package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.Paciente;

public class VentanaNotificacion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the frame.
	 */
	public VentanaNotificacion(Paciente paciente, String mensaje) {
		JFrame frame = new JFrame("Detalle");
		frame.setSize(506, 180);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridLayout(2, 1, 15, 10)); 
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel pnlDetallePaciente = new JPanel();
        pnlDetallePaciente.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 1));
        JLabel lblPaciente = new JLabel(mensaje);
        lblPaciente.setFont(new Font("Tahoma", Font.BOLD, 16));
        pnlDetallePaciente.add(lblPaciente);
        JLabel lblPacienteSeleccionado = new JLabel(paciente.getNombre() + " " + paciente.getApellido() + " - " + paciente.getDocumento());
        lblPacienteSeleccionado.setFont(new Font("Tahoma", Font.PLAIN, 16));
        pnlDetallePaciente.add(lblPacienteSeleccionado);
        panel.add(pnlDetallePaciente);
                
         JPanel pnlBoton = new JPanel();
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        	}
        });
        pnlBoton.add(btnVolver);
        panel.add(pnlBoton);
        
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true); 
	}

}
