import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaMostrarConsultas extends JFrame {

	private JPanel contentPane;
	public JTable tablaConsultas;
	private DefaultTableModel model;
	private Datos datos;
	private Persona usuario;

	public VentanaMostrarConsultas(Datos datos, Persona usuario) {
		this.datos = datos;
		this.usuario = usuario;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtVentana = new JLabel("Consultas creadas");
		txtVentana.setHorizontalAlignment(SwingConstants.CENTER);
		txtVentana.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtVentana.setBounds(245, 11, 158, 21);
		contentPane.add(txtVentana);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 617, 233);
		contentPane.add(scrollPane);
		
		tablaConsultas = new JTable();
		
		model = new DefaultTableModel();
		tablaConsultas.setModel(model);
		
		TableColumnModel columnModel = tablaConsultas.getColumnModel();
		
		model.addColumn("ID");
		model.addColumn("Consulta");
		
		llenarTabla();
		
		columnModel.getColumn(0).setPreferredWidth(20);
		columnModel.getColumn(1).setPreferredWidth(597);
		
		scrollPane.setViewportView(tablaConsultas);
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaUsuarioRegistrado ventanaUsuarioReg = new VentanaUsuarioRegistrado(datos, usuario);
				ventanaUsuarioReg.setVisible(true);
				dispose();
			}
		});
		botonSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonSalir.setBounds(542, 306, 85, 21);
		contentPane.add(botonSalir);
		
		if (model.getRowCount() == 0)JOptionPane.showMessageDialog(null, "Usted no ha creado ninguna consulta");
	}
	
	public void llenarTabla() {	
		for (int i  = 0; i < datos.PlibreConsulta; i++) {
			Object[] fila = new Object[2];
			fila = datos.listarTusConsultas(fila, usuario.getId(), i);
			
			if (null != fila) model.addRow(fila);
		}
	}
}
