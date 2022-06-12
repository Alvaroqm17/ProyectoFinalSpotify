package exceptions;

/**
 * Clase que crea una exception para proteger el error de emails que no contengan el @ y controlar dicho error
 * 
 * @author Alvaro Quiñones Melero
 *
 */

public class EmailIncorrectoException extends Exception{
	public EmailIncorrectoException(String msg) {
		super(msg);
	}
}
