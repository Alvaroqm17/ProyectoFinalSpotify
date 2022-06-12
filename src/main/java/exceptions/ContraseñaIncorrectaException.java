package exceptions;

/**
 * Clase que crea una exception para proteger el error de contaseñas incorrectas y controlar dicho error
 * 
 * @author Alvaro Quiñones Melero
 *
 */

public class ContraseñaIncorrectaException extends Exception {
	public ContraseñaIncorrectaException(String msg) {
		super(msg);
	}
}
