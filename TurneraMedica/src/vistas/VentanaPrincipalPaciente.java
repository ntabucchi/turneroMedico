package vistas;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excepciones.RegistroNoExistenteException;
import negocio.Paciente;
import persistencia.PacienteDAO;

public class VentanaPrincipalPaciente extends JFrame {

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
					VentanaPrincipalPaciente frame = new VentanaPrincipalPaciente();
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
	public VentanaPrincipalPaciente() {
		setTitle("Ventana Principal Paciente");
	    setSize(506, 150);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JPanel panel = new JPanel(new GridLayout(1, 4, 10, 10));
	    panel.setBorder(new EmptyBorder(20, 20, 20, 20));

	    JButton btnAlta = new JButton("Alta");
	    btnAlta.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new VentanaAltaPaciente();
	    	}
	    });
	    panel.add(btnAlta);
	    JButton btnBaja = new JButton("Baja");
	    btnBaja.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new VentanaBajaPaciente();
	    	}
	    });
	    panel.add(btnBaja);	    
	    JButton btnModificar = new JButton("Modificar");
	    btnModificar.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new VentanaModificarPaciente();	
	    	}
	    });
	    panel.add(btnModificar);
	    JButton btnPacientes = new JButton("Pacientes");
	    btnPacientes.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
	    			PacienteDAO pac_dao = new PacienteDAO();
		    		List<Paciente> pacientes = pac_dao.listarPacientes();
		    		Object[][] data = new Object[pacientes.size()][];
		    		
		    		if (pacientes.size() == 0) {
						throw new RegistroNoExistenteException("No existen pacientes");
					}	    		
		    		
		    		for (int i = 0; i < pacientes.size(); i++) {
		    			Paciente p = pacientes.get(i);
				    
						data[i] = new Object[] {
				    		p.getNombre() + " " + p.getApellido(), 
				    		p.getDocumento(),
				    		p.getDireccion(),
				    		p.getCelular()
						};
					}	
		    		
		    		new VentanaPacientes(data);	    			
	    		}catch (RegistroNoExistenteException ex) {
			        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			    } catch (Exception ex) {
			        JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado.", "Error", JOptionPane.ERROR_MESSAGE);
			    }	    		
	    	}
	    });
	    panel.add(btnPacientes);

	    getContentPane().add(panel);
        setVisible(true);
	}

}
