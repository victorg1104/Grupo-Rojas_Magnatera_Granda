import java.io.*;

public class main {

	public static void main(String[] args) throws IOException{
		
		// inicio de Lector 
		BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));
		
		// Variables globales
		int Numero, Edad , Plibre = 0,Plibre_Pregunta = 0, max=10, opcion;
		String Nombre, Genero;
		
		// Creando Lista de personas
		
		Persona[] personas = new Persona[10];
		// Leer CVS....
		if(Plibre < max) {
			System.out.println("Cargando datos ....");
			// datos 1
			personas[Plibre] = new Persona();
			personas[Plibre].SetId(Plibre);
			System.out.println("Cargando datos ....");
			personas[Plibre].SetNombre("Victor");
			personas[Plibre].SetGenero("Masculino");
			personas[Plibre].SetRut(2020);
			personas[Plibre].SetEdad(22);
			personas[Plibre].SetNumero(645656551);
			
			Plibre ++;
			personas[Plibre] = new Persona();
			// datos 2
			personas[Plibre].SetId(Plibre);
			personas[Plibre].SetNombre("Ramiro");
			personas[Plibre].SetGenero("Masculino");
			personas[Plibre].SetRut(2021);
			personas[Plibre].SetEdad(22);
			personas[Plibre].SetNumero(645656551);
			
			// datos 3
			
			Plibre ++;
			personas[Plibre] = new Persona();
			personas[Plibre].SetId(Plibre);
			personas[Plibre].SetNombre("Victor");
			personas[Plibre].SetGenero("Masculino");
			personas[Plibre].SetRut(2023);
			personas[Plibre].SetEdad(22);
			personas[Plibre].SetNumero(645656551);	
			
			Plibre ++;
			
		}

		// Carga de datos 
		
		Pregunta[] preguntas = new Pregunta[10];
		if(Plibre_Pregunta <= max) {
			preguntas[Plibre_Pregunta] = new Pregunta();
			preguntas[Plibre_Pregunta].setIdPregunta(Plibre_Pregunta);
			preguntas[Plibre_Pregunta].setIdCreador(1);
			preguntas[Plibre_Pregunta].setDescripcion("¿aprueba o Rechaza?");
			
			Plibre_Pregunta ++;
			preguntas[Plibre_Pregunta] = new Pregunta();
			preguntas[Plibre_Pregunta].setIdPregunta(Plibre_Pregunta);
			preguntas[Plibre_Pregunta].setIdCreador(2);
			preguntas[Plibre_Pregunta].setDescripcion("¿Aborto legal?");
			
			Plibre_Pregunta ++;
			preguntas[Plibre_Pregunta] = new Pregunta();
			preguntas[Plibre_Pregunta].setIdPregunta(Plibre_Pregunta);
			preguntas[Plibre_Pregunta].setIdCreador(3);
			preguntas[Plibre_Pregunta].setDescripcion("¿Goku Gana?");
			
			
		}
		
		
		
		
		
		
		// Inicio Menu
		System.out.println("Ingrese su Rut: ");
		int rutx = 0;
		rutx = Integer.parseInt(Lector.readLine());
		//
		boolean flag = true;
		int R = 0;
		
		for(int i = 0; i < Plibre; i++) {
			
			R = personas[i].GetRut();
			if(R == rutx) {
			flag = false;
			}
		}
		
		// crea el nuevo usuario.
		
		String nombre, genero;
		int edad, numero;
		
		
		if(flag) {
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
		
			
	
		
	
		
		
		// Sub Menu 
		flag = true;	
		
		while(flag) {
			System.out.println("1. Crear Pregunta\n"
					+ "2. Mostrar Preguntas\n"
					+ "3. Listar Tus Preguntas\n"
					+ "4. Salir");
			flag = false;
			}
			
			
	
		

	}
}

