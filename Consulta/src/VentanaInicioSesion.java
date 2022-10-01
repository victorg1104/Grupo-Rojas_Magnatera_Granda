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

public class VentanaInicioSesion extends JFrame {

	private JPanel contentPane;
	public Datos datos;
	public static JTextField campoRut;

	/**
	 * Create the frame.
	 */
	public VentanaInicioSesion(Datos datos) {
		setTitle("Planificador de consultas ciudadanas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel mensajeRut = new JLabel("Ingrese rut:");
		mensajeRut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mensajeRut.setBounds(21, 64, 111, 13);
		contentPane.add(mensajeRut);
		
		campoRut = new JTextField();
		campoRut.setBounds(128, 63, 148, 19);
		contentPane.add(campoRut);
		campoRut.setColumns(10);
		
		
		this.datos = datos;
		JButton btnNewButton = new JButton("Aceptar");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = false;
				final int usuario;
				
				try {
					flag = datos.inicioSesion();
				}
				catch(RutInvalidoException r) {
					JOptionPane.showMessageDialog(null, r.mostrarMensajeError());
				}
				
				if (flag) {
					final int rutx = Integer.parseInt(campoRut.getText());
					usuario = datos.inicioSesion(rutx, datos.Plibre);
					if(datos.Plibre == usuario) {
						final VentanaRegistro ventana2 = new VentanaRegistro(rutx, datos);
						ventana2.setVisible(true);
						datos.Plibre ++;
						dispose();
					}
					else {
						Persona pers = datos.getPersona(usuario);
						final VentanaUsuarioRegistrado ventana2 = new VentanaUsuarioRegistrado(datos, pers);
						ventana2.setVisible(true);
						dispose();
					}
				}
			}
		});
					
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(161, 155, 85, 21);
		contentPane.add(btnNewButton);
	}

}
