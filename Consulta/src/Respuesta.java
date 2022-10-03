import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Respuesta extends Consulta{
	
	public int idRespuesta;
	
    public Respuesta(int idRespuesta, int idPregunta, int idCreador, String descripcion){
        super(idPregunta, idCreador, descripcion);
        this.idRespuesta = idRespuesta;
    }
    
    public Respuesta(int idPregunta, int idCreador) {
        this.idPregunta = idPregunta;
        this.idCreador = idCreador;
        descripcion = "";
    }
    
    public int getIdRespuesta() {
    	return idRespuesta;
    }
    
    public void guardarEnCsv() {
        try {
            String content = "\n"+ String.valueOf(idRespuesta)+
            		";"+
            		String.valueOf(idPregunta)+
                    ";"+
                    String.valueOf(idCreador)+
                    ";"+
                    descripcion;

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
}