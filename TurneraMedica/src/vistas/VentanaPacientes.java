package vistas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class VentanaPacientes extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public VentanaPacientes(Object[][] data) {
	    String[] columnNames = {"Paciente", "Documento", "Dirección", "Celular"};
	    
	    DefaultTableModel model = new DefaultTableModel(data, columnNames);
	    JTable table = new JTable(model);
	    
	    setTitle("Pacientes");
	    setSize(600, 450);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    getContentPane().setLayout(new BorderLayout());

	    JPanel pnlTabla = new JPanel(new BorderLayout());
	    pnlTabla.setBorder(new EmptyBorder(20, 20, 0, 20));
	    JScrollPane scrollPanel = new JScrollPane(table);
	    pnlTabla.add(scrollPanel, BorderLayout.CENTER);
	    getContentPane().add(pnlTabla, BorderLayout.CENTER);
	    
	    JPanel pnlBotones = new JPanel();
	    pnlBotones.setBorder(new EmptyBorder(0, 20, 20, 20));
	    JButton btnVolver = new JButton("Volver");
	    btnVolver.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            dispose();
	        }
	    });
	    pnlBotones.add(btnVolver);
	    getContentPane().add(pnlBotones, BorderLayout.SOUTH);
	    
	    setVisible(true);
	}
}
