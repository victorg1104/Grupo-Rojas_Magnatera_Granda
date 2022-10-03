import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class VentanaEliminar extends JFrame {

	private JPanel contentPane; 
	private JPanel contentPane_1;
	public JTable tablaRespuestas;
	private DefaultTableModel model;
	private Datos datos;
	private Persona usuario;
	private JTextField txtId;

	public VentanaEliminar(Datos datos, Persona usuario) {
	
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
	txtId.setBounds(214, 297, 37, 20);
	contentPane_1.add(txtId);
	txtId.setColumns(10);
			
	JLabel editar = new JLabel("Ingrese ID de respuesta a eliminar:");
	editar.setBounds(10, 300, 238, 14);
	contentPane_1.add(editar);
			
	JButton botonAceptar = new JButton("Aceptar");
	botonAceptar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			
			String id = txtId.getText();
			final VentanaUsuarioRegistrado ventanaRegistrado;
			String idRes = usuario.getIdRespuesta(id);
			boolean flag;
			if(idRes != null) {
				flag = datos.eliminarRespuesta(id, String.valueOf(usuario.getId()), usuario, idRes);
			}else flag = true;
			
			if(!flag)JOptionPane.showMessageDialog(null, "Respuesta eliminada con éxito.");
			
			else JOptionPane.showMessageDialog(null,"Error al eliminar la respuesta, ID incorrecto.");
			
			ventanaRegistrado = new VentanaUsuarioRegistrado(datos, usuario);
			ventanaRegistrado.setVisible(true);
			dispose();
		}
	});	
	botonAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
	botonAceptar.setBounds(538, 296, 89, 23);
	contentPane_1.add(botonAceptar);
}
				
	public void llenarTabla(){
		HashMap<Integer, Respuesta> auxmap = usuario.getMap();
        Set<Integer> keySet = auxmap.keySet();
        ArrayList<Integer> listOfKeys  = new ArrayList<Integer>(keySet);
        
		for (int idRes : listOfKeys){
			Object[] fila = new Object[3];
			fila = datos.listarRespuestas(fila, usuario.getId(), idRes);
			if (null != fila) model.addRow(fila);
		}
	} 
}
