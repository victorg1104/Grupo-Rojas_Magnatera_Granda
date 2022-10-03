import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaBuscarConsulta extends JFrame {

    private JPanel contentPane;
    public static JTextField campoPalabra;

    public VentanaBuscarConsulta(Datos datos, Persona usuario) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Ingrese palabra o consulta a buscar");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(91, 44, 260, 24);
        contentPane.add(lblNewLabel);

        campoPalabra = new JTextField();
        campoPalabra.setFont(new Font("Tahoma", Font.PLAIN, 15));
        campoPalabra.setBounds(121, 89, 197, 19);
        contentPane.add(campoPalabra);
        campoPalabra.setColumns(10);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaResultados ventana = new VentanaResultados(datos, usuario);
                ventana.setVisible(true);
                dispose();
            }
        });
        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnBuscar.setBounds(175, 136, 85, 21);
        contentPane.add(btnBuscar);
    }
}