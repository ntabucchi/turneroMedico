package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.Medico;
import persistencia.MedicoDAO;

import javax.swing.JLabel;
import java.awt.GridLayout;

import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;import java.awt.event.ActionEvent;

public class VentanaMedico extends JFrame {

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
					VentanaMedico frame = new VentanaMedico();
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
	public VentanaMedico() {
		setTitle("Médico");
	    setSize(506, 152);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	    setLayout(new BorderLayout()); 
		
		JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));

		setContentPane(panel);
		
		JPanel pnlBuscar = new JPanel(new GridLayout(1, 2, 10, 10));
		JLabel lblNewLabel = new JLabel("N\u00FAmero de documento");
		pnlBuscar.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		pnlBuscar.add(textArea);
		panel.add(pnlBuscar);
		
		JPanel pnlBotones = new JPanel();
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicoDAO medico = new MedicoDAO();
				Medico m = medico.obtenerByDocumento(textArea.getText());
				
				if(m != null) {
					new VentanaBuscarTurnoFecha(m);
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
	}
}
