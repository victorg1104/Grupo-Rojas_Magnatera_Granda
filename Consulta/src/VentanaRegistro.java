import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField campoNombre;
	private JTextField campoEdad;
	private JTextField campoNum;
	private ButtonGroup botones = new ButtonGroup();
	public int rutx;

	/**
	 * Create the frame.
	 */
	public VentanaRegistro(int rutx, Datos datos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel mensajeRegistro = new JLabel("Su rut no está registrado, se creará un usuario nuevo");
		mensajeRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeRegistro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mensajeRegistro.setBounds(70, 10, 426, 27);
		contentPane.add(mensajeRegistro);
		
		JLabel etiquietaNombre = new JLabel("Nombre:");
		etiquietaNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etiquietaNombre.setBounds(10, 61, 86, 13);
		contentPane.add(etiquietaNombre);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(117, 60, 178, 19);
		contentPane.add(campoNombre);
		campoNombre.setColumns(10);
		
		JLabel etiquetaGenero = new JLabel("Género:");
		etiquetaGenero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etiquetaGenero.setBounds(10, 111, 83, 13);
		contentPane.add(etiquetaGenero);
		
		JRadioButton botonMasculino = new JRadioButton("Masculino");
		botonMasculino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonMasculino.setBounds(117, 109, 103, 21);
		contentPane.add(botonMasculino);
		
		JRadioButton botonFemenino = new JRadioButton("Femenino");
		botonFemenino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonFemenino.setBounds(222, 109, 103, 21);
		contentPane.add(botonFemenino);
		
		botones.add(botonFemenino);
		botones.add(botonMasculino);
		
		JLabel etiquetaEdad = new JLabel("Edad:");
		etiquetaEdad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etiquetaEdad.setBounds(10, 166, 83, 13);
		contentPane.add(etiquetaEdad);
		
		campoEdad = new JTextField();
		campoEdad.setColumns(10);
		campoEdad.setBounds(117, 165, 178, 19);
		contentPane.add(campoEdad);
		
		JLabel etiquetaNum = new JLabel("Número de teléfono:");
		etiquetaNum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		etiquetaNum.setBounds(10, 226, 139, 13);
		contentPane.add(etiquetaNum);
		
		campoNum = new JTextField();
		campoNum.setColumns(10);
		campoNum.setBounds(163, 225, 178, 19);
		contentPane.add(campoNum);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final VentanaUsuarioRegistrado ventanaRegistrado;
				String nombre, genero;
				int rut = rutx, edad, numero;
				
				nombre = campoNombre.getText();
				
				if(botonMasculino.isSelected()) {
					genero = "Masculino";
				}
				else {
					if(botonFemenino.isSelected()) {
						genero = "Femenino";
					}
					else {
						genero = "";
					}
				}
				
				edad = Integer.parseInt(campoEdad.getText());
				
				numero = Integer.parseInt(campoNum.getText());
				
				datos.crearPersona(datos.Plibre, rut, nombre, genero, edad, numero);
				
				JOptionPane.showMessageDialog(null, "Registro exitoso");
				
				ventanaRegistrado = new VentanaUsuarioRegistrado(datos, datos.getPersona(datos.Plibre));
				ventanaRegistrado.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(232, 289, 85, 21);
		contentPane.add(btnNewButton);
	}
}
