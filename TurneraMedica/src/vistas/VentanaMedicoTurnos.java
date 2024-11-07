package vistas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMedicoTurnos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the frame.
	 */
	public VentanaMedicoTurnos(Object[][] data) {
		String[] columnNames = {"Paciente", "Fecha", "Hora"};
       
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);

        JFrame frame = new JFrame("Turnos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        	}
        });
        frame.getContentPane().add(btnVolver, BorderLayout.SOUTH);

        frame.setSize(400, 300);
        frame.setVisible(true);
        
	}
}
