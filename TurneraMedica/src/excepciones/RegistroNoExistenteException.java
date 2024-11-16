package excepciones;

public class RegistroNoExistenteException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegistroNoExistenteException(String mensaje) {
        super(mensaje);
    }
}
