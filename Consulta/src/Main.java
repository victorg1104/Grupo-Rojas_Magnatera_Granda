import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// inicio de Lector 
				BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
				
				// Variables globales
				
				
				// Creando Lista de personas
				System.out.println("Cargando datos .... ");
				// Carga de datos
				// Pregunta - Persona - Respuestas.
				
				
				int  Plibre = 0, PlibreConsulta = 0, opcion;
			
				Datos datos = new Datos();
				
				PlibreConsulta = datos.cargarConsultas(PlibreConsulta);
				
				Plibre = datos.cargarPersonas(Plibre);
				
				datos.cargarRespuestas();
				
				System.out.println("Datos cargados");
				System.out.println("--------------------------------------------------");
				
				// Inicio Del Programa.
				System.out.println("----------------------------------------------------");
				System.out.println("Bienvenido a Planificación de consultas ciudadanas ");
				System.out.println("Ingrese su Rut sin puntos ni guión: \n");
				
				// Se verifica si el Rut Existe
				int rutx = 0;
				
				rutx = Integer.parseInt(lector.readLine());
				
				//Si Existe 
				
				int usuario = datos.inicioSesion(rutx, Plibre);

				if(Plibre == usuario) { 
					Plibre ++;
				}	
				
				System.out.println("----------------------------------------------------");
				
				// Sub Menu 
				boolean flag = true;
				
				
				while(flag) {
					
					// Agregar funcion Eliminar y editar las respuesta.
					System.out.println("1. Crear Pregunta\n"
							+ "2. Mostrar Preguntas a responder\n"
							+ "3. Listar respuestas\n"
							+ "4. Listar Tus preguntas creadas\n"
							+ "5. Salir");
					
					System.out.println("Ingrese su opcion: ");
					opcion = Integer.parseInt(lector.readLine());

					
					switch(opcion) {
					case 1:
						
						PlibreConsulta = datos.newConsulta(PlibreConsulta, usuario);
						break;
						
					case 2:
						
						int x = 0;
						x = datos.listarConsultas(PlibreConsulta, usuario);
						if(x != -1) {
							System.out.println("Ingrese su respuesta: ");
							String Respuesta = lector.readLine();
							datos.newRespuesta(x,usuario,Respuesta);
						}
						break;

					case 3:
						
						boolean respuesta = false;
						datos.listarRespuestas(PlibreConsulta, usuario, respuesta);
						break;
					
						
					case 4:
						
						datos.listarConsultas(PlibreConsulta,usuario,flag);
						break;
						
					case 5:
						
						System.out.println("Su sesion se cerro.!!!");
						flag = false;
						
					}
					 
				}
	}

}
