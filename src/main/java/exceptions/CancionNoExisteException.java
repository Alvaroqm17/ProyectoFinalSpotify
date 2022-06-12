package exceptions;

/**
 * Clase que crea una exception para proteger el error de canciones que no existan y controlar dicho error
 * 
 * @author Alvaro Quiñones Melero
 *
 */

public class CancionNoExisteException extends Exception {
	public CancionNoExisteException(String msg) {
		super(msg);
	}
}
