import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


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
        Respuesta aux = new Respuesta(respuestas.size(), x, id, respuesta);
        respuestas.put(respuestas.size(), aux);
        aux.guardarEnCsv();
    }
    
    public void newRespuesta(int x) {
        Respuesta aux = new Respuesta(x, id);
        respuestas.put(x, aux);
        aux.guardarEnCsv();
    }
    
    public void editarRespuesta(String idPregunta, Persona usuario, String respuesta){
    	for (Map.Entry<Integer, Respuesta> entry : respuestas.entrySet()) {
   	     	Respuesta r = entry.getValue();
   	     	if (r.getIdConsulta() == Integer.parseInt(idPregunta)) {
   	     		r.setDescripcion(respuesta);
   	     	}
    	}
    }
    
    public void eliminarRespuesta(String idRespuesta, Persona usuario){
     	usuario.respuestas.remove(Integer.parseInt(idRespuesta));
	}
    
    public String getIdRespuesta(String id) {
    	for (Map.Entry<Integer, Respuesta> entry : respuestas.entrySet()) {
   	     	Respuesta r = entry.getValue();
   	     	if (r.getIdConsulta() == Integer.parseInt(id)) {
   	     		return String.valueOf(r.idRespuesta);
   	     	}
    	}
    	return null;
    }
    
    public int buscar(int idConsulta){
    	for (Map.Entry<Integer, Respuesta> entry : respuestas.entrySet()) {
    	     Respuesta r = entry.getValue();
    	     if (r.getIdConsulta() == idConsulta) return -1;
    	}
    	return idConsulta;
    }
    public int getsizeMap(Persona p) {
    	int tam = p.respuestas.size();
    	return tam;
    }
    
    public HashMap<Integer, Respuesta> getMap() {
    	return respuestas;
    }
    
    public void setRespuesta(int idRespuesta,int idPregunta, int idCreador, String respuesta) {
        Respuesta aux = new Respuesta(idRespuesta, idPregunta, idCreador, respuesta);
        respuestas.put(idRespuesta,aux);
    }
    
    public Respuesta getRespuesta(int id_respuesta) {
    	return respuestas.get(id_respuesta);
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