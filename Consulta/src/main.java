import java.io.*;

public class main {

	public static void main(String[] args) throws IOException{
		
		// inicio de Lector 
		BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));
		
		// Variables globales
		int Numero, Edad , Plibre = 0,Plibre_Pregunta = 0, Plibre_Respuesta = 0, max=10, opcion;
		String Nombre, Genero, Linea;
		
		// Creando Lista de personas
		System.out.println("Cargando datos .... ");
		
		Persona[] personas = new Persona[10];
		// Leer CVS....
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/bd_personas.csv"));
			Linea = br.readLine();
			while(Linea != null) {
				String datos[] = Linea.split(";");
				
				if(Plibre <= max) {
	
					
					personas[Plibre] = new Persona();
					personas[Plibre].SetId(Integer.parseInt(datos[0]));
					personas[Plibre].SetRut(Integer.parseInt(datos[1]));
					personas[Plibre].SetNombre(datos[2]);
					personas[Plibre].SetGenero(datos[3]);
					personas[Plibre].SetEdad(Integer.parseInt(datos[4]));
					personas[Plibre].SetNumero(Integer.parseInt(datos[5]));
					Plibre ++;
					//System.out.println("El usuario: "+datos[2]+" Fue Cargado");
				}
				Linea = br.readLine();
				
			}
		}	catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		}	catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
		

		

		// Carga de datos de las preguntas
		
		Pregunta[] preguntas = new Pregunta[10];
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/bd_preguntas.csv"));
			Linea = br.readLine();
			while(Linea != null) {
				String datos[] = Linea.split(";");
					if(Plibre_Pregunta <= max) {
						preguntas[Plibre_Pregunta] = new Pregunta();
						
						preguntas[Plibre_Pregunta].setIdPregunta(Integer.parseInt(datos[0]));
						preguntas[Plibre_Pregunta].setIdCreador(Integer.parseInt(datos[1]));
						preguntas[Plibre_Pregunta].setDescripcion(datos[2]);
						Plibre_Pregunta ++;
					//System.out.println("La pregunta : "+datos[2]+" Fue Cargada");
				}
				Linea = br.readLine();
				}
		}	catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		}	catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
		
		
		
		//Cargar las Respuestas.
		
		Respuesta[] respuestas = new Respuesta[10];
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/bd_respuesta.csv"));
			Linea = br.readLine();
			while(Linea != null) {
				String datos[] = Linea.split(";");
					if(Plibre_Respuesta <= max) {
						respuestas[Plibre_Respuesta] = new Respuesta();
						
						respuestas[Plibre_Respuesta].setIdRespuesta(Integer.parseInt(datos[0]));
						respuestas[Plibre_Respuesta].setIdPregunta(Integer.parseInt(datos[1]));
						respuestas[Plibre_Respuesta].setIdPersona(Integer.parseInt(datos[2]));
						respuestas[Plibre_Respuesta].setRespuesta_pregunta(datos[3]);
						Plibre_Respuesta ++;
					//System.out.println("La Respuesta : "+datos[3]+" Fue Cargada");
				}
				Linea = br.readLine();
				}
		}	catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		}	catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
		
		System.out.println("Datos listo");
		System.out.println("----------------------------------------------------");
		
	
			
			
		
		
		
		
		
		
		// Inicio Del Programa.
		System.out.println("----------------------------------------------------");
		System.out.println("Bienvenido a Planificación de consultas ciudadanas ");
		System.out.println("Ingrese su Rut: \n");
		
		// Se verifica si el Rut Existe 
		int rutx = 0;
		rutx = Integer.parseInt(Lector.readLine());
		//
		boolean flag = true;
		int R = 0;
		// verifica si existe el Usuario
		for(int i = 0; i < Plibre; i++) {
			
			R = personas[i].GetRut();
			if(R == rutx) {
			flag = false;
			}
		}
		
		// crea el nuevo usuario Si este no existe 
		if(flag) {
			String nombre, genero;
			int edad, numero;
			System.out.println("Su rut no esta registrado, se creara un usuario nuevo: ");
			personas[Plibre] = new Persona();
			personas[Plibre].SetId(Plibre);
			System.out.println("Ingrese su Nombre: ");
			nombre = Lector.readLine();
			personas[Plibre].SetNombre(nombre);
			
			System.out.println("Ingrese su genero: ");
			genero = Lector.readLine();
			personas[Plibre].SetGenero(genero);
			personas[Plibre].SetRut(rutx);
			
			System.out.println("Ingrese su edad: ");
			edad = Integer.parseInt(Lector.readLine());
			personas[Plibre].SetEdad(edad);
			
			System.out.println("Ingrese su numero telefonico (9 digito): ");
			numero = Integer.parseInt(Lector.readLine());
			personas[Plibre].SetNumero(numero);
			
			Plibre ++;
			
			System.out.println("Ingreso con exito!!! ");
			
			
			
			
		}
		
			
	
		
		System.out.println("----------------------------------------------------");
		
		
		// Sub Menu 
		flag = true;
		
		
		while(flag) {
			System.out.println("1. Crear Pregunta\n"
					+ "2. Mostrar Preguntas\n"
					+ "3. Listar Tus Preguntas\n"
					+ "4. Salir");
			System.out.println("Ingrese su opcion: ");
			opcion = Integer.parseInt(Lector.readLine());

			
			switch(opcion) {
			case 1:
				
			case 4:
				System.out.println("Su sesion se cerro.!!!");
				flag = false;
				
			
			}
			 
			}
		
			
			
	
		

	}
}

