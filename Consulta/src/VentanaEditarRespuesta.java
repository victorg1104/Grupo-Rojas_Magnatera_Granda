import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VentanaEditarRespuesta extends JFrame {

	private JPanel contentPane;
	private JTextField txtRespuesta;
	private String idConsulta;
	private Persona usuario;
	private JLabel lblNewLabel;

	public VentanaEditarRespuesta(Datos datos, Persona usuario, String idConsulta) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.usuario = usuario;
		this.idConsulta = idConsulta;

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtRespuesta = new JTextField();
		txtRespuesta.setBounds(10, 62, 256, 20);
		contentPane.add(txtRespuesta);
		txtRespuesta.setColumns(10);
		
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				final VentanaUsuarioRegistrado ventanaRegistrado;
				
				datos.editarRespuesta(idConsulta, txtRespuesta.getText(), usuario);
				//
				JOptionPane.showMessageDialog(null, "Respuesta editada con éxito.");
				
				ventanaRegistrado = new VentanaUsuarioRegistrado(datos, usuario);
				ventanaRegistrado.setVisible(true);
				dispose();
			}
		});
		
		botonAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonAceptar.setBounds(305, 61, 89, 23);
		contentPane.add(botonAceptar);
		
		lblNewLabel = new JLabel("Ingrese su nueva respuesta:");
		lblNewLabel.setBounds(10, 37, 303, 14);
		contentPane.add(lblNewLabel);

	}
}
