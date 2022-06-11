package clases;

import java.sql.SQLException;

import exceptions.Contrase�aIncorrectaException;
import exceptions.UsuarioNoExisteException;

public class Artista extends Usuario{
	private Biblioteca discografia;

	public Artista(String nombre, String contrase�a) throws SQLException, Contrase�aIncorrectaException, UsuarioNoExisteException {
		super(nombre, contrase�a);
		// TODO Auto-generated constructor stub
	}


	public Biblioteca getDiscografia() {
		return discografia;
	}

	public void setDiscografia(Biblioteca discografia) {
		this.discografia = discografia;
	}

}
