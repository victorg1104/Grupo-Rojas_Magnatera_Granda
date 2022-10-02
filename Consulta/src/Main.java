import java.io.IOException;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// inicio de Lector 
				Datos datos = new Datos();	
				// Inicio Del Programa.
				
				VentanaInicioSesion ventanaInicio = new VentanaInicioSesion(datos);
				ventanaInicio.setVisible(true);		
	}
	
}
