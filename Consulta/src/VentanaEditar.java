import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaEditar extends JFrame {

	private JPanel contentPane; 
	private JPanel contentPane_1;
	public JTable tablaRespuestas;
	private DefaultTableModel model;
	private Datos datos;
	private Persona usuario;
	private JTextField txtId;

	public VentanaEditar(Datos datos, Persona usuario) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
			
		scrollPane.setViewportView(tablaRespuestas);
		
		txtId = new JTextField();
		txtId.setBounds(258, 297, 37, 20);
		contentPane_1.add(txtId);
		txtId.setColumns(10);
		
		JLabel editar = new JLabel("Ingrese ID de respuesta a editar:");
		editar.setBounds(10, 300, 238, 14);
		contentPane_1.add(editar);
		
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String id = txtId.getText();
				VentanaEditarRespuesta ventana1 = new VentanaEditarRespuesta(datos, usuario, id);
				ventana1.setVisible(true);
				dispose();
			}
		});
		
		botonAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonAceptar.setBounds(538, 296, 89, 23);
		contentPane_1.add(botonAceptar);
	}
	
	public void llenarTabla() {	
		for (int i  = 0; i < usuario.getsizeMap(usuario) ; i++) {
			Object[] fila = new Object[3];
			fila = datos.listarRespuestas(fila, usuario.getId(), i);
			if (null != fila) model.addRow(fila);
		}
	} 
}
