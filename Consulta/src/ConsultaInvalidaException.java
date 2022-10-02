public class ConsultaInvalidaException extends Exception{
    public ConsultaInvalidaException() {
        super();
    }

    public String mostrarMensajeError() {
        return "El id de consulta ingresado no es válido, intente nuevamente";
    }

    public String mostrarMensajeRepetido() {
        return "Usted ya ha respondido a esta pregunta";
    }
}