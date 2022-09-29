public class RutInvalidoException extends Exception{
	public RutInvalidoException() {
		super("El rut ingresado no es válido");
	}
	
	public void mostrarMensajeError() {
		System.out.println("Rut inválido, intente nuevamente: ");
	}
}
