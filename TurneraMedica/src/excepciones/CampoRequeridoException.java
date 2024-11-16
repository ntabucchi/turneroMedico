package excepciones;

public class CampoRequeridoException extends Exception {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CampoRequeridoException(String mensaje) {
        super(mensaje);
    }
}
