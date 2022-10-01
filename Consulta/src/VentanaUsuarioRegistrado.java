import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaUsuarioRegistrado extends JFrame {

	private JPanel contentPane;

	public VentanaUsuarioRegistrado(Datos datos, Persona usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel mensajeBienvenida = new JLabel("Bienvenido " + usuario.getNombre());
		mensajeBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mensajeBienvenida.setBounds(21, 11, 391, 37);
		contentPane.add(mensajeBienvenida);
		
		JButton botonCrearConsulta = new JButton("Crear consulta");
		botonCrearConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCrearConsulta ventanaConsulta = new VentanaCrearConsulta(datos, usuario);
				ventanaConsulta.setVisible(true);
				dispose();
			}
		});
		botonCrearConsulta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonCrearConsulta.setBounds(151, 97, 125, 23);
		contentPane.add(botonCrearConsulta);
		
		JLabel mensajeOpciones = new JLabel("Seleccione una opción");
		mensajeOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeOpciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mensajeOpciones.setBounds(112, 59, 196, 23);
		contentPane.add(mensajeOpciones);
		
		JButton botonResponder = new JButton("Responder consulta");
		botonResponder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaResponderConsulta ventanaResponder = new VentanaResponderConsulta(datos, usuario);		
				ventanaResponder.setVisible(true);
				dispose();
			}
		});
		botonResponder.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonResponder.setBounds(141, 134, 146, 23);
		contentPane.add(botonResponder);
		
		JButton botonListarRespuestas = new JButton("Tus respuestas");
		botonListarRespuestas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		botonListarRespuestas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonListarRespuestas.setBounds(151, 168, 125, 23);
		contentPane.add(botonListarRespuestas);
		
		JButton botonListarConsultas = new JButton("Tus consultas");
		botonListarConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMostrarConsultas ventanaTusConsultas = new VentanaMostrarConsultas(datos, usuario);
				ventanaTusConsultas.setVisible(true);
				dispose();
			}
		});
		botonListarConsultas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonListarConsultas.setBounds(151, 203, 125, 23);
		contentPane.add(botonListarConsultas);
		
		JButton botonSalirMenu = new JButton("Salir");
		botonSalirMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		botonSalirMenu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonSalirMenu.setBounds(339, 229, 85, 21);
		contentPane.add(botonSalirMenu);
	}
}
