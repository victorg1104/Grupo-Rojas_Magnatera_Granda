import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JTextField;

public class VentanaResultados extends JFrame {

	private JPanel contentPane;
	public JTable tablaConsultas;
	private DefaultTableModel model;
	private Datos datos;
	private Persona usuario;
	private static JTextField textField;

	public VentanaResultados(Datos datos, Persona usuario) {	
		this.datos = datos;
		this.usuario = usuario;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtVentana = new JLabel("Resultados");
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
		
		JLabel lblIngreseIdDe = new JLabel("Ingrese ID de consulta a responder:");
		lblIngreseIdDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseIdDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIngreseIdDe.setBounds(10, 306, 236, 21);
		contentPane.add(lblIngreseIdDe);
		
		textField = new JTextField();
		textField.setBounds(266, 308, 38, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = false;
				boolean flag1 = false;
				
                try {
                    flag1 = datos.validarConsulta();
                }
                catch(ConsultaInvalidaException c) {
                    JOptionPane.showMessageDialog(null, c.mostrarMensajeError());
                }
                catch(NumberFormatException ee) {
                    JOptionPane.showMessageDialog(null, "El id de consulta ingresado no es válido, intente nuevamente");
                }

				try {
	                     flag = datos.validarConsultaRepetida(usuario, textField.getText());
	                }
	                catch(ConsultaInvalidaException c) {
	                    JOptionPane.showMessageDialog(null, c.mostrarMensajeRepetido());
	                }
	                catch(NumberFormatException ee) {
	                    JOptionPane.showMessageDialog(null, "El id de consulta ingresado no es válido, intente nuevamente");
	                }
				if (flag && flag1) {
					VentanaRespuesta ventanaRes = new VentanaRespuesta(datos, usuario, textField.getText());
	                ventanaRes.setVisible(true);
					dispose();
				}
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAceptar.setBounds(318, 307, 85, 21);
		contentPane.add(btnAceptar);
		
		if (model.getRowCount() == 0)JOptionPane.showMessageDialog(null, "No se han encontrado consultas para la palabra ingresada");
	}
	
	public void llenarTabla() {	
		for (int i  = 0; i < datos.PlibreConsulta; i++) {
			Object[] fila = new Object[2];
			fila = datos.buscarConsultas(fila, usuario.getId(), i);
			if (null != fila) model.addRow(fila);
		}
	}
}
