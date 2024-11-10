package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.Turno;

public class VentanaReporteFechas extends JFrame {

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
					VentanaReporteFechas frame = new VentanaReporteFechas();
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
	public VentanaReporteFechas() {
		JFrame frame = new JFrame("Reportes");
		frame.setSize(506, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());
        
        JPanel panel = new JPanel(new GridLayout(4, 1, 15, 10)); 
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        //Fecha Desde
        JPanel pnlFecha = new JPanel();
        pnlFecha.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 1));
        
        JComboBox<Integer> comboBoxDia = new JComboBox<>(Turno.dias());
        pnlFecha.add(new JLabel("Día:"));
        pnlFecha.add(comboBoxDia);
        
        JComboBox<String> comboBoxMes = new JComboBox<>(Turno.meses());
        pnlFecha.add(new JLabel("Mes:"));
        pnlFecha.add(comboBoxMes);
        
        JComboBox<Integer> comboBoxAnio = new JComboBox<>(Turno.anios());
        pnlFecha.add(new JLabel("Año:"));
        pnlFecha.add(comboBoxAnio);
        panel.add(pnlFecha);
        
        //Lista Fecha hasta
        JPanel pnlFechaHasta = new JPanel();
        pnlFechaHasta.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 1));
        
        JComboBox<Integer> comboBoxDiaHasta = new JComboBox<>(Turno.dias());
        pnlFechaHasta.add(new JLabel("Día:"));
        pnlFechaHasta.add(comboBoxDiaHasta);
        
        JComboBox<String> comboBoxMesHasta = new JComboBox<>(Turno.meses());
        pnlFechaHasta.add(new JLabel("Mes:"));
        pnlFechaHasta.add(comboBoxMesHasta);
        
        JComboBox<Integer> comboBoxAnioHasta = new JComboBox<>(Turno.anios());
        pnlFechaHasta.add(new JLabel("Año:"));
        pnlFechaHasta.add(comboBoxAnioHasta);
        panel.add(pnlFechaHasta);
                
        JPanel pnlPie = new JPanel(new GridLayout(1, 2, 10, 10));
        panel.add(pnlPie);

        JButton btnAsignarTurno = new JButton("Buscar");
        btnAsignarTurno.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String fecha = comboBoxDia.getSelectedItem() + " de " + comboBoxMes.getSelectedItem() + " " + comboBoxAnio.getSelectedItem();
        		String fechaHasta = comboBoxDiaHasta.getSelectedItem() + " de " + comboBoxMesHasta.getSelectedItem() + " " + comboBoxAnioHasta.getSelectedItem();
        		new VentanaReporte();
        	}
        });
        pnlPie.add(btnAsignarTurno);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.dispose();
        	}
        });
        pnlPie.add(btnVolver);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true); 
	}
}
