package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
        
        JComboBox<Integer> comboBoxDia = new JComboBox<>(dias());
        //JComboBox comboBoxDia = new JComboBox();
        pnlFecha.add(new JLabel("Día:"));
        pnlFecha.add(comboBoxDia);
        
        JComboBox<String> comboBoxMes = new JComboBox<>(meses());
        //JComboBox comboBoxMes = new JComboBox();
        pnlFecha.add(new JLabel("Mes:"));
        pnlFecha.add(comboBoxMes);
        
        JComboBox<Integer> comboBoxAnio = new JComboBox<>(anios());
        //JComboBox comboBoxAnio = new JComboBox();
        pnlFecha.add(new JLabel("Año:"));
        pnlFecha.add(comboBoxAnio);
        panel.add(pnlFecha);
        
        //Lista Fecha hasta
        JPanel pnlFechaHasta = new JPanel();
        pnlFechaHasta.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 1));
        
        JComboBox<Integer> comboBoxDiaHasta = new JComboBox<>(dias());
        //JComboBox comboBoxDia = new JComboBox();
        pnlFechaHasta.add(new JLabel("Día:"));
        pnlFechaHasta.add(comboBoxDiaHasta);
        
        JComboBox<String> comboBoxMesHasta = new JComboBox<>(meses());
        //JComboBox comboBoxMes = new JComboBox();
        pnlFechaHasta.add(new JLabel("Mes:"));
        pnlFechaHasta.add(comboBoxMesHasta);
        
        JComboBox<Integer> comboBoxAnioHasta = new JComboBox<>(anios());
        //JComboBox comboBoxAnio = new JComboBox();
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

	public Integer[] dias() {
		Integer[] dias = new Integer[31];
        for (int i = 0; i < 31; i++) {
            dias[i] = i + 1;
        }
        return dias;
	}
	
	public String[] meses() {
		String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		return meses;
	}
	
	public String obtenerMes(String _mes) {
		String mes = null;
		
		if(_mes.equals("Enero")) { mes = "1";}
		if(_mes.equals("Febrero")) { mes = "2";}
		if(_mes.equals("Marzo")) { mes = "3";}
		if(_mes.equals("Abril")) { mes = "4";}
		if(_mes.equals("Mayo")) { mes = "5";}
		if(_mes.equals("Junio")) { mes = "6";}
		if(_mes.equals("Julio")) { mes = "7";}
		if(_mes.equals("Agosto")) { mes = "8";}
		if(_mes.equals("Septiembre")) { mes = "9";}
		if(_mes.equals("Octubre")) { mes = "10";}
		if(_mes.equals("Noviembre")) { mes = "11";}
		if(_mes.equals("Diciembre")) { mes = "12";}

		return mes;
	}
	
	public Integer[] anios() {
		Integer[] anios = new Integer[101];
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = 0; i < 101; i++) {
			anios[i] = currentYear - 50 + i; // Años desde 50 años atrás hasta 50 años adelante
		}
		return anios;
	}
}
