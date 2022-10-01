import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// inicio de Lector 
				BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
			
				Datos datos = new Datos();	
				// Inicio Del Programa.
				
				VentanaInicioSesion ventanaInicio = new VentanaInicioSesion(datos);
				ventanaInicio.setVisible(true);
				
	}

}
