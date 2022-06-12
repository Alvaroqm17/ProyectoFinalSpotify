package exceptions;

/**
 * Clase que crea una exception para proteger el error de contase�as incorrectas y controlar dicho error
 * 
 * @author Alvaro Qui�ones Melero
 *
 */

public class Contrase�aIncorrectaException extends Exception {
	public Contrase�aIncorrectaException(String msg) {
		super(msg);
	}
}
