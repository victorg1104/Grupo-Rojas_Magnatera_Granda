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
			
				CargarDatos datos = new CargarDatos();
				
				PlibreConsulta = datos.cargarConsultas(PlibreConsulta);
				
				Plibre = datos.cargarPersonas(Plibre);
				
				datos.cargarRespuestas();
				
				System.out.println("Datos cargados");
				System.out.println("--------------------------------------------------");
				
				// Inicio Del Programa.
				System.out.println("----------------------------------------------------");
				System.out.println("Bienvenido a Planificación de consultas ciudadanas ");
				System.out.println("Ingrese su Rut: \n");
				
				// Se verifica si el Rut Existe
				int rutx = 0;
				
				rutx = Integer.parseInt(lector.readLine());
				
				//Si Existe 
				
				int usuario = datos.inicioSesion(rutx, Plibre);
				System.out.println(usuario);
				if(Plibre < usuario) { 
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
						
						PlibreConsulta = datos.agregarNewConsulta(PlibreConsulta, usuario-1);
						break;
						
					case 2:
						
						int x = 0;
						x = datos.listarConsultas(PlibreConsulta, usuario-1);
						System.out.println("Ingrese su respuesta: ");
						String Respuesta = lector.readLine();
						datos.newRespuesta(x,usuario-1,Respuesta);
						break;

					case 3:
						
						datos.listarRespuestas(PlibreConsulta, usuario-1);
						break;
					
						
					case 4:
						
						datos.listarTusConsultas(PlibreConsulta,usuario-1);
						break;
						
					case 5:
						
						System.out.println("Su sesion se cerro.!!!");
						flag = false;
						
					}
					 
				}
	}

}
