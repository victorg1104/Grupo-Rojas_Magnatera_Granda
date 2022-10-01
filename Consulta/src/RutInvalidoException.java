public class RutInvalidoException extends Exception{
	public RutInvalidoException() {
		super("El rut ingresado no es válido");
	}
	
	public String mostrarMensajeError() {
		return "Rut inválido, intente nuevamente: ";
	}
}
