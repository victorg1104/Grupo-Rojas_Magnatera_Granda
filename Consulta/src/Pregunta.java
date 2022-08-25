public class Pregunta {
	// Declaracion de atributos
	int idPregunta, idCreador;
	String Descripcion;
	
	//Constructor
	public Pregunta() {
		idPregunta = 0;
		idCreador = 0;
		Descripcion = "";
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
