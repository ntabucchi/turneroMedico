package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import persistencia.PacienteDAO;
import persistencia.UsuarioDAO;

public class VentanaBajaPaciente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBajaPaciente frame = new VentanaBajaPaciente();
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
	public VentanaBajaPaciente() {
		setTitle("Baja Paciente");
	    setSize(506, 200);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	    setLayout(new BorderLayout()); 
		
		JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));

		setContentPane(panel);
		
		JPanel pnlBuscar = new JPanel(new GridLayout(1, 2, 10, 10));
		JLabel lblNewLabel = new JLabel("N\u00FAmero de documento");
		pnlBuscar.add(lblNewLabel);
		
		JTextArea textAreaDocumento = new JTextArea();
		pnlBuscar.add(textAreaDocumento);
		panel.add(pnlBuscar);
		
		JPanel pnlBotones = new JPanel();
		JButton btnIngresar = new JButton("Eliminar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDAO usr_dao = new UsuarioDAO();
				PacienteDAO pac_dao = new PacienteDAO();
				Paciente paciente = pac_dao.obtener(textAreaDocumento.getText());
								
				boolean eliminar_paciente = pac_dao.eliminar(paciente);
				boolean eliminar_usuario = usr_dao.eliminar(paciente.getIdPaciente());
				
				if(eliminar_usuario == true && eliminar_paciente == true) {
					new VentanaNotificacion(paciente, "Se elimino el paciente:");
				}
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
