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
	private ArrayList<Consulta> consultas = new ArrayList<Consulta>();
	private ArrayList<Persona> persona  = new ArrayList<Persona>();
	private Persona pers = new Persona();
	private String  linea;
	private int i;
	private Consulta c = new Consulta();
	
	public CargarDatos(){
	
	}
	//Constructor 
	//Cargar Personas del csv
	public int cargarConsultas(int PlibreConsulta){
		String  linea;
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/bd_consultas.csv"));
				linea = br.readLine();
				while(linea != null) {
					Consulta c1 = new Consulta();
					// constructor				
					String datos[] = linea.split(";");
					c1.setIdConsulta(Integer.parseInt(datos[0]));
					c1.setIdCreador(Integer.parseInt(datos[1]));
					c1.setDescripcion(datos[2]);
					consultas.add(PlibreConsulta, c1);
					PlibreConsulta ++;
					// lee la siguiente linea
					linea = br.readLine();
					}
				br.close();
			}	catch (FileNotFoundException ex) {
					System.err.println(ex.getMessage());
			}	catch (IOException ex) {
				System.err.println(ex.getMessage());
			}	

		return PlibreConsulta;	
	}
	
	//Constructor 
	//Cargar Personas del csv
	
	public int cargarPersonas(int Plibre) {
		try {
			BufferedReader br1 = new BufferedReader(new FileReader("src/bd_personas.csv"));
			linea = br1.readLine();
			while(linea != null) {
				String datos[] = linea.split(";");
				
					Persona pers1 = new Persona();
					pers1.setId(Integer.parseInt(datos[0]));
					pers1.setRut(Integer.parseInt(datos[1]));
					pers1.setNombre(datos[2]);
					pers1.setGenero(datos[3]);
					pers1.setEdad(Integer.parseInt(datos[4]));
					pers1.setNumero(Integer.parseInt(datos[5]));
					
					persona.add(Plibre,pers1);
					
					Plibre ++;
				linea = br1.readLine();
				
			}
			br1.close();
		}	catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		}	catch (IOException ex) {
			System.err.println(ex.getMessage());
		}

		return Plibre;		
	}
	
	
	public void cargarRespuestas() {
		try {
			BufferedReader br2 = new BufferedReader(new FileReader("src/bd_respuesta.csv"));
			linea = br2.readLine();
			while(linea != null) {
				String datos[] = linea.split(";");
				//
				c = consultas.get(Integer.parseInt(datos[0]));
				pers = persona.get(Integer.parseInt(datos[1]));
				
				c.addPersonas(pers);
				
				pers.setRespuesta(Integer.parseInt(datos[0]), datos[2]);
				linea = br2.readLine();
			}
			br2.close();
		}	catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		}	catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	
	public void newRespuesta(int x,int usuario, String respuesta) {
		c = consultas.get(x);
		pers = persona.get(usuario);
		c.addPersonas(pers);
		pers.newRespuesta(x, respuesta);
	}
	
	
	public int inicioSesion(int rutx, int Plibre) throws IOException{
		
		boolean flag = true;
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

		// verifica si existe el Usuario
		for(i = 0; i < Plibre; i++) {
			pers = persona.get(i);
			if(rutx == pers.getRut()) {
				Plibre = pers.getId();
				System.out.println("Hola " + pers.getNombre()+ "\n");
			flag = false;
			}
		}
			if(flag) {
				Persona persN = new Persona();
				String nombre, genero;
				int edad, numero;
				System.out.println("Su rut no esta registrado, se creara un usuario nuevo: ");
				persN.setId(Plibre);
				System.out.println("Ingrese su Nombre: ");
				nombre = lector.readLine();
				persN.setNombre(nombre);
				
				System.out.println("Ingrese su genero: ");
				genero = lector.readLine();
				persN.setGenero(genero);
				persN.setRut(rutx);
				
				System.out.println("Ingrese su edad: ");
				edad = Integer.parseInt(lector.readLine());
				persN.setEdad(edad);
				
				System.out.println("Ingrese su numero telefonico (9 digito): ");
				numero = Integer.parseInt(lector.readLine());
				persN.setNumero(numero);
				persona.add(Plibre,persN);
				
				System.out.println("Ingreso con exito!!! ");
				
				try {
			        String content = "\n"+ String.valueOf(Plibre)+
			        		";"+
			        		String.valueOf(rutx)+";"+
			        		nombre+";"+
			        		genero+";"+
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
			}	
			
		return Plibre;
	}
	
	
	public int  newConsulta(int PlibreConsulta, int usuario) throws IOException {
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		Consulta c = new Consulta();
		c.setIdConsulta(PlibreConsulta);
		c.setIdCreador(usuario);
		System.out.println("Ingrese su consulta: ");
		String descripcion = lector.readLine();
		c.setDescripcion(descripcion);
		
		consultas.add(PlibreConsulta,c);
		
		c.newConsulta();
		
		PlibreConsulta++;
		
		return PlibreConsulta;
	}
	
	
	public int listarConsultas(int PlibreConsulta,int usuario) throws IOException {
		
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = false;
		pers = persona.get(usuario);
		
		for(int i = 0; i < PlibreConsulta; i++ ) {
			c = consultas.get(i);			
			flag = pers.listar(i, c);
		}
		
		if(flag == false) {
			System.out.println("Usted ha respondido todas las consultas\n");
		}
		else {
			System.out.println("Ingrese id de consulta a responder: ");
			int Opcion = Integer.parseInt(lector.readLine());
		
			return Opcion;
		}
		return -1;
	}
	
	public void listarConsultas(int PlibreConsulta,int usuario, boolean flag){
	for(int i = 0; i < PlibreConsulta; i++ ) {
		c = consultas.get(i);			
		if(usuario == c.getIdCreador()) {
			System.out.println(c.getDescripcion()+"\n");
			flag=false;	
			}
		}
	
	if(flag) {
		System.out.println("Usted no creo aun una pregunta....\n");
		}
	}
	
	public void listarRespuestas(int PlibreConsulta,int usuario, boolean respuesta){
		pers = persona.get(usuario);
		
		for(int i = 0; i < PlibreConsulta; i++ ) {
			c = consultas.get(i);			
			respuesta = pers.listar(i, c, respuesta);
		}
		
		if(respuesta == false) {
			System.out.println("Usted no ha respondido ninguna consulta\n");
		}
	}


}
