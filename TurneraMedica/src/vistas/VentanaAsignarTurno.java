package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.Turno;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAsignarTurno extends JFrame {

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
					VentanaAsignarTurno frame = new VentanaAsignarTurno();
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
	public VentanaAsignarTurno() {
		JFrame frame = new JFrame("Asignar turno");
		frame.setSize(506, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());
        
        JPanel panel = new JPanel(new GridLayout(5, 1, 15, 10)); 
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        //Fecha
        JPanel pnlFecha = new JPanel();
        pnlFecha.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 1));
        
        JComboBox<Integer> comboBoxDia = new JComboBox<>(Turno.dias());
        pnlFecha.add(new JLabel("Fecha:"));
        pnlFecha.add(comboBoxDia);
        
        JComboBox<String> comboBoxMes = new JComboBox<>(Turno.meses());
        pnlFecha.add(comboBoxMes);
        
        JComboBox<Integer> comboBoxAnio = new JComboBox<>(Turno.anios());
        pnlFecha.add(comboBoxAnio);
        panel.add(pnlFecha);
        
        //Hora
        JPanel pnlHora = new JPanel();
        pnlHora.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 1));
        
        JComboBox<String> comboBoxHora = new JComboBox<>(Turno.horas());
        pnlHora.add(new JLabel("Hora:"));
        pnlHora.add(comboBoxHora);
        
        JComboBox<String> comboBoxMinutos = new JComboBox<>(Turno.minutos());
        pnlHora.add(comboBoxMinutos);
        panel.add(pnlHora);
        
        //Lista Pacientes
        JPanel pnlPaciente = new JPanel();
        pnlPaciente.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 1));
        
        JLabel lblPacientes = new JLabel("Pacientes:");
        lblPacientes.setFont(new Font("Tahoma", Font.BOLD, 11));
        pnlPaciente.add(lblPacientes);

        String[] opcionesPacientes = {"Opción 1 (100)", "Opción 2 (101)", "Opción 3 (102)", "Opción 4 (103)"};
        JComboBox<String> comboBoxPacientes = new JComboBox<>(opcionesPacientes);
        //JComboBox comboBoxPacientes = new JComboBox<>();
        pnlPaciente.add(comboBoxPacientes);
        panel.add(pnlPaciente);
        
        //Lista Medicos
        JPanel pnlMedico = new JPanel();
        pnlMedico.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 1));
       
        JLabel lblMedicos = new JLabel("Médicos:");
        lblMedicos.setFont(new Font("Tahoma", Font.BOLD, 11));
        pnlMedico.add(lblMedicos);

        String[] opcionesMedicos = {"Opción 1 (200)", "Opción 2 (201)", "Opción 3 (202)", "Opción 4 (204)"};
        JComboBox<String> comboBoxMedicos = new JComboBox<>(opcionesMedicos);
        pnlMedico.add(comboBoxMedicos);
        panel.add(pnlMedico);
                
        JPanel pnlPie = new JPanel(new GridLayout(1, 2, 10, 10));
        panel.add(pnlPie);

        JButton btnAsignarTurno = new JButton("Asignar Turno");
        btnAsignarTurno.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String paciente = comboBoxPacientes.getSelectedItem().toString();
        		String medico = comboBoxMedicos.getSelectedItem().toString();
        		String fecha = comboBoxDia.getSelectedItem() + " de " + comboBoxMes.getSelectedItem() + " " + comboBoxAnio.getSelectedItem();
        		String hora = comboBoxHora.getSelectedItem() + ":" + comboBoxMinutos.getSelectedItem();
        		new VentanaDetalleTurno(paciente, medico, fecha, hora);
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
		
	public String obtenerDocumento(String texto) {
        String[] partes = texto.split("[()]+");
        
        return partes[1];        
	}	
}
