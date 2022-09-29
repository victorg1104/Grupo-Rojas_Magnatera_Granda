import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


public class Persona {
    // Declaracion de atributos
    private String nombre, genero;
    private int id, rut, edad, numero;
    private HashMap<Integer,String> respuestas;

    //Constructor
    public Persona(){
    	id = 0;
        rut = 0;
    	nombre = "";
        genero = "";
        edad = 0;
        numero = 0;
        // keys = Id_pregunta : "respuesta"
        respuestas = new HashMap<Integer, String>();
    }
    // Getter y Setter
    
    public void newRespuesta(int x, String respuesta) {
    	setRespuesta(x, respuesta);
		try {
	        String content = "\n"+
	        		String.valueOf(x)+";"+
	        		String.valueOf(id)+";"+
	        		respuesta;

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
    
    public boolean listar(int i, Consulta c) {
    	boolean flag = false;
    	
    	if(getRespuesta(c.getIdConsulta()) == null) {
			System.out.println(String.valueOf(i)+") " + c.getDescripcion());
			flag = true;
		}
    	
    	return flag;
    }
    
    public boolean listar(int i, Consulta c, boolean respuesta) {
    	if(getRespuesta(c.getIdConsulta()) != null) {
			System.out.println(String.valueOf(i)+") " + c.getDescripcion());
			System.out.println(getRespuesta(c.getIdConsulta()));
			respuesta = true;
		}
		return respuesta;
	}
    
    public void setRespuesta(int id_pregunta,String respuesta) {
    	respuestas.put(id_pregunta,respuesta);    	
    }
    
    public String getRespuesta(int id_pregunta) {
    	return  respuestas.get(id_pregunta);
    	
    }
	
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String Genero) {
        this.genero = Genero;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void setEdad(double edad) {
    	this.edad = (int) edad;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}