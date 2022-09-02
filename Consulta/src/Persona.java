

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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}