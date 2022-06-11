package clases;

import java.sql.SQLException;

import exceptions.ContraseñaIncorrectaException;
import exceptions.UsuarioNoExisteException;

public class Artista extends Usuario{
	private Biblioteca discografia;

	public Artista(String nombre, String contraseña) throws SQLException, ContraseñaIncorrectaException, UsuarioNoExisteException {
		super(nombre, contraseña);
		// TODO Auto-generated constructor stub
	}


	public Biblioteca getDiscografia() {
		return discografia;
	}

	public void setDiscografia(Biblioteca discografia) {
		this.discografia = discografia;
	}

}
