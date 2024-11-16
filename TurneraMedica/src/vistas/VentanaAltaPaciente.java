package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excepciones.CampoRequeridoException;
import persistencia.PacienteDAO;
import persistencia.UsuarioDAO;
import javax.swing.JTextField;

public class VentanaAltaPaciente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textAreaNombre;
	private JTextField textAreaApellido;
	private JTextField textAreaDocumento;
	private JTextField textAreaDireccion;
	private JTextField textAreaCelular;

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
	        
	    getContentPane().setLayout(new BorderLayout()); 
		
		JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));

		setContentPane(panel);
				
		JPanel pnlNombre = new JPanel(new GridLayout(1, 2, 10, 10));
		JLabel lblNombre = new JLabel("Nombre");
		pnlNombre.add(lblNombre);
		panel.add(pnlNombre);
		
		textAreaNombre = new JTextField();
		pnlNombre.add(textAreaNombre);
		textAreaNombre.setColumns(10);
		
		JPanel pnlApellido = new JPanel(new GridLayout(1, 2, 10, 10));
		JLabel lblApellido = new JLabel("Apellido");
		pnlApellido.add(lblApellido);
		panel.add(pnlApellido);
		
		textAreaApellido = new JTextField();
		pnlApellido.add(textAreaApellido);
		textAreaApellido.setColumns(10);
				
		JPanel pnlDocumento = new JPanel(new GridLayout(1, 2, 10, 10));
		JLabel lblDocumento = new JLabel("N\u00FAmero de documento");
		pnlDocumento.add(lblDocumento);
		panel.add(pnlDocumento);
		
		textAreaDocumento = new JTextField();
		pnlDocumento.add(textAreaDocumento);
		textAreaDocumento.setColumns(10);
		
		JPanel pnlDireccion = new JPanel(new GridLayout(1, 2, 10, 10));
		JLabel lblDireccion = new JLabel("Dirección");
		pnlDireccion.add(lblDireccion);
		panel.add(pnlDireccion);
		
		textAreaDireccion = new JTextField();
		pnlDireccion.add(textAreaDireccion);
		textAreaDireccion.setColumns(10);
				
		JPanel pnlCelular = new JPanel(new GridLayout(1, 2, 10, 10));
		JLabel lblCelular = new JLabel("Celular");
		pnlCelular.add(lblCelular);
		panel.add(pnlCelular);
		
		textAreaCelular = new JTextField();
		pnlCelular.add(textAreaCelular);
		textAreaCelular.setColumns(10);
		
		JPanel pnlBotones = new JPanel();
		JButton btnIngresar = new JButton("Alta");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioDAO usr_dao = new UsuarioDAO();
				PacienteDAO pac_dao = new PacienteDAO();
				
				try {
					String documento = textAreaDocumento.getText().trim();
			        if (documento.isEmpty()) {
			            throw new CampoRequeridoException("El campo Documento es obligatorio.");
			        }
			        
					int idPaciente = usr_dao.altaUsuario(textAreaNombre.getText(), textAreaApellido.getText(), textAreaDocumento.getText());
					int nuevo_paciente = pac_dao.altaPaciente(textAreaDireccion.getText(), textAreaCelular.getText(), idPaciente);
									
					if(nuevo_paciente != -1) {
						dispose();
						JOptionPane.showMessageDialog(null, "Se dio de alta al paciente: " + textAreaNombre.getText() + " " + textAreaApellido.getText() , "", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "El paciente ya existe.", "Error", JOptionPane.WARNING_MESSAGE);
					}
			    } catch (CampoRequeridoException ex) {
			        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			    } catch (Exception ex) {
			        JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado.", "Error", JOptionPane.ERROR_MESSAGE);
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
