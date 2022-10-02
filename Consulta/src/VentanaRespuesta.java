import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRespuesta extends JFrame {

	private JPanel contentPane;
	public static JTextField campoRespuesta;

	public VentanaRespuesta(Datos datos, Persona usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese su respuesta");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(135, 11, 171, 20);
		contentPane.add(lblNewLabel);
		
		campoRespuesta = new JTextField();
		campoRespuesta.setBounds(92, 61, 244, 20);
		contentPane.add(campoRespuesta);
		campoRespuesta.setColumns(10);
		
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datos.newRespuesta(usuario.getId());
				
				JOptionPane.showMessageDialog(null, "Respuesta agregada exitosamente");
				
				VentanaUsuarioRegistrado ventana = new VentanaUsuarioRegistrado(datos, usuario);
				
				ventana.setVisible(true);
				dispose();
			}
		});
		botonAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonAceptar.setBounds(176, 115, 85, 21);
		contentPane.add(botonAceptar);
	}

}
