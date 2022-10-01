import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaUsuarioRegistrado extends JFrame {

	private JPanel contentPane;
	public Datos datos;

	/**
	 * Create the frame.
	 */
	public VentanaUsuarioRegistrado(Datos datos, Persona usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.datos = datos;
		JLabel mensajeBienvenida = new JLabel("Bienvenido " + usuario.getNombre());
		mensajeBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mensajeBienvenida.setBounds(20, 24, 391, 37);
		contentPane.add(mensajeBienvenida);
	}

}
