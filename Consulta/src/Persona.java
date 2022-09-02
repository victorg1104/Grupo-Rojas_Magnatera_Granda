

import java.util.HashMap;


public class Persona {
    // Declaracion de atributos
    private String Nombre, Genero;
    private int id, rut, edad, numero;
    private HashMap<Integer,String> respuestas;

    //Constructor
    public Persona(){
    	id = 0;
        rut = 0;
    	Nombre = "";
        Genero = "";
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
	
    public int GetId() {
        return id;
    }

    public void SetId(int id) {
        this.id = id;
    }

    public String GetNombre() {
        return Nombre;
    }

    public void SetNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String GetGenero() {
        return Genero;
    }

    public void SetGenero(String Genero) {
        this.Genero = Genero;
    }

    public int GetRut() {
        return rut;
    }

    public void SetRut(int rut) {
        this.rut = rut;
    }

    public int GetEdad() {
        return edad;
    }

    public void SetEdad(int edad) {
        this.edad = edad;
    }

    public int GetNumero() {
        return numero;
    }

    public void SetNumero(int numero) {
        this.numero = numero;
    }

}