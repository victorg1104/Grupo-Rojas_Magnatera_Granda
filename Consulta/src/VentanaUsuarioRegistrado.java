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
		
		JLabel mensajeBienvenida = new JLabel("Bienvenid@ " + usuario.getNombre());
		mensajeBienvenida.setHorizontalAlignment(SwingConstants.LEADING);
		mensajeBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mensajeBienvenida.setBounds(10, 10, 391, 37);
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
		botonCrearConsulta.setBounds(151, 80, 146, 23);
		contentPane.add(botonCrearConsulta);
		
		JLabel mensajeOpciones = new JLabel("Seleccione una opción");
		mensajeOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeOpciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mensajeOpciones.setBounds(125, 47, 196, 23);
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
		botonResponder.setBounds(151, 113, 146, 23);
		contentPane.add(botonResponder);
		
		JButton botonListarRespuestas = new JButton("Tus respuestas");
		botonListarRespuestas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaTusRespuestas ventanaTusRespuestas = new VentanaTusRespuestas(datos, usuario);
				ventanaTusRespuestas.setVisible(true);
				dispose();
			}
		});
		botonListarRespuestas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonListarRespuestas.setBounds(151, 146, 146, 23);
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
		botonListarConsultas.setBounds(151, 179, 146, 23);
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
		JButton botonBuscarConsulta = new JButton("Buscar consultas");
        botonBuscarConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaBuscarConsulta ventana = new VentanaBuscarConsulta(datos, usuario);
                ventana.setVisible(true);

                dispose();
            }
        });
        botonBuscarConsulta.setFont(new Font("Tahoma", Font.PLAIN, 12));
        botonBuscarConsulta.setBounds(151, 212, 146, 23);
        contentPane.add(botonBuscarConsulta);
	}
}
