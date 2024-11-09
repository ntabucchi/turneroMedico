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

public class VentanaDetalleTurno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public VentanaDetalleTurno(String paciente, String medico, String fecha) {
		JFrame frame = new JFrame("Detalle turno");
		frame.setSize(506, 230);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridLayout(4, 1, 15, 10)); 
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel pnlDetallePaciente = new JPanel();
        pnlDetallePaciente.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 1));
        JLabel lblPaciente = new JLabel("Paciente:");
        lblPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
        pnlDetallePaciente.add(lblPaciente);
        JLabel lblPacienteSeleccionado = new JLabel(paciente);
        lblPacienteSeleccionado.setFont(new Font("Tahoma", Font.PLAIN, 11));
        pnlDetallePaciente.add(lblPacienteSeleccionado);
        panel.add(pnlDetallePaciente);
        
        JPanel pnlDetalleMedico = new JPanel();
        pnlDetalleMedico.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 1));
        JLabel lblMedico = new JLabel("Médico:");
        lblMedico.setFont(new Font("Tahoma", Font.BOLD, 11));
        pnlDetalleMedico.add(lblMedico);
        JLabel lblMedicoSeleccionado = new JLabel(medico);
        lblMedicoSeleccionado.setFont(new Font("Tahoma", Font.PLAIN, 11));
        pnlDetalleMedico.add(lblMedicoSeleccionado);
        panel.add(pnlDetalleMedico);
        
        JPanel pnlDetalleFecha = new JPanel();
        pnlDetalleFecha.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 1));
        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
        pnlDetalleFecha.add(lblFecha);
        JLabel lblFechaSeleccionada = new JLabel(fecha);
        lblFechaSeleccionada.setFont(new Font("Tahoma", Font.PLAIN, 11));
        pnlDetalleFecha.add(lblFechaSeleccionada);
        panel.add(pnlDetalleFecha);
       
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
