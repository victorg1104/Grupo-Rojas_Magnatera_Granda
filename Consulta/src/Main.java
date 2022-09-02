import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// inicio de Lector 
				BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));
				
				// Variables globales
				
				
				// Creando Lista de personas
				System.out.println("Cargando datos .... ");
				// Carga de datos
				// Pregunta - Persona - Respuestas.
				
				
				int  Plibre = 0,Plibre_Pregunta = 0, opcion;
			
				CargarDatos Datos = new CargarDatos();
				
				Plibre_Pregunta = Datos.CargarPreguntas(Plibre_Pregunta);
				
				Plibre = Datos.CargarPersonas(Plibre);
				
				Datos.CargarRespuestas();
				
				System.out.println("Datos listo");
				System.out.println("--------------------------------------------------");
				
				// Inicio Del Programa.
				System.out.println("----------------------------------------------------");
				System.out.println("Bienvenido a Planificación de consultas ciudadanas ");
				System.out.println("Ingrese su Rut: \n");
				
				// Se verifica si el Rut Existe
				int rutx = 0;
				
				rutx = Integer.parseInt(Lector.readLine());
				
				//Si Existe 
				
				int Usuario = Datos.InicioSesion(rutx, Plibre);
				
				if(Plibre < Usuario) { 
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
							+ "4. Tus preguntas\n"
							+ "5. Salir");
					
					System.out.println("Ingrese su opcion: ");
					opcion = Integer.parseInt(Lector.readLine());

					
					switch(opcion) {
					case 1:
						
						
						Plibre_Pregunta = Datos.agregar_newpregunta(Plibre_Pregunta, Usuario);
						
						
						break;
						
					case 2:
						int x = 0;
						x = Datos.Listar_pregunta(Plibre_Pregunta, Usuario);
						System.out.println("Ingrese su respuesta: ");
						String Respuesta = Lector.readLine();
						Datos.NewRespuesta(x,Usuario,Respuesta);
						break;
						
						
						
					case 3:
						
						Datos.Listar_Respuesta(Plibre_Pregunta, Usuario);
						break;
					
						
					case 4:
						Datos.Listar_Tus_Pregunta(Plibre_Pregunta,Usuario);
						break;
						
										
						
					case 5:
						System.out.println("Su sesion se cerro.!!!");
						flag = false;
						
					
					}
					 
					}
				
					
					
			
				

		

	}

}
