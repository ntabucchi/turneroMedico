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

public class VentanaAltaPaciente extends JFrame {

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
					VentanaAltaPaciente frame = new VentanaAltaPaciente();
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
	public VentanaAltaPaciente() {
		setTitle("Alta Paciente");
	    setSize(506, 320);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	    setLayout(new BorderLayout()); 
		
		JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));

		setContentPane(panel);
				
		JPanel pnlNombre = new JPanel(new GridLayout(1, 2, 10, 10));
		JLabel lblNombre = new JLabel("Nombre");
		pnlNombre.add(lblNombre);
		
		JTextArea textAreaNombre = new JTextArea();
		pnlNombre.add(textAreaNombre);
		panel.add(pnlNombre);
		
		JPanel pnlApellido = new JPanel(new GridLayout(1, 2, 10, 10));
		JLabel lblApellido = new JLabel("Apellido");
		pnlApellido.add(lblApellido);
		
		JTextArea textAreaApellido = new JTextArea();
		pnlApellido.add(textAreaApellido);
		panel.add(pnlApellido);
				
		JPanel pnlDocumento = new JPanel(new GridLayout(1, 2, 10, 10));
		JLabel lblDocumento = new JLabel("N\u00FAmero de documento");
		pnlDocumento.add(lblDocumento);
		
		JTextArea textAreaDocumento = new JTextArea();
		pnlDocumento.add(textAreaDocumento);
		panel.add(pnlDocumento);
		
		JPanel pnlDireccion = new JPanel(new GridLayout(1, 2, 10, 10));
		JLabel lblDireccion = new JLabel("Dirección");
		pnlDireccion.add(lblDireccion);
		
		JTextArea textAreaDireccion = new JTextArea();
		pnlDireccion.add(textAreaDireccion);
		panel.add(pnlDireccion);
				
		JPanel pnlCelular = new JPanel(new GridLayout(1, 2, 10, 10));
		JLabel lblCelular = new JLabel("Celular");
		pnlCelular.add(lblCelular);
		
		JTextArea textAreaCelular = new JTextArea();
		pnlCelular.add(textAreaCelular);
		panel.add(pnlCelular);
		
		JPanel pnlBotones = new JPanel();
		JButton btnIngresar = new JButton("Alta");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDAO usr_dao = new UsuarioDAO();
				int idPaciente = usr_dao.altaUsuario(textAreaNombre.getText(), textAreaApellido.getText(), textAreaDocumento.getText());
				
				PacienteDAO pac_dao = new PacienteDAO();
				int nuevo_paciente = pac_dao.altaPaciente(textAreaDireccion.getText(), textAreaCelular.getText(), idPaciente);
								
				if(nuevo_paciente != -1) {
					Paciente p = new Paciente(textAreaNombre.getText(), textAreaApellido.getText(), textAreaDocumento.getText(), idPaciente, textAreaDireccion.getText(), textAreaCelular.getText());
					new  VentanaNotificacion(p, "Se dio de alta al paciente:") ;
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
