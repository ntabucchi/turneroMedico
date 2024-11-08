package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("Ventana Principal");
	    setSize(506, 152);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JPanel panel = new JPanel(new GridLayout(1, 4, 10, 10));
	    panel.setBorder(new EmptyBorder(20, 20, 20, 20));

	    JButton btnMedico = new JButton("M\u00E9dicos");
	    btnMedico.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		VentanaMedico vm = new VentanaMedico();
				vm.setVisible(true);
	    	}
	    });
	    panel.add(btnMedico);
	    JButton btnPaciente = new JButton("Pacientes");
	    btnPaciente.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		VentanaPacientes vp = new VentanaPacientes();
	    	//	vp.setVisible(true);
	    	}
	    });
	    panel.add(btnPaciente);	    
	    JButton btnTurnos = new JButton("Turnos");
	    panel.add(btnTurnos);
	    JButton btnReportes = new JButton("Reportes");
	    panel.add(btnReportes);

	    getContentPane().add(panel);
        setVisible(true);
	}
}
