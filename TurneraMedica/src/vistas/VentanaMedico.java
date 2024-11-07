package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import negocio.Medico;
import persistencia.MedicoDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;import java.awt.event.ActionEvent;

public class VentanaMedico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 110);
		contentPane = new JPanel(new GridLayout(2, 2));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero de documento");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setRows(10);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK));
		textArea.setLineWrap(true);
		textArea.setColumns(20);
		contentPane.add(textArea);
		
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
		contentPane.add(btnIngresar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnVolver);		
	}
}
