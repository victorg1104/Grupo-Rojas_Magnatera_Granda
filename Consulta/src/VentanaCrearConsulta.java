import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCrearConsulta extends JFrame {

	public JPanel contentPane;
	public static JTextField campoConsulta;
	

	public VentanaCrearConsulta(Datos datos, Persona usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textoConsulta = new JLabel("Ingrese su consulta:");
		textoConsulta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textoConsulta.setBounds(10, 67, 178, 19);
		contentPane.add(textoConsulta);
		
		campoConsulta = new JTextField();
		campoConsulta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoConsulta.setBounds(185, 66, 239, 25);
		contentPane.add(campoConsulta);
		campoConsulta.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				datos.newConsulta(usuario.getId());
				JOptionPane.showMessageDialog(null, "Consulta creada exitosamente");
				
				campoConsulta.setText("");
				VentanaUsuarioRegistrado ventanaUsuarioReg = new VentanaUsuarioRegistrado(datos, usuario);
				ventanaUsuarioReg.setVisible(true);
				dispose();
			}
		});
		
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAceptar.setBounds(66, 158, 85, 21);
		contentPane.add(btnAceptar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaUsuarioRegistrado ventanaUsuarioReg = new VentanaUsuarioRegistrado(datos, usuario);
				ventanaUsuarioReg.setVisible(true);
				dispose();
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVolver.setBounds(273, 159, 85, 21);
		contentPane.add(btnVolver);
	}

}
