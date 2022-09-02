import java.util.ArrayList;

public class Pregunta {
	// Declaracion de atributos
	private int idPregunta, idCreador;
	private String Descripcion;
	private ArrayList<Persona> personas;
	
	//Constructor
	public Pregunta() {
		
		idPregunta = 0;
		idCreador = 0;
		Descripcion = "";
		personas = new ArrayList<Persona>();
		
	}
	
	//
	public void addPersonas(Persona personaX) {
		Persona perso = new Persona();
		boolean flag = true;
		for(int i = 0; i < personas.size(); i++) {
			
			perso = personas.get(i);
			if(personaX.GetId() == perso.GetId()) {
				flag = false;
			}
		}
		
		if(flag) {
			personas.add(personaX);
		}
		
	}
	
	public ArrayList<Persona> getPersonas() {
		return personas;
	}
	
	
	
	// Getter y Setter
	
	
	
	
	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}
	public int getIdCreador() {
		return idCreador;
	}
	public void setIdCreador(int idCreador) {
		this.idCreador = idCreador;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}	
}
