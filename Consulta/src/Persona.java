import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


public class Persona {
    // Declaracion de atributos
    private String nombre, genero;
    private int id, rut, edad, numero;
    private HashMap<Integer,Respuesta> respuestas;

    //Constructor
    public Persona(){
    	id = 0;
        rut = 0;
    	nombre = "";
        genero = "";
        edad = 0;
        numero = 0;
        // keys = Id_pregunta : "respuesta"
        respuestas = new HashMap<Integer, Respuesta>();
    }
    // Getter y Setter
    
    public void newRespuesta(int x, String respuesta) {
        Respuesta aux = new Respuesta(x, id, respuesta);
        respuestas.put(x, aux);
        aux.guardarEnCsv();
    }
    
    public void newRespuesta(int x) {
        Respuesta aux = new Respuesta(x, id);
        respuestas.put(x, aux);
        aux.guardarEnCsv();
    }
    
    public int listar(Consulta c) {
    	
    	if(getRespuesta(c.getIdConsulta()) == null) return c.getIdConsulta();
		
    	return -1;
    }
    
    public int getsizeMap(Persona p) {
    	int tam = p.respuestas.size();
    	return tam;
    }
    
    public void setRespuesta(int idPregunta, int idCreador, String respuesta) {
        Respuesta aux = new Respuesta(idPregunta, idCreador, respuesta);
        respuestas.put(idPregunta,aux);
    }
    
    public Respuesta getRespuesta(int id_pregunta) {
    	return respuestas.get(id_pregunta);
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