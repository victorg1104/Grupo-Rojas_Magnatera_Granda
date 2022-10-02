import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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

public class VentanaTusRespuestas extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane_1;
	public JTable tablaRespuestas;
	private DefaultTableModel model;
	private Datos datos;
	private Persona usuario;
	
	public VentanaTusRespuestas(Datos datos, Persona usuario) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.datos = datos;
		this.usuario = usuario;
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 377);
		contentPane_1 = new JPanel();
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane_1);
		contentPane_1.setLayout(null);
			
		JLabel txtVentana = new JLabel("Tus Respuestas");
		txtVentana.setHorizontalAlignment(SwingConstants.CENTER);
		txtVentana.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtVentana.setBounds(245, 11, 158, 21);
		contentPane_1.add(txtVentana);
			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 617, 233);
		contentPane_1.add(scrollPane);
			
		tablaRespuestas = new JTable();
			
		model = new DefaultTableModel();
		tablaRespuestas.setModel(model);
			
		TableColumnModel columnModel = tablaRespuestas.getColumnModel();
			
		model.addColumn("ID");
		model.addColumn("Consulta");
		model.addColumn("Respuesta");
			
		llenarTabla();
			
		columnModel.getColumn(0).setPreferredWidth(20);
		columnModel.getColumn(1).setPreferredWidth(250);
		columnModel.getColumn(2).setPreferredWidth(347);
		
		if (model.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Usted no ha respondido ninguna consulta");
			final VentanaUsuarioRegistrado ventanaUsuarioReg = new VentanaUsuarioRegistrado(datos, usuario);
			ventanaUsuarioReg.setVisible(true);
			dispose();
		}
			
		scrollPane.setViewportView(tablaRespuestas);
			
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
		contentPane_1.add(botonSalir);
		
		JLabel txtPregunta = new JLabel("¿Desea realizar alguna acción con sus respuestas?");
		txtPregunta.setBounds(20, 287, 329, 14);
		contentPane_1.add(txtPregunta);
		
		JButton botonEditar = new JButton("Editar Respuesta");
		botonEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaEditar ventanaEdit = new VentanaEditar(datos, usuario);
				ventanaEdit.setVisible(true);
				dispose();
			}
		});
		
		botonEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonEditar.setBounds(10, 306, 154, 23);
		contentPane_1.add(botonEditar);
		
		JButton botonEliminar = new JButton("Eliminar Respuesta");
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaEliminar ventanaElim = new VentanaEliminar(datos, usuario);
				ventanaElim.setVisible(true);
				dispose();
			}
		});
		botonEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonEliminar.setBounds(174, 306, 158, 23);
		contentPane_1.add(botonEliminar);
				
	}
	
	public void llenarTabla() {	
		for (int i  = 0; i < usuario.getsizeMap(usuario) ; i++) {
			Object[] fila = new Object[3];
			fila = datos.listarRespuestas(fila, usuario.getId(), i);
			if (null != fila) model.addRow(fila);
		}
	}
}


