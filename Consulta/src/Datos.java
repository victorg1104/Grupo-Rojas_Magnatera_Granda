import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Datos {
	private ArrayList<Consulta> consultas;
	private ArrayList<Persona> persona;
	private Persona pers;
	private String  linea;
	private int i, rutx, opcion, usuario;
	public int Plibre, PlibreConsulta;
	private Consulta c;
	private boolean flag;
	
	public Datos(){
		c = new Consulta();
		pers = new Persona();
		persona  = new ArrayList<Persona>();
		consultas = new ArrayList<Consulta>();
		PlibreConsulta = cargarConsultas(0);
		Plibre = cargarPersonas(0);
		usuario = 0;
		flag = true;
		cargarRespuestas();
	}
	
	public boolean getFlag() {
		return flag;
	}
	
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	
	//Cargar Consultas del csv
	
	public int cargarConsultas(int PlibreConsulta){
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
				pers = persona.get(Integer.parseInt(datos[2]));
				pers.setRespuesta(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]),Integer.parseInt(datos[2]), datos[3]);
				linea = br2.readLine();
			}
			br2.close();
		}	catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		}	catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	public boolean validarConsulta() throws ConsultaInvalidaException{
        if(Integer.parseInt(VentanaResponderConsulta.textField.getText()) < 0 || Integer.parseInt(VentanaResponderConsulta.textField.getText()) >= consultas.size()) {
            throw new ConsultaInvalidaException();
        }
        else return true;
    }

    public boolean validarConsultaRepetida(Persona p, String idConsulta) throws ConsultaInvalidaException{
        if(p.buscar(Integer.parseInt(idConsulta)) == -1) throw new ConsultaInvalidaException();
        else return true;
    }
    
    
    public void newRespuesta(int usuario) {
		pers = persona.get(usuario); 
        pers.newRespuesta(Integer.parseInt(VentanaResponderConsulta.textField.getText()), VentanaRespuesta.campoRespuesta.getText());
	}
		
	public void newRespuesta(int usuario, int idConsulta, String respuesta) {
        pers = persona.get(usuario);
        pers.newRespuesta(idConsulta, respuesta);
    }
	
	public boolean inicioSesion() throws RutInvalidoException{
		rutx = Integer.parseInt(VentanaInicioSesion.campoRut.getText());
		if( rutx < 9999999){
			throw new RutInvalidoException();
		}
		else return true;
	}
	
	public int inicioSesion(int rutx, int Plibre){		
		// verifica si existe el Usuario
		for(i = 0; i < Plibre; i++) {
			pers = persona.get(i);
			if(rutx == pers.getRut()) {
				Plibre = pers.getId();
				return Plibre;
			}
		}
		
		return Plibre;
	}
	
	public void crearPersona(int Id, int rut, String nombre, String genero, int edad, int numero) {
		Persona persN = new Persona();
		persN.setId(Id-1);
		persN.setNombre(nombre);
		persN.setGenero(genero);
		persN.setRut(rutx);
		persN.setEdad(edad);
		persN.setNumero(numero);
		
		persona.add(Plibre-1,persN);
		
		try {
	        String content = "\n"+ String.valueOf(Plibre-1)+
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
	
	public Persona getPersona(int usuario) {
		for(i = 0; i < Plibre; i++) {
			Persona pers = persona.get(i);
			if(usuario == pers.getId()) {
				return pers;
			}
		}
		return null;
	}
	
	public void  newConsulta(int usuario){
		Consulta c = new Consulta();
		c.setIdConsulta(PlibreConsulta);
		c.setIdCreador(usuario);
		String descripcion = VentanaCrearConsulta.campoConsulta.getText();
		c.setDescripcion(descripcion);
		
		consultas.add(PlibreConsulta,c);
		
		c.guardarEnCsv();
		
		PlibreConsulta++;
	}
	
	public Object[] listarConsultas(Object[] fila, int usuario, int IDcons){
		
		pers = persona.get(usuario);
		c = consultas.get(IDcons);
		
		fila[0] = String.valueOf(pers.buscar(IDcons));
		if(fila[0].equals(String.valueOf(-1)) == false) {
			fila[1] = c.getDescripcion();
			return fila;
		}
		return null;		
	}
	
	public Object[] listarTusConsultas(Object[] fila,int usuario, int IDcons){
		c = consultas.get(IDcons);
		
		if (usuario == c.getIdCreador()) {
			fila[0] = String.valueOf(IDcons);
			fila[1] = c.getDescripcion();
			return fila;
		}
		return null;
	}
	
	public Object[] buscarConsultas(Object[] fila, int usuario, int IDcons) {
		c = consultas.get(IDcons);

		if(c.getDescripcion().toLowerCase().contains(VentanaBuscarConsulta.campoPalabra.getText().toLowerCase())) {
			fila[0] = IDcons;
			fila[1] = c.getDescripcion();
			return fila;
		}
		return null;
	}
	
	public Object[] listarRespuestas(Object[] fila, int idUsuario, int IDRes){
		pers = persona.get(idUsuario);
		
		Respuesta r = pers.getRespuesta(IDRes);
		c = consultas.get(r.idPregunta);
		
		fila[0] = String.valueOf(r.idPregunta);
		fila[1] = c.getDescripcion();
		fila[2] = r.getDescripcion();			
		return fila;
	}

	
	public void editarRespuesta(String idCons, String res, Persona usuario) {
		String [] lineas = new String[10];
		int cont = 0;
		
		try {
			BufferedReader br2 = new BufferedReader(new FileReader("src/bd_respuesta.csv"));
			linea = br2.readLine();

			while(linea != null) {
				String datos[] = linea.split(";");
				if((datos[1].equals(idCons) && datos[2].equals(String.valueOf(usuario.getId())))) {
					linea = datos[0] + ";" + datos[1] + ";" + datos[2] + ";" + res;
					lineas[cont] = linea;
				}
				else {
					lineas[cont] = linea;
				}
				linea = br2.readLine();
				
				cont++;
			}
			BufferedWriter editor = new BufferedWriter(new FileWriter("src/bd_respuesta.csv"));
			for (int i  = 0; i < cont; i++) {
				if(i != cont - 1) editor.append(lineas[i] + "\n");
				else editor.append(lineas[i]);
			}
			br2.close();
			editor.close();
		}	catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		}	catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
		
		// editar del array
    	usuario.editarRespuesta(idCons, usuario, res);
	}
	
	public boolean eliminarRespuesta(String idCons, String idPersona, Persona usuario, String idRespuesta) {
		boolean flag = true;
		String [] lineas = new String[10];
		int cont = 0;
		
		try {
			BufferedReader br2 = new BufferedReader(new FileReader("src/bd_respuesta.csv"));
			linea = br2.readLine();

			while(linea != null) {
				String datos[] = linea.split(";");
				//
				if((datos[1].equals(idCons) && datos[2].equals(idPersona))) {
					flag = false;
				}
				else {
					lineas[cont] = linea;
					cont++;
				}
				
				linea = br2.readLine();
			}
			BufferedWriter editor = new BufferedWriter(new FileWriter("src/bd_respuesta.csv"));
			
			for (int i  = 0; i < cont; i++) {
				if(i != cont - 1) editor.append(lineas[i] + "\n");
				else editor.append(lineas[i]);
			}
			br2.close();
			editor.close();
		}	catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());
		}	catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
		
		usuario.eliminarRespuesta(idRespuesta, usuario);
		
		return flag;

	}
}
