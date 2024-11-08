package vistas;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class VentanaMedicoTurnos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the frame.
	 */
	public VentanaMedicoTurnos(Object[][] data, String fecha) {
	        String[] columnNames = {"Paciente", "Fecha", "Hora"};
	        
	        DefaultTableModel model = new DefaultTableModel(data, columnNames);
	        JTable table = new JTable(model);
	        
	        JFrame frame = new JFrame("Turnos");
	        frame.setSize(506, 300);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        setLayout(new BorderLayout()); 
	        
	        JPanel panel = new JPanel(new GridBagLayout());
	        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	        GridBagConstraints gbc = new GridBagConstraints();
	        
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.weightx = 1.0;
	        gbc.weighty = 0.1;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        
	        JLabel lblFecha = new JLabel("Fecha: " + fecha);
	        lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
	        panel.add(lblFecha, gbc);
	        
	        gbc.gridx = 0;
	        gbc.gridy = 1;
	        gbc.weighty = 1;
	        gbc.fill = GridBagConstraints.BOTH;
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setPreferredSize(new Dimension(400, 200));
	        panel.add(scrollPane, gbc);
	        
	        gbc.gridx = 0;
	        gbc.gridy = 2;
	        gbc.weighty = 0.1;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        
	        JButton btnVolver = new JButton("Volver");
	        btnVolver.setPreferredSize(new Dimension(10, 50));
	        btnVolver.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                frame.dispose();
	            }
	        });
	        panel.add(btnVolver, gbc);
	        
	        frame.getContentPane().add(panel, BorderLayout.CENTER);
	        frame.setVisible(true);      
	}
}
