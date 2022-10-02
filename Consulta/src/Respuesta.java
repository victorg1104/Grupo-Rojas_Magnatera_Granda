import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Respuesta extends Consulta{
    public Respuesta(int idPregunta, int idCreador, String descripcion){
        super(idPregunta, idCreador, descripcion);
    }

    public Respuesta(int idPregunta, int idCreador) {
        this.idPregunta = idPregunta;
        this.idCreador = idCreador;
        descripcion = "";
    }

    public void guardarEnCsv() {
        try {
            String content = "\n"+ String.valueOf(idPregunta)+
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