import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Consulta {
	// Declaracion de atributos
	private int idPregunta, idCreador;
	private String descripcion;
	private ArrayList<Persona> personas;

	// Constructor
	public Consulta() {

		idPregunta = 0;
		idCreador = 0;
		descripcion = "";
		personas = new ArrayList<Persona>();

	}

	//
	public void addPersonas(Persona personaX) {
		Persona perso = new Persona();
		boolean flag = true;
		for (int i = 0; i < personas.size(); i++) {
			perso = personas.get(i);
			if (personaX.getId() == perso.getId()) {
				flag = false;
			}
		}
		if (flag) {
			personas.add(personaX);
		}
	}

	public void newConsulta() {
		try {
	        String content = "\n"+ String.valueOf(idPregunta)+
	        		";"+
	        		String.valueOf(idCreador)+
	        		";"+
	        		descripcion;

	        File file = new File("src/bd_consultas.csv");

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
	// Getter y Setter

	public int getIdConsulta() {
		return idPregunta;
	}

	public void setIdConsulta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public int getIdCreador() {
		return idCreador;
	}

	public void setIdCreador(int idCreador) {
		this.idCreador = idCreador;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
