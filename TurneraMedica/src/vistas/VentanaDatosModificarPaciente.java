package vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import negocio.Paciente;

public class VentanaDatosModificarPaciente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public VentanaDatosModificarPaciente(Paciente paciente) {
		setTitle("Modificar Paciente");
	    setSize(506, 200);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	    setLayout(new BorderLayout()); 
		
		JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));

		setContentPane(panel);
		
		JPanel pnlDireccion = new JPanel(new GridLayout(1, 2, 10, 10));
		JLabel lblDireccion = new JLabel("Dirección");
		pnlDireccion.add(lblDireccion);
		
		JTextArea textAreaDireccion = new JTextArea(paciente.getDireccion());
		pnlDireccion.add(textAreaDireccion);
		panel.add(pnlDireccion);
		
		JPanel pnlCelular = new JPanel(new GridLayout(1, 2, 10, 10));
		JLabel lblCelular = new JLabel("Celular");
		pnlCelular.add(lblCelular);
		
		JTextArea textAreaCelular = new JTextArea(paciente.getCelular());
		pnlCelular.add(textAreaCelular);
		panel.add(pnlCelular);
		
		JPanel pnlBotones = new JPanel();
		JButton btnIngresar = new JButton("Actualizar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VentanaNotificacion(paciente, "Se actualizó el paciente:");
			}
		});
		pnlBotones.add(btnIngresar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		pnlBotones.add(btnVolver);
		panel.add(pnlBotones);
		setVisible(true);
	}

}
