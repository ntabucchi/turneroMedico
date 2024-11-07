package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 71);
		getContentPane().setLayout(new GridLayout(1, 2));
		
		JButton btnMedico = new JButton("M\u00E9dico");
		btnMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMedico vm = new VentanaMedico();
				vm.setVisible(true);
			}
		});
		btnMedico.setBounds(125, 5, 89, 23);
		getContentPane().add(btnMedico);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		getContentPane().add(panel);
	}
}
