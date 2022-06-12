package exceptions;

/**
 * Clase que crea una exception para proteger el error de usuarios que no existan y controlar dicho error
 * 
 * @author Alvaro Qui�ones Melero
 *
 */

public class UsuarioNoExisteException extends Exception {
	public UsuarioNoExisteException(String msg) {
		super(msg);
		
	}
}