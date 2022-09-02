
public class Respuesta {
	private int idRespuesta, idConsulta, idPersona;
	private String respuestaConsulta;
	
	//Constructor
	public Respuesta() {
		
		idConsulta = 0;
		idPersona = 0;
		respuestaConsulta = "";
	}

	public int getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdPregunta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getrespuestaConsulta() {
		return respuestaConsulta;
	}

	public void setRespuesta_pregunta(String respuestaConsulta) {
		this.respuestaConsulta = respuestaConsulta;
	}
	
	
	
	
	
	
	// Getter y Setter 
	
	 

}
