import java.io.*;
import java.util.ArrayList;



public class main {

	public static void main(String[] args) throws IOException{
		
		// inicio de Lector 
		BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));
		
		// Variables globales
		int  Plibre = 0,Plibre_Pregunta = 0, opcion;
		String  Linea;
		
		
		// Creando Lista de personas
		System.out.println("Cargando datos .... ");
		
		
		// Carga de datos de las preguntas
		
				ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
				Pregunta p = new Pregunta();
				try {
					@SuppressWarnings("resource")
					BufferedReader br = new BufferedReader(new FileReader("src/bd_preguntas.csv"));
					Linea = br.readLine();
					while(Linea != null) {
						Pregunta p1 = new Pregunta();
						// constructor
						
						String datos[] = Linea.split(";");
						p1.setIdPregunta(Integer.parseInt(datos[0]));
						p1.setIdCreador(Integer.parseInt(datos[1]));
						p1.setDescripcion(datos[2]);
						preguntas.add(Plibre_Pregunta,p1);
						Plibre_Pregunta ++;
						// lee la siguiente linea
						Linea = br.readLine();
						}
				}	catch (FileNotFoundException ex) {
					System.err.println(ex.getMessage());
				}	catch (IOException ex) {
					System.err.println(ex.getMessage());
				}
		
		
		ArrayList<Persona> persona  = new ArrayList<Persona>();

		// Leer CVS....
		Persona pers = new Persona();
		try {
			@SuppressWarnings("resource")
			BufferedReader br1 = new BufferedReader(new FileReader("src/bd_personas.csv"));
			Linea = br1.readLine();
			while(Linea != null) {
				String datos[] = Linea.split(";");
				
					Persona pers1 = new Persona();
					pers1.SetId(Integer.parseInt(datos[0]));
					pers1.SetRut(Integer.parseInt(datos[1]));
					pers1.SetNombre(datos[2]);
					pers1.SetGenero(datos[3]);
					pers1.SetEdad(Integer.parseInt(datos[4]));
					pers1.SetNumero(Integer.parseInt(datos[5]));
					
					persona.add(Plibre,pers1);
					
					Plibre ++;
				Linea = br1.readLine();
				
			}
		}	catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		}	catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
		

		// Cargar Respuesta
		try {
			@SuppressWarnings("resource")
			BufferedReader br2 = new BufferedReader(new FileReader("src/bd_respuesta.csv"));
			Linea = br2.readLine();
			while(Linea != null) {
				String datos[] = Linea.split(";");
				//
				p = preguntas.get(Integer.parseInt(datos[0]));
				pers = persona.get(Integer.parseInt(datos[1]));
				
				p.addPersonas(pers);
				
				pers.setRespuesta(Integer.parseInt(datos[0]), datos[2]);
				Linea = br2.readLine();
				
			}
		}	catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		}	catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
		

		
		
		
		
		//Cargar las Respuestas.
		
		
		System.out.println("Datos listo");
		System.out.println("--------------------------------------------------");
		
		
		// Inicio Del Programa.
		System.out.println("----------------------------------------------------");
		System.out.println("Bienvenido a Planificación de consultas ciudadanas ");
		System.out.println("Ingrese su Rut: \n");
		
		// Se verifica si el Rut Existe 
		int rutx = 0;
		
		rutx = Integer.parseInt(Lector.readLine());
		//
		boolean flag = true;
	
		// verifica si existe el Usuario
		for(int i = 0; i < Plibre; i++) {
			
			pers = persona.get(i);
			if(rutx == pers.GetRut()) {
				Plibre = pers.GetId();
			flag = false;
			}
		}
		
		// crea el nuevo usuario Si este no existe 
		// Cargar respuestas
		
		
		
		if(flag) {
			Persona persN = new Persona();
			String nombre, genero;
			int edad, numero;
			System.out.println("Su rut no esta registrado, se creara un usuario nuevo: ");
			persN.SetId(Plibre);
			System.out.println("Ingrese su Nombre: ");
			nombre = Lector.readLine();
			persN.SetNombre(nombre);
			
			System.out.println("Ingrese su genero: ");
			genero = Lector.readLine();
			persN.SetGenero(genero);
			persN.SetRut(rutx);
			
			System.out.println("Ingrese su edad: ");
			edad = Integer.parseInt(Lector.readLine());
			persN.SetEdad(edad);
			
			System.out.println("Ingrese su numero telefonico (9 digito): ");
			numero = Integer.parseInt(Lector.readLine());
			persN.SetNumero(numero);
			persona.add(Plibre,persN);
			
			System.out.println("Ingreso con exito!!! ");
		}
		
		
		
		
		
		System.out.println("----------------------------------------------------");
		
		// Sub Menu 
		flag = true;
		
		
		while(flag) {
			
			// Agregar funcion Eliminar y editar las respuesta.
			System.out.println("1. Crear Pregunta\n"
					+ "2. Mostrar Preguntas a responder\n"
					+ "3. Listar respuestas\n"
					+ "4. Salir");
			
			System.out.println("Ingrese su opcion: ");
			opcion = Integer.parseInt(Lector.readLine());

			
			switch(opcion) {
			case 1:
				
				p.setIdPregunta(Plibre_Pregunta);
				p.setIdCreador(Plibre_Pregunta);
				System.out.println("Ingrese su pregunta: ");
				String Descripcion = Lector.readLine();
				p.setDescripcion(Descripcion);
				preguntas.add(Plibre_Pregunta,p);
				Plibre_Pregunta ++;
				//Agregar a la bd
				
				break;
				
			case 2:
				for(int i = 0; i < Plibre_Pregunta; i++ ) {
					p = preguntas.get(i);
					boolean flag_x = p.noContiene(Plibre);
					if(flag_x) {
						System.out.println(p.getDescripcion());
					}
					
					}
				break;
				
				
				
			case 3:
								
				
			case 4:
				System.out.println("Su sesion se cerro.!!!");
				flag = false;
				
			
			}
			 
			}
		
			
			
	
		

	}
}

