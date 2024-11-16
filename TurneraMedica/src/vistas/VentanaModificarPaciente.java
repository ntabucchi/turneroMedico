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
import excepciones.RegistroNoExistenteException;
import negocio.Paciente;
import persistencia.PacienteDAO;
import javax.swing.JTextField;

public class VentanaModificarPaciente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textAreaDocumento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaModificarPaciente frame = new VentanaModificarPaciente();
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
	public VentanaModificarPaciente() {
		setTitle("Modificar Paciente");
	    setSize(506, 152);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	    getContentPane().setLayout(new BorderLayout()); 
		
		JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));

		setContentPane(panel);
		
		JPanel pnlBuscar = new JPanel(new GridLayout(1, 2, 10, 10));
		JLabel lblNewLabel = new JLabel("N\u00FAmero de documento");
		pnlBuscar.add(lblNewLabel);
		panel.add(pnlBuscar);
		
		textAreaDocumento = new JTextField();
		pnlBuscar.add(textAreaDocumento);
		textAreaDocumento.setColumns(10);
		
		JPanel pnlBotones = new JPanel();
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PacienteDAO pac_dao = new PacienteDAO();
				
					String documento = textAreaDocumento.getText().trim();
					if (documento.isEmpty()) {
						throw new CampoRequeridoException("El campo Documento es obligatorio.");
					}
				
					Paciente paciente = pac_dao.obtener(textAreaDocumento.getText());
					if (paciente == null) {
						throw new RegistroNoExistenteException("El paciente no existe");
					}

					dispose();
					new VentanaDatosModificarPaciente(paciente);
					
				} catch (CampoRequeridoException ex) {
			        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			    } catch (RegistroNoExistenteException ex) {
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
