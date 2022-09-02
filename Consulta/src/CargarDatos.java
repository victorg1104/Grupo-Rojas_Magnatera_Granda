import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CargarDatos {
	ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
	ArrayList<Persona> persona  = new ArrayList<Persona>();
	Persona pers = new Persona();
	String  Linea;
	int i;
	Pregunta p = new Pregunta();
	
	
	
	
	
	
	
	public CargarDatos(){
		
		
		
		
	}
	
	
	//Constructor 
	//Cargar Personas del csv
	public int CargarPreguntas(int Plibre_Pregunta){
		String  Linea;
			try {
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
				br.close();
			}	catch (FileNotFoundException ex) {
					System.err.println(ex.getMessage());
			}	catch (IOException ex) {
				System.err.println(ex.getMessage());
			}
			
			
			
				
		return Plibre_Pregunta;
		
		
		
	}
	
	//Constructor 
	//Cargar Personas del csv
	
	public int CargarPersonas(int Plibre) {
		
		

		try {
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
			br1.close();
		}	catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		}	catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
		
		
		return Plibre;
		
	}
	
	
	public void CargarRespuestas() {
		try {
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
			br2.close();
		}	catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		}	catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	
	public void NewRespuesta(int x,int usuario, String Respuesta) {
		p = preguntas.get(x);
		pers = persona.get(usuario);
		p.addPersonas(pers);
		pers.setRespuesta(x,Respuesta);
		
		try {
	        String content = "\n"+
	        		String.valueOf(x)+";"+
	        		String.valueOf(usuario)+";"+
	        		Respuesta;

	        File file = new File("src/bd_respuesta.csv");

	        // if file doesnt exists, then create it
	        if (!file.exists())
	            file.createNewFile();

	        FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
	        BufferedWriter bw = new BufferedWriter(fw);
	        
	        bw.append(content);
	    
	        bw.close();

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		
		
	}
	
	
	public int InicioSesion(int rutx, int Plibre) throws IOException{
		
		boolean flag = true;
		BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));
		
	
		// verifica si existe el Usuario
		for(i = 0; i < Plibre; i++) {
			pers = persona.get(i);
			if(rutx == pers.GetRut()) {
				Plibre = pers.GetId();
				System.out.println("Hola " + pers.GetNombre()+ "\n");
			flag = false;
			}
			
			
		}
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
				
				try {
			        String content = "\n"+ String.valueOf(Plibre)+
			        		";"+
			        		nombre+";"+
			        		genero+";"+
			        		String.valueOf(rutx)+";"+
			        		String.valueOf(edad)+";"+
			        		String.valueOf(numero);

			        File file = new File("src/bd_personas.csv");

			        // if file doesnt exists, then create it
			        if (!file.exists())
			            file.createNewFile();

			        FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			        BufferedWriter bw = new BufferedWriter(fw);
			        
			        bw.append(content);
			    
			        bw.close();

			    } catch (IOException e) {
			        e.printStackTrace();
			    }
				
				Plibre ++;
			}	
		return Plibre;
		
		
		
	}
	
	
	public int  agregar_newpregunta(int Plibre_Pregunta, int Usuario) throws IOException {
		BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));
		Pregunta p = new Pregunta();
		p.setIdPregunta(Plibre_Pregunta);
		p.setIdCreador(Usuario);
		System.out.println("Ingrese su pregunta: ");
		String Descripcion = Lector.readLine();
		p.setDescripcion(Descripcion);
		
		preguntas.add(Plibre_Pregunta,p);
		
		try {
	        String content = "\n"+ String.valueOf(Plibre_Pregunta)+
	        		";"+
	        		String.valueOf(Usuario)+
	        		";"+
	        		Descripcion;

	        File file = new File("src/bd_preguntas.csv");

	        // if file doesnt exists, then create it
	        if (!file.exists())
	            file.createNewFile();

	        FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
	        BufferedWriter bw = new BufferedWriter(fw);
	        
	        bw.append(content);
	    
	        bw.close();

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	
		
		
		
		Plibre_Pregunta ++;
		
		return Plibre_Pregunta;
	}
	
	
	public int Listar_pregunta(int Plibre_Pregunta,int Usuario) throws IOException {
		
		BufferedReader Lector = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < Plibre_Pregunta; i++ ) {
			p = preguntas.get(i);			
			pers = persona.get(Usuario);
			//boolean flag_x = noContiene(Usuario);
			if(pers.getRespuesta(p.getIdPregunta()) == null) {
				System.out.println(String.valueOf(i)+") "+p.getDescripcion());
			}
			
			}
		
		System.out.println("Ingrese la opcion a responder: ");
		int Opcion = Integer.parseInt(Lector.readLine());
		
		
		return Opcion;
		
		
		
	}
	
	
public void Listar_Respuesta(int Plibre_Pregunta,int Usuario){
		
		for(int i = 0; i < Plibre_Pregunta; i++ ) {
			p = preguntas.get(i);			
			pers = persona.get(Usuario);
			//boolean flag_x = noContiene(Usuario);
			if(pers.getRespuesta(p.getIdPregunta()) != null) {
				System.out.println(String.valueOf(i)+") "+p.getDescripcion());
				System.out.println(pers.getRespuesta(p.getIdPregunta()));
			}
			
			}

		
		
		return;
		
		
		
	}

public void Listar_Tus_Pregunta(int Plibre_Pregunta,int Usuario) throws IOException {
	boolean flag=true;
	for(int i = 0; i < Plibre_Pregunta; i++ ) {
		p = preguntas.get(i);			
		pers = persona.get(Usuario);
		if(Usuario == p.getIdCreador()) {
			System.out.println(p.getDescripcion()+"\n");
			flag=false;
			
		}
		
		}
	
	if(flag) {
		System.out.println("Uds no creo aun una pregunta....\n");
	}
	
	
	
}


	
	
	
	
	
	
	
	
}
